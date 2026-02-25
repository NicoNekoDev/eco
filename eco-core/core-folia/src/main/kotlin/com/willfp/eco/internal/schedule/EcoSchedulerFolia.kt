package com.willfp.eco.internal.schedule

import com.willfp.eco.core.EcoPlugin
import com.willfp.eco.core.scheduling.EcoWrappedTask
import com.willfp.eco.core.scheduling.Scheduler
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.scheduler.BukkitTask
import java.util.concurrent.CountDownLatch
import java.util.concurrent.FutureTask
import java.util.concurrent.TimeUnit

class EcoSchedulerFolia(private val plugin: EcoPlugin) : Scheduler {
    @Deprecated("Deprecated")
    override fun runTaskLater(
        task: FutureTask<*>,
        ticksLater: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getGlobalRegionScheduler().runDelayed(plugin, { task.run() }, ticksLater)
        )
    }

    override fun runTaskLater(
        task: FutureTask<*>,
        location: Location,
        ticksLater: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getRegionScheduler().runDelayed(plugin, location, { task.run() }, ticksLater)
        )
    }

    override fun runTaskLater(
        task: FutureTask<*>,
        entity: Entity,
        ticksLater: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            entity.scheduler.runDelayed(plugin, { task.run() }, null, ticksLater)!!
        )
    }

    override fun runTaskLater(
        task: FutureTask<*>,
        entities: List<Entity>,
        ticksLater: Long
    ) {
        runTaskLater(ticksLater) {
            runTask(entities, task)
        }
    }

    @Deprecated("Deprecated")
    override fun runTimer(
        runnable: Runnable,
        delay: Long,
        repeat: Long
    ): BukkitTask {
        return Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, repeat)
    }

    override fun runTaskTimer(
        runnable: Runnable,
        delay: Long,
        repeat: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getGlobalRegionScheduler().runAtFixedRate(plugin, { runnable.run() }, delay, repeat)
        )
    }

    override fun runTaskTimer(
        runnable: Runnable,
        location: Location,
        delay: Long,
        repeat: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getRegionScheduler().runAtFixedRate(plugin, location, { runnable.run() }, delay, repeat)
        )
    }

    override fun runTaskTimer(
        runnable: Runnable,
        entity: Entity,
        delay: Long,
        repeat: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            entity.scheduler.runAtFixedRate(plugin, { runnable.run() }, null, delay, repeat)!!
        )
    }

    @Deprecated("Deprecated")
    override fun runAsyncTimer(
        runnable: Runnable,
        delay: Long,
        repeat: Long
    ): BukkitTask {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, repeat)
    }

    override fun runTaskAsyncTimer(
        runnable: Runnable,
        delay: Long,
        repeat: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getAsyncScheduler()
                .runAtFixedRate(plugin, { runnable.run() }, delay * 50L, repeat * 50L, TimeUnit.MILLISECONDS)
        )
    }

    @Deprecated("Deprecated")
    override fun run(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTask(plugin, runnable)
    }

    override fun runTask(
        task: FutureTask<*>
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getGlobalRegionScheduler().run(plugin) { task.run() }
        )
    }

    override fun runTask(
        location: Location,
        task: FutureTask<*>
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getRegionScheduler().run(plugin, location) { task.run() }
        )
    }

    override fun runTask(
        entity: Entity,
        task: FutureTask<*>
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            entity.scheduler.run(plugin, { task.run() }, null)!!
        )
    }

    override fun runTask(
        entities: List<Entity>,
        task: FutureTask<*>
    ) {
        val ownedByEntities = entities.filter { Bukkit.isOwnedByCurrentRegion(it) }
        val notOwnedByEntities = entities.filterNot { Bukkit.isOwnedByCurrentRegion(it) }

        val startSignal = CountDownLatch(notOwnedByEntities.size)
        val finishSignal = CountDownLatch(1)
        for (entity in notOwnedByEntities) {
            runTask(entity) {
                startSignal.countDown()
                finishSignal.await()
            }
        }

        val runnable: Runnable = {
            startSignal.await()
            task.run()
            finishSignal.countDown()
        }

        if (ownedByEntities.isNotEmpty())
            runTask(runnable)
        else
            runnable.run()
    }

    @Deprecated("Deprecated")
    override fun runAsync(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable)
    }

    override fun runTaskAsync(task: FutureTask<*>): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getAsyncScheduler().runNow(plugin) { task.run() }
        )
    }

    override fun cancelAll() {
        Bukkit.getAsyncScheduler().cancelTasks(plugin)
        Bukkit.getGlobalRegionScheduler().cancelTasks(plugin)
    }
}