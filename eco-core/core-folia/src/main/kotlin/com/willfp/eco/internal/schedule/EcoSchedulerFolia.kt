package com.willfp.eco.internal.schedule

import com.willfp.eco.core.EcoPlugin
import com.willfp.eco.core.scheduling.EcoWrappedTask
import com.willfp.eco.core.scheduling.Scheduler
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.scheduler.BukkitTask
import java.util.concurrent.TimeUnit

class EcoSchedulerFolia(private val plugin: EcoPlugin) : Scheduler {
    @Deprecated("Deprecated")
    override fun runTaskLater(
        runnable: Runnable,
        ticksLater: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getGlobalRegionScheduler().runDelayed(plugin, { runnable.run() }, ticksLater)
        )
    }

    override fun runTaskLater(
        runnable: Runnable,
        location: Location,
        ticksLater: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getRegionScheduler().runDelayed(plugin, location, { runnable.run() }, ticksLater)
        )
    }

    override fun runTaskLater(
        runnable: Runnable,
        entity: Entity,
        ticksLater: Long
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            entity.scheduler.runDelayed(plugin, { runnable.run() }, null, ticksLater)!!
        )
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
        runnable: Runnable
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getGlobalRegionScheduler().run(plugin) { runnable.run() }
        )
    }

    override fun runTask(
        location: Location,
        runnable: Runnable
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getRegionScheduler().run(plugin, location) { runnable.run() }
        )
    }

    override fun runTask(
        entity: Entity,
        runnable: Runnable
    ): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            entity.scheduler.run(plugin, { runnable.run() }, null)!!
        )
    }

    @Deprecated("Deprecated")
    override fun runAsync(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable)
    }

    @Deprecated("Deprecated")
    override fun runTaskAsync(runnable: Runnable): EcoWrappedTask {
        return EcoWrappedTaskFolia(
            Bukkit.getAsyncScheduler().runNow(plugin) { runnable.run() }
        )
    }

    override fun cancelAll() {
        Bukkit.getAsyncScheduler().cancelTasks(plugin)
        Bukkit.getGlobalRegionScheduler().cancelTasks(plugin)
    }
}