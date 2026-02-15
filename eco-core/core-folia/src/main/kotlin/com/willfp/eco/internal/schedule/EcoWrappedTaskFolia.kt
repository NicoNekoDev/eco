package com.willfp.eco.internal.schedule

import com.willfp.eco.core.scheduling.EcoWrappedTask
import io.papermc.paper.threadedregions.scheduler.ScheduledTask

class EcoWrappedTaskFolia(val task: ScheduledTask) : EcoWrappedTask {
    val clazz = runCatching { Class.forName("io.papermc.paper.threadedregions.scheduler.FoliaAsyncScheduler.AsyncScheduledTask") }.getOrNull()

    override fun cancel() {
        task.cancel()
    }

    override fun isCancelled(): Boolean {
        return task.isCancelled
    }

    override fun isAsync(): Boolean {
        return this.clazz != null && this.clazz.isAssignableFrom(task::class.java)
    }
}