package com.evoli.azalea_hedges.data;

import com.evoli.azalea_hedges.AzaleaHedges;
import com.evoli.azalea_hedges.data.basic.HedgesRecipes;
import com.evoli.azalea_hedges.data.basic.HedgesStates;
import com.evoli.azalea_hedges.data.basic.HedgesTablesProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = AzaleaHedges.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HedgesDataGen {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator dataGen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            dataGen.addProvider(new HedgesRecipes(dataGen));
            dataGen.addProvider(new HedgesTablesProvider(dataGen));
        }
        if (event.includeClient()) {
            dataGen.addProvider(new HedgesStates(dataGen, fileHelper));
        }
    }
}
