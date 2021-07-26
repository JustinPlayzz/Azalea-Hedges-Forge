package com.evoli.azalea_hedges.data.basic;

import com.evoli.azalea_hedges.registry.AzaleaHedgeBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

public class HedgesTables extends BlockLoot {
    private final Set<Block> knownBlocks = new HashSet<>();

    @Override
    protected void add(Block block, LootTable.Builder table) {
        super.add(block, table);
        this.knownBlocks.add(block);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }

    @Override
    public void addTables() {
        this.dropSelf(AzaleaHedgeBlocks.AZALEA_HEDGE.get());
        this.dropSelf(AzaleaHedgeBlocks.FLOWERING_AZALEA_HEDGE.get());
    }
}