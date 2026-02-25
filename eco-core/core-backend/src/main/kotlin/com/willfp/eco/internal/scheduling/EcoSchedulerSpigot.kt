package com.willfp.eco.internal.scheduling

import com.willfp.eco.core.EcoPlugin
import com.willfp.eco.core.scheduling.Scheduler
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.scheduler.BukkitTask
import java.util.concurrent.FutureTask

class EcoSchedulerSpigot(private val plugin: EcoPlugin) : Scheduler {
    @Deprecated("Deprecated")
    override fun runLater(
        runnable: Runnable,
        ticksLater: Long
    ): BukkitTask {
        return Bukkit.getScheduler().runTaskLater(plugin, runnable, ticksLater)
    }

    override fun runTaskLater(
        task: FutureTask<*>,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTaskLater(plugin, task, ticksLater)
        )
    }

    override fun runTaskLater(
        task: FutureTask<*>,
        location: Location,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return runTaskLater(task, ticksLater)
    }

    override fun runTaskLater(
        task: FutureTask<*>,
        entity: Entity,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return runTaskLater(task, ticksLater)
    }

    override fun runTaskLater(
        task: FutureTask<*>,
        entities: List<Entity>,
        ticksLater: Long
    ) {
        runTaskLater(task, ticksLater)
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
    ): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, repeat), true
        )
    }

    override fun runTaskTimer(
        runnable: Runnable,
        location: Location,
        delay: Long,
        repeat: Long
    ): EcoWrappedTaskSpigot {
        return runTaskTimer(runnable, delay, repeat)
    }

    override fun runTaskTimer(
        runnable: Runnable,
        entity: Entity,
        delay: Long,
        repeat: Long
    ): EcoWrappedTaskSpigot {
        return runTaskTimer(runnable, delay, repeat)
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
    ): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, repeat), true
        )
    }

    @Deprecated("Deprecated")
    override fun run(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTask(plugin, runnable)
    }

    override fun runTask(
        task: FutureTask<*>
    ): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTask(plugin, task)
        )
    }

    override fun runTask(
        location: Location,
        task: FutureTask<*>
    ): EcoWrappedTaskSpigot {
        return runTask(task)
    }

    override fun runTask(
        entity: Entity,
        task: FutureTask<*>
    ): EcoWrappedTaskSpigot {
        return runTask(task)
    }

    override fun runTask(
        entities: List<Entity>,
        task: FutureTask<*>
    ) {
        runTask(task)
    }

    @Deprecated("Deprecated")
    override fun runAsync(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable)
    }

    override fun runTaskAsync(task: FutureTask<*>): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTaskAsynchronously(plugin, task)
        )
    }

    override fun cancelAll() {
        Bukkit.getScheduler().cancelTasks(plugin)
    }
}