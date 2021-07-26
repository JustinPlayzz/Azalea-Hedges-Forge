package com.evoli.azalea_hedges.data.basic;

import com.evoli.azalea_hedges.AzaleaHedges;
import com.evoli.azalea_hedges.registry.AzaleaHedgeBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class HedgesStates extends BlockStateProvider {
    public HedgesStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, AzaleaHedges.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.pillowBlock(AzaleaHedgeBlocks.AZALEA_HEDGE.get());
        this.pillowBlock(AzaleaHedgeBlocks.FLOWERING_AZALEA_HEDGE.get());
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    private ResourceLocation texture(String path) {
        return new ResourceLocation(AzaleaHedges.MOD_ID, ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    private void pillowBlock(Block pillowBlock) {
        String name = pillowBlock.getRegistryName().getPath();
        ModelFile model = models().withExistingParent(name(pillowBlock), "minecraft:block/cube_column")
                .texture("end", texture(name) + "_top")
                .texture("side", texture(name + "_side"));

        getVariantBuilder(pillowBlock)
                .forAllStates((state) -> ConfiguredModel.builder()
                        .modelFile(model)
                        .build());
        simpleBlockItem(pillowBlock, model);
    }
}