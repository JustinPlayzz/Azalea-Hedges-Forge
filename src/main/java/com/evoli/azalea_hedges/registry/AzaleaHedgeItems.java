package com.evoli.azalea_hedges.registry;

import com.evoli.azalea_hedges.AzaleaHedges;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = AzaleaHedges.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AzaleaHedgeItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AzaleaHedges.MOD_ID);
}
