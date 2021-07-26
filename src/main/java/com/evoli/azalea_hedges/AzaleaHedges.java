package com.evoli.azalea_hedges;

import com.evoli.azalea_hedges.registry.AzaleaHedgeBlocks;
import com.evoli.azalea_hedges.registry.AzaleaHedgeItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AzaleaHedges.MOD_ID)
@Mod.EventBusSubscriber(modid = AzaleaHedges.MOD_ID)
public class AzaleaHedges {

    public static final String MOD_ID = "azalea_hedges";
    private static final Logger LOGGER = LogManager.getLogger();

    public AzaleaHedges() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);

        AzaleaHedgeBlocks.BLOCKS.register(eventBus);
        AzaleaHedgeItems.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Azalealizing");
    }
}
