package com.willfp.eco.internal.schedule

import com.willfp.eco.core.EcoPlugin
import com.willfp.eco.core.scheduling.RunnableTask
import org.bukkit.Bukkit
import java.util.concurrent.TimeUnit

abstract class EcoRunnableTaskFolia(protected val plugin: EcoPlugin) : RunnableTask {
    private var task: EcoWrappedTaskFolia? = null

    @Synchronized
    override fun runTask(): EcoWrappedTaskFolia {
        task = EcoWrappedTaskFolia(Bukkit.getGlobalRegionScheduler().run(plugin) { this.run() })
        return task!!
    }

    @Synchronized
    override fun runTaskAsynchronously(): EcoWrappedTaskFolia {
        task = EcoWrappedTaskFolia(Bukkit.getAsyncScheduler().runNow(plugin) { this.run() })
        return task!!
    }

    @Synchronized
    override fun runTaskLater(delay: Long): EcoWrappedTaskFolia {
        task = EcoWrappedTaskFolia(Bukkit.getGlobalRegionScheduler().runDelayed(plugin, { this.run() }, delay))
        return task!!
    }

    @Synchronized
    override fun runTaskLaterAsynchronously(delay: Long): EcoWrappedTaskFolia {
        task = EcoWrappedTaskFolia(
            Bukkit.getAsyncScheduler().runDelayed(plugin, { this.run() }, delay * 50L, TimeUnit.MILLISECONDS)
        )
        return task!!
    }

    @Synchronized
    override fun runTaskTimer(delay: Long, period: Long): EcoWrappedTaskFolia {
        task = EcoWrappedTaskFolia(
            Bukkit.getGlobalRegionScheduler().runAtFixedRate(plugin, { this.run() }, delay, period)
        )
        return task!!
    }

    @Synchronized
    override fun runTaskTimerAsynchronously(delay: Long, period: Long): EcoWrappedTaskFolia {
        task = EcoWrappedTaskFolia(
            Bukkit.getAsyncScheduler()
                .runAtFixedRate(plugin, { this.run() }, delay * 50L, period * 50L, TimeUnit.MILLISECONDS)
        )
        return task!!
    }

    override fun cancel() {
        task?.cancel()
    }
}