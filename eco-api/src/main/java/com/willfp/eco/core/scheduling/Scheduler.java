package com.willfp.eco.core.scheduling;

import com.willfp.eco.core.EcoPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * Thread scheduler to handle tasks and asynchronous code.
 */
public interface Scheduler {
    /**
     * Run the task after a specified tick delay.
     *
     * @param runnable   The lambda to run.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link BukkitTask}.
     * @deprecated Deprecated in favor of Folia support.
     */
    @Deprecated(since = "6.77.3")
    default BukkitTask runLater(@NotNull Runnable runnable,
                                long ticksLater) {
        return (BukkitTask) runTaskLater(runnable, ticksLater);
    }

    /**
     * Run the task after a specified tick delay.
     *
     * @param task       The task to run.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskLater(@NotNull FutureTask<?> task,
                                long ticksLater);

    /**
     * Run the task after a specified tick delay.
     *
     * @param runnable   The lambda to run.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull Runnable runnable,
                                        long ticksLater) {
        return runTaskLater(new FutureTask<>(runnable, null), ticksLater);
    }

    /**
     * Run the task after a specified tick delay at a given location.
     *
     * @param task       The task to run.
     * @param location   The location to run at.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskLater(@NotNull FutureTask<?> task,
                                @NotNull Location location,
                                long ticksLater);

    /**
     * Run the task after a specified tick delay at a given location.
     *
     * @param runnable   The lambda to run.
     * @param location   The location to run at.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull Runnable runnable,
                                        @NotNull Location location,
                                        long ticksLater) {
        return runTaskLater(new FutureTask<>(runnable, null), location, ticksLater);
    }

    /**
     * Run the task after a specified tick delay for a given entity.
     *
     * @param task       The task to run.
     * @param entity     The entity to run for.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskLater(@NotNull FutureTask<?> task,
                                @NotNull Entity entity,
                                long ticksLater);

    /**
     * Run the task after a specified tick delay for a given entity.
     *
     * @param runnable   The lambda to run.
     * @param entity     The entity to run for.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull Runnable runnable,
                                        @NotNull Entity entity,
                                        long ticksLater) {
        return runTaskLater(new FutureTask<>(runnable, null), entity, ticksLater);
    }

    /**
     * Run the task after a specified tick delay for all given entities, in sync with the server.
     * Warn: for Folia it suspends all threads until the task is finished
     *
     * @param task       The task to run.
     * @param entities   The entities to run for.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskLater(@NotNull FutureTask<?> task,
                                @NotNull List<Entity> entities,
                                long ticksLater);

    /**
     * Run the task after a specified tick delay for all given entities, in sync with the server.
     * Warn: for Folia it suspends all threads until the task is finished
     *
     * @param runnable   The lambda to run.
     * @param entities   The entities to run for.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull Runnable runnable,
                                        @NotNull List<Entity> entities,
                                        long ticksLater) {
        return runTaskLater(new FutureTask<>(runnable, null), entities, ticksLater);
    }

    /**
     * Run the task after a specified tick delay.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable   The lambda to run.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     * @deprecated Deprecated in favor of Folia support.
     */
    @Deprecated(since = "6.77.3")
    default BukkitTask runLater(long ticksLater,
                                @NotNull Runnable runnable) {
        return runLater(runnable, ticksLater);
    }

