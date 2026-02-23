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
        runnable: FutureTask<*>,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTaskLater(plugin, runnable, ticksLater)
        )
    }

    override fun runTaskLater(
        runnable: FutureTask<*>,
        location: Location,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return runTaskLater(runnable, ticksLater)
    }

    override fun runTaskLater(
        runnable: FutureTask<*>,
        entity: Entity,
        ticksLater: Long
    ): EcoWrappedTaskSpigot {
        return runTaskLater(runnable, ticksLater)
    }

    override fun runTaskLater(
        runnable: FutureTask<*>,
        entities: List<Entity>,
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
        runnable: FutureTask<*>
    ): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTask(plugin, runnable)
        )
    }

    override fun runTask(
        location: Location,
        runnable: FutureTask<*>
    ): EcoWrappedTaskSpigot {
        return runTask(runnable)
    }

    override fun runTask(
        entity: Entity,
        runnable: FutureTask<*>
    ): EcoWrappedTaskSpigot {
        return runTask(runnable)
    }

    override fun runTask(
        entities: List<Entity>,
        runnable: FutureTask<*>
    ): EcoWrappedTaskSpigot {
        return runTask(runnable)
    }

    @Deprecated("Deprecated")
    override fun runAsync(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable)
    }

    override fun runTaskAsync(runnable: FutureTask<*>): EcoWrappedTaskSpigot {
        return EcoWrappedTaskSpigot(
            Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable)
        )
    }

    override fun cancelAll() {
        Bukkit.getScheduler().cancelTasks(plugin)
    }
}