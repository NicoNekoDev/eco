package com.willfp.eco.core.events;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jspecify.annotations.NonNull;

import java.util.*;

public class MultiBlockItemDropEvent extends PlayerEvent implements Cancellable {
    private final Map<Block, BlockStateAndItems> blocks;
    private boolean cancelled;

    public MultiBlockItemDropEvent(Player player, Map<Block, BlockStateAndItems> blocks) {
        super(player);
        this.blocks = blocks;
    }

    public BlockState getBlockState(Block block) {
        return blocks.get(block).blockState;
    }

    public List<Item> getItems(Block block) {
        return blocks.get(block).items;
    }

    public Collection<Block> getBlocks() {
        return blocks.keySet();
    }

    public Map<Block, BlockStateAndItems> getMap() {
        return this.blocks;
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

    public record BlockStateAndItems(BlockState blockState, List<Item> items) { }
}
