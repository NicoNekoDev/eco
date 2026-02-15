package com.willfp.eco.core.scheduling

interface EcoWrappedTask {
    fun cancel()

    fun isCancelled(): Boolean

    /**
     * Whether the task is async or not.
     * <p>
     * Async tasks are never run on any world threads, including on Folia.
     *
     * @return true if the task is async
     */
    fun isAsync(): Boolean
}