    /**
     * Run the task after a specified tick delay.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param task       The task to run.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(long ticksLater,
                                        @NotNull FutureTask<?> task) {
        return runTaskLater(task, ticksLater);
    }

    /**
     * Run the task after a specified tick delay.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable   The lambda to run.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(long ticksLater,
                                        @NotNull Runnable runnable) {
        return runTaskLater(runnable, ticksLater);
    }

    /**
     * Run the task after a specified tick delay at a given location.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param task       The task to run.
     * @param location   The location to run at.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull Location location,
                                        long ticksLater,
                                        @NotNull FutureTask<?> task) {
        return runTaskLater(task, location, ticksLater);
    }

    /**
     * Run the task after a specified tick delay at a given location.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable   The lambda to run.
     * @param location   The location to run at.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull Location location,
                                        long ticksLater,
                                        @NotNull Runnable runnable) {
        return runTaskLater(runnable, location, ticksLater);
    }

    /**
     * Run the task after a specified tick delay for a given entity.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param task       The task to run.
     * @param entity     The entity to run for.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull Entity entity,
                                        long ticksLater,
                                        @NotNull FutureTask<?> task) {
        return runTaskLater(task, entity, ticksLater);
    }

    /**
     * Run the task after a specified tick delay for a given entity.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable   The lambda to run.
     * @param entity     The entity to run for.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull Entity entity,
                                        long ticksLater,
                                        @NotNull Runnable runnable) {
        return runTaskLater(runnable, entity, ticksLater);
    }

    /**
     * Run the task after a specified tick delay for all given entities, in sync with the server.
     * Warn: for Folia it suspends all threads until the task is finished
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable   The lambda to run.
     * @param entities   The entities to run for.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull List<Entity> entities,
                                        long ticksLater,
                                        @NotNull Runnable runnable) {
        return runTaskLater(runnable, entities, ticksLater);
    }

    /**
     * Run the task after a specified tick delay for all given entities, in sync with the server.
     * Warn: for Folia it suspends all threads until the task is finished
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param task       The task to run.
     * @param entities   The entities to run for.
     * @param ticksLater The amount of ticks to wait before execution.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskLater(@NotNull List<Entity> entities,
                                        long ticksLater,
                                        @NotNull FutureTask<?> task) {
        return runTaskLater(task, entities, ticksLater);
    }

    /**
     * Run the task repeatedly on a timer.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link BukkitTask}.
     * @deprecated Deprecated in favor of Folia support.
     */
    @Deprecated(since = "6.77.3")
    BukkitTask runTimer(@NotNull Runnable runnable,
                        long delay,
                        long repeat);

    /**
     * Run the task repeatedly on a timer.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskTimer(@NotNull Runnable runnable,
                                long delay,
                                long repeat);

    /**
     * Run the task repeatedly on a timer at a given location.
     *
     * @param runnable The lambda to run.
     * @param location The location to run at.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskTimer(@NotNull Runnable runnable,
                                @NotNull Location location,
                                long delay,
                                long repeat);

    /**
     * Run the task repeatedly on a timer for a given entity.
     *
     * @param runnable The lambda to run.
     * @param entity   The entity to run for.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskTimer(@NotNull Runnable runnable,
                                @NotNull Entity entity,
                                long delay,
                                long repeat);

    /**
     * Run the task repeatedly on a timer.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link BukkitTask}.
     * @deprecated Deprecated in favor of Folia support.
     */
    @Deprecated(since = "6.77.3")
    default BukkitTask runTimer(long delay,
                                long repeat,
                                @NotNull Runnable runnable) {
        return runTimer(runnable, delay, repeat);
    }

    /**
     * Run the task repeatedly on a timer.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskTimer(long delay,
                                        long repeat,
                                        @NotNull Runnable runnable) {
        return runTaskTimer(runnable, delay, repeat);
    }

    /**
     * Run the task repeatedly on a timer at a given location.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param location The location to run at.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskTimer(@NotNull Location location,
                                        long delay,
                                        long repeat,
                                        @NotNull Runnable runnable) {
        return runTaskTimer(runnable, location, delay, repeat);
    }

    /**
     * Run the task repeatedly on a timer for a given entity.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param entity   The entity to run for.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskTimer(@NotNull Entity entity,
                                        long delay,
                                        long repeat,
                                        @NotNull Runnable runnable) {
        return runTaskTimer(runnable, entity, delay, repeat);
    }

    /**
     * Run the task repeatedly and asynchronously on a timer.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     * @deprecated Deprecated in favor of Folia support.
     */
    @Deprecated(since = "6.77.3")
    BukkitTask runAsyncTimer(@NotNull Runnable runnable,
                             long delay,
                             long repeat);

