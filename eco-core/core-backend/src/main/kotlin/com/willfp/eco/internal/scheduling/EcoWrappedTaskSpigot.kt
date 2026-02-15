package com.willfp.eco.internal.scheduling

import com.willfp.eco.core.scheduling.EcoWrappedTask
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitTask

class EcoWrappedTaskSpigot(val task: BukkitTask) : EcoWrappedTask, BukkitTask {
    override fun cancel() {
        task.cancel()
    }

    override fun getTaskId(): Int {
        return task.taskId
    }

    override fun getOwner(): Plugin {
        return task.owner
    }

    override fun isSync(): Boolean {
        return task.isSync
    }

    override fun isCancelled(): Boolean {
        return task.isCancelled
    }

    override fun isAsync(): Boolean {
        return !task.isSync
    }
}