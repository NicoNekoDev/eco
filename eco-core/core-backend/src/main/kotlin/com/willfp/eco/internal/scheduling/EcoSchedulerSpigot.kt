package com.willfp.eco.internal.scheduling

import com.willfp.eco.core.EcoPlugin
import com.willfp.eco.core.scheduling.Scheduler
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.scheduler.BukkitTask

class EcoSchedulerSpigot(private val plugin: EcoPlugin) : Scheduler {
    @Deprecated("Deprecated")
    override fun runLater(
        runnable: Runnable,
        ticksLater: Long
    ): BukkitTask {
        return Bukkit.getScheduler().runTaskLater(plugin, runnable, ticksLater)
    }

    override fun runTaskLater(
        runnable: Runnable,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTaskLater(plugin, runnable, ticksLater)
        )
    }

    override fun runTaskLater(
        runnable: Runnable,
        location: Location,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return runTaskLater(runnable, ticksLater)
    }

    override fun runTaskLater(
        runnable: Runnable,
        entity: Entity,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return runTaskLater(runnable, ticksLater)
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
            Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, repeat)
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
            Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, repeat)
        )
    }

    @Deprecated("Deprecated")
    override fun run(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTask(plugin, runnable)
    }

    override fun runTask(
        runnable: Runnable
    ): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTask(plugin, runnable)
        )
    }

    override fun runTask(
        location: Location,
        runnable: Runnable
    ): EcoWrappedTaskSpigot {
        return runTask(runnable)
    }

    override fun runTask(
        entity: Entity,
        runnable: Runnable
    ): EcoWrappedTaskSpigot {
        return runTask(runnable)
    }

    @Deprecated("Deprecated")
    override fun runAsync(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable)
    }

    override fun runTaskAsync(runnable: Runnable): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable)
        )
    }

    override fun cancelAll() {
        Bukkit.getScheduler().cancelTasks(plugin)
    }
}