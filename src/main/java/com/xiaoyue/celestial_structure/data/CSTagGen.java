package com.xiaoyue.celestial_structure.data;

import com.tterrag.registrate.providers.RegistrateTagsProvider;
import com.xiaoyue.celestial_structure.CelestialStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class CSTagGen {

    public static final TagKey<Biome> IS_BIRCH = TagKey.create(Registries.BIOME, CelestialStructure.loc("generic/is_birch"));
    public static final TagKey<Biome> IS_CHERRY = TagKey.create(Registries.BIOME, CelestialStructure.loc("generic/is_cherry"));

    public static void onBiomeTagGen(RegistrateTagsProvider.IntrinsicImpl<Biome> pvd) {
        pvd.addTag(IS_BIRCH).add(Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
        pvd.addTag(IS_CHERRY).add(Biomes.CHERRY_GROVE);
    }
}
