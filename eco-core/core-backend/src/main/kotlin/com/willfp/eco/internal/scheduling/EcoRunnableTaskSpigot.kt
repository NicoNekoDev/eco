package com.willfp.eco.internal.scheduling

import com.willfp.eco.core.EcoPlugin
import com.willfp.eco.core.scheduling.RunnableTask
import kotlinx.coroutines.Runnable
import org.bukkit.Bukkit

abstract class EcoRunnableTaskSpigot(protected val plugin: EcoPlugin) : RunnableTask {
    private var task: EcoWrappedTaskSpigot? = null

    @Synchronized
    override fun runTask(): EcoWrappedTaskSpigot {
        val runnable: Runnable = { this.run() }
        task = EcoWrappedTaskSpigot(Bukkit.getScheduler().runTask(plugin, runnable))
        return task!!
    }

    @Synchronized
    override fun runTaskAsynchronously(): EcoWrappedTaskSpigot {
        val runnable: Runnable = { this.run() }
        task = EcoWrappedTaskSpigot(Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable))
        return task!!
    }

    @Synchronized
    override fun runTaskLater(delay: Long): EcoWrappedTaskSpigot {
        val runnable: Runnable = { this.run() }
        return EcoWrappedTaskSpigot(Bukkit.getScheduler().runTaskLater(plugin, runnable, delay))
    }

    @Synchronized
    override fun runTaskLaterAsynchronously(delay: Long): EcoWrappedTaskSpigot {
        val runnable: Runnable = { this.run() }
        return EcoWrappedTaskSpigot(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, delay))
    }

    @Synchronized
    override fun runTaskTimer(delay: Long, period: Long): EcoWrappedTaskSpigot {
        val runnable: Runnable = { this.run() }
        return EcoWrappedTaskSpigot(Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, period))
    }

    @Synchronized
    override fun runTaskTimerAsynchronously(delay: Long, period: Long): EcoWrappedTaskSpigot {
        val runnable: Runnable = { this.run() }
        return EcoWrappedTaskSpigot(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, period))
    }

    override fun cancel() {
        task?.cancel()
    }
}