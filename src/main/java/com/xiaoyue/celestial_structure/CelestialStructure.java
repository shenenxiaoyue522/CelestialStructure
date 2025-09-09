package com.xiaoyue.celestial_structure;

import com.mojang.logging.LogUtils;
import com.xiaoyue.celestial_structure.data.CSTagGen;
import com.xiaoyue.celestial_structure.data.StructureGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import static com.xiaoyue.celestial_structure.CelestialStructure.MODID;

@Mod(MODID)
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CelestialStructure
{
    public static final String MODID = "celestial_structure";
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public CelestialStructure() {
    }

    @SubscribeEvent
    public static void  onGatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        boolean server = event.includeServer();
        gen.addProvider(server, new StructureGen(output, event.getLookupProvider()));
        gen.addProvider(server, new CSTagGen(output, event.getLookupProvider(), event.getExistingFileHelper()));
    }

    public static ResourceLocation loc(String s) {
        return new ResourceLocation(MODID, s);
    }
}