    /**
     * Run the task repeatedly and asynchronously on a timer.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskAsyncTimer(@NotNull Runnable runnable,
                                     long delay,
                                     long repeat);

    /**
     * Run the task repeatedly and asynchronously on a timer.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link BukkitTask}.
     * @deprecated Deprecated in favor of Folia support.
     */
    @Deprecated(since = "6.77.3")
    default BukkitTask runAsyncTimer(long delay,
                                     long repeat,
                                     @NotNull Runnable runnable) {
        return runAsyncTimer(runnable, delay, repeat);
    }

    /**
     * Run the task repeatedly and asynchronously on a timer.
     * <p>
     * Reordered for better kotlin interop.
     *
     * @param runnable The lambda to run.
     * @param delay    The amount of ticks to wait before the first execution.
     * @param repeat   The amount of ticks to wait between executions.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskAsyncTimer(long delay,
                                             long repeat,
                                             @NotNull Runnable runnable) {
        return runTaskAsyncTimer(runnable, delay, repeat);
    }

    /**
     * Run the task.
     *
     * @param runnable The lambda to run.
     * @return The created {@link EcoWrappedTask}.
     * @deprecated Deprecated in favor of Folia support.
     */
    @Deprecated(since = "6.77.3")
    BukkitTask run(@NotNull Runnable runnable);

    /**
     * Run the task.
     *
     * @param task The task to run.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTask(@NotNull FutureTask<?> task);

    /**
     * Run the task.
     *
     * @param runnable The lambda to run.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTask(@NotNull Runnable runnable) {
        return runTask(new FutureTask<>(runnable, null));
    }

    /**
     * Run the task at a given location.
     *
     * @param task     The task to run.
     * @param location The location to run at.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTask(@NotNull Location location, @NotNull FutureTask<?> task);

    /**
     * Run the task at a given location.
     *
     * @param runnable The lambda to run.
     * @param location The location to run at.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTask(@NotNull Location location, @NotNull Runnable runnable) {
        return runTask(location, new FutureTask<>(runnable, null));
    }

    /**
     * Run the task for a given entity.
     *
     * @param task   The task to run.
     * @param entity The entity to run for.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTask(@NotNull Entity entity, @NotNull FutureTask<?> task);

    /**
     * Run the task for a given entity.
     *
     * @param runnable The lambda to run.
     * @param entity   The entity to run for.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTask(@NotNull Entity entity, @NotNull Runnable runnable) {
        return runTask(entity, new FutureTask<>(runnable, null));
    }

    /**
     * Run the task for all entities, in sync with the server.
     * Warn: for Folia it suspends all threads until the task is finished
     *
     * @param task     The task to run.
     * @param entities The entities to run for.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTask(@NotNull List<Entity> entities, @NotNull FutureTask<?> task);

    /**
     * Run the task for all entities, in sync with the server.
     * Warn: for Folia it suspends all threads until the task is finished
     *
     * @param runnable The lambda to run.
     * @param entities The entities to run for.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTask(@NotNull List<Entity> entities, @NotNull Runnable runnable) {
        return runTask(entities, new FutureTask<>(runnable, null));
    }

    /**
     * Run the task asynchronously.
     *
     * @param task The task to run.
     * @return The created {@link EcoWrappedTask}.
     * @deprecated Deprecated in favor of Folia support.
     */
    @Deprecated(since = "6.77.3")
    BukkitTask runAsync(@NotNull Runnable task);

    /**
     * Run the task asynchronously.
     *
     * @param task The task to run.
     * @return The created {@link EcoWrappedTask}.
     */
    EcoWrappedTask runTaskAsync(@NotNull FutureTask<?> task);

    /**
     * Run the task asynchronously.
     *
     * @param runnable The lambda to run.
     * @return The created {@link EcoWrappedTask}.
     */
    default EcoWrappedTask runTaskAsync(@NotNull Runnable runnable) {
        return runTaskAsync(new FutureTask<>(runnable, null));
    }

    /**
     * Cancel all running tasks from the linked {@link EcoPlugin}.
     */
    void cancelAll();
}
