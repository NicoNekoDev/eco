package com.willfp.eco.core.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MultiBlockBreakEvent extends PlayerEvent implements Cancellable {
    private final Map<Block, Boolean> blocks = new HashMap<>();
    private boolean cancelled;

    public MultiBlockBreakEvent(Player player, Collection<Block> blocks) {
        super(player);
        for (Block block : blocks)
            this.blocks.put(block, true);
    }

    public Collection<Block> getBlocks() {
        return blocks.keySet();
    }

    public boolean isDropItems(Block block) {
        return blocks.get(block);
    }

    public void setDropItems(Block block, boolean dropItems) {
        if (this.blocks.containsKey(block))
            this.blocks.put(block, dropItems);
    }

    /**
     * Bukkit parity.
     */
    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public @NonNull HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Bukkit parity.
     *
     * @return The handler list.
     */
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
