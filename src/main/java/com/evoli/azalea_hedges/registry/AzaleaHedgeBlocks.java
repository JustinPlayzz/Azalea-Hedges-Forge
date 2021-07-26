package com.evoli.azalea_hedges.registry;

import com.evoli.azalea_hedges.AzaleaHedges;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = AzaleaHedges.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AzaleaHedgeBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AzaleaHedges.MOD_ID);

    public static final RegistryObject<Block> AZALEA_HEDGE = registerBlock("azalea_hedge", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.AZALEA)), CreativeModeTab.TAB_BREWING);
    public static final RegistryObject<Block> FLOWERING_AZALEA_HEDGE = registerBlock("flowering_azalea_hedge", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.FLOWERING_AZALEA)), CreativeModeTab.TAB_BREWING);

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier, CreativeModeTab itemGroup) {
        RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
        AzaleaHedgeItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }
}
