package com.evoli.azalea_hedges.data.basic;

import com.evoli.azalea_hedges.registry.AzaleaHedgeBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.Objects;
import java.util.function.Consumer;

public class HedgesRecipes extends RecipeProvider {
    public HedgesRecipes(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        this.shapedRecipeWithCriterion(AzaleaHedgeBlocks.AZALEA_HEDGE.get(), Blocks.AZALEA, 4)
                .pattern("##")
                .pattern("##")
                .define('#', Blocks.AZALEA)
                .save(consumer);

        this.shapedRecipeWithCriterion(AzaleaHedgeBlocks.FLOWERING_AZALEA_HEDGE.get(), Blocks.FLOWERING_AZALEA, 4)
                .pattern("##")
                .pattern("##")
                .define('#', Blocks.FLOWERING_AZALEA)
                .save(consumer);
    }

    private ShapedRecipeBuilder shapedRecipeWithCriterion(ItemLike result, ItemLike criterionItem, int count) {
        String criterionName = Objects.requireNonNull(result.asItem().getRegistryName()).getPath();
        return new ShapedRecipeBuilder(result, count).unlockedBy("has_" + criterionName, has(criterionItem));
    }
}