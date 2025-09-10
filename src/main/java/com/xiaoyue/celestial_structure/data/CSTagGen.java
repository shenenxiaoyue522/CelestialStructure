package com.xiaoyue.celestial_structure.data;

import com.xiaoyue.celestial_structure.CelestialStructure;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.xiaoyue.celestial_structure.CelestialStructure.MODID;

public class CSTagGen extends IntrinsicHolderTagsProvider<Biome> {

    public static final TagKey<Biome> IS_BIRCH = TagKey.create(Registries.BIOME, CelestialStructure.loc("generic/is_birch"));
    public static final TagKey<Biome> IS_CHERRY = TagKey.create(Registries.BIOME, CelestialStructure.loc("generic/is_cherry"));

    public static final TagKey<Biome> GENERIC_PLAINS = TagKey.create(Registries.BIOME, CelestialStructure.loc("generic_plains"));
    public static final TagKey<Biome> GENERIC_JUNGLE = TagKey.create(Registries.BIOME, CelestialStructure.loc("generic_jungle"));

    public CSTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper helper) {
        super(output, Registries.BIOME, lookup, b -> ForgeRegistries.BIOMES.getResourceKey(b).get(), MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pvd) {
        tag(IS_BIRCH).add(Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
        tag(IS_CHERRY).add(Biomes.CHERRY_GROVE);
        tag(GENERIC_PLAINS).addTag(BiomeTags.IS_FOREST).add(Biomes.PLAINS, Biomes.MEADOW);
        tag(GENERIC_JUNGLE).add(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE);
    }
}
