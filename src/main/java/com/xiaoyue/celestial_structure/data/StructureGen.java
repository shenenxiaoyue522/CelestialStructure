package com.xiaoyue.celestial_structure.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.xiaoyue.celestial_structure.content.StructureKey;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.xiaoyue.celestial_structure.CelestialStructure.MODID;

public class StructureGen extends DatapackBuiltinEntriesProvider {
    public StructureGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, builder(), Set.of(MODID));
    }

    public static StructureKey plains_timber_pile = StructureKey.create("plains/timber_pile");
    public static StructureKey plains_cave_house = StructureKey.create("plains/cave_house");

    public static StructureKey taiga_tower = StructureKey.create("taiga/tower");
    public static StructureKey taiga_ruined_camp = StructureKey.create("taiga/ruined_camp");
    public static StructureKey taiga_church = StructureKey.create("taiga/church");

    public static StructureKey birch_white_fountain = StructureKey.create("birch/white_fountain");

    public static StructureKey cherry_swing_camp = StructureKey.create("cherry/swing_camp");

    public static StructureKey desert_house_ruins = StructureKey.create("desert/house_ruins");
    public static StructureKey desert_well_ruins = StructureKey.create("desert/well_ruins");

    public static StructureKey jungle_tree_house = StructureKey.create("jungle/tree_house");

    public static StructureKey sky_tree_house = StructureKey.create("sky/tree_house");

    public static StructureKey nether_black_tower = StructureKey.create("nether/black_tower");

    public static RegistrySetBuilder builder() {
        RegistrySetBuilder builder = new RegistrySetBuilder();
        builder.add(Registries.TEMPLATE_POOL, c -> {
            Pools.register(c, plains_timber_pile.toString(), element(c, plains_timber_pile));
            Pools.register(c, plains_cave_house.toString(), element(c, plains_cave_house));
            Pools.register(c, taiga_tower.toString(), element(c, taiga_tower));
            Pools.register(c, taiga_ruined_camp.toString(), element(c, taiga_ruined_camp));
            Pools.register(c, taiga_church.toString(), element(c, taiga_church));
            Pools.register(c, birch_white_fountain.toString(), element(c, birch_white_fountain));
            Pools.register(c, cherry_swing_camp.toString(), element(c, cherry_swing_camp));
            Pools.register(c, desert_house_ruins.toString(), element(c, desert_house_ruins));
            Pools.register(c, desert_well_ruins.toString(), element(c, desert_well_ruins));
            Pools.register(c, jungle_tree_house.toString(), element(c, jungle_tree_house));
            Pools.register(c, sky_tree_house.toString(), element(c, sky_tree_house));
            Pools.register(c, nether_black_tower.toString(), element(c, nether_black_tower));
        });
        builder.add(Registries.STRUCTURE, c -> {
            c.register(plains_timber_pile.structure(), new JigsawStructure(biomeSet(c, BiomeTags.IS_FOREST), plains_timber_pile.startPool(c),
                    Optional.empty(), 5, ConstantHeight.of(VerticalAnchor.absolute(-1)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 65));
            c.register(plains_cave_house.structure(), new JigsawStructure(biomeSet(c, CSTagGen.GENERIC_PLAINS), plains_cave_house.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(-12)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 80));
            c.register(taiga_tower.structure(), new JigsawStructure(biomeSet(c, BiomeTags.IS_TAIGA), taiga_tower.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 80));
            c.register(taiga_ruined_camp.structure(), new JigsawStructure(biomeSet(c, BiomeTags.IS_TAIGA), taiga_ruined_camp.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 80));
            c.register(taiga_church.structure(), new JigsawStructure(biomeSet(c, BiomeTags.IS_TAIGA), taiga_church.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 70));
            c.register(birch_white_fountain.structure(), new JigsawStructure(biomeSet(c, CSTagGen.IS_BIRCH), birch_white_fountain.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 60));
            c.register(cherry_swing_camp.structure(), new JigsawStructure(biomeSet(c, CSTagGen.IS_CHERRY), cherry_swing_camp.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 60));
            c.register(desert_house_ruins.structure(), new JigsawStructure(biomeSet(c, BiomeTags.HAS_DESERT_PYRAMID), desert_house_ruins.startPool(c),
                    Optional.empty(), 4, ConstantHeight.of(VerticalAnchor.absolute(0)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 55));
            c.register(desert_well_ruins.structure(), new JigsawStructure(biomeSet(c, BiomeTags.HAS_DESERT_PYRAMID), desert_well_ruins.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 65));
            c.register(jungle_tree_house.structure(), new JigsawStructure(biomeSet(c, BiomeTags.IS_JUNGLE), jungle_tree_house.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 75));
            c.register(sky_tree_house.structure(), new JigsawStructure(biomeSet(c, BiomeTags.IS_OVERWORLD), sky_tree_house.startPool(c),
                    Optional.empty(), 7, UniformHeight.of(VerticalAnchor.absolute(180), VerticalAnchor.absolute(222)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 85));
            c.register(nether_black_tower.structure(), new JigsawStructure(biomeSet(c, BiomeTags.HAS_PILLAGER_OUTPOST), nether_black_tower.startPool(c),
                    Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(-1)), false,
                    Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 75));
        });
        builder.add(Registries.STRUCTURE_SET, c -> {
            c.register(plains_timber_pile.set(), new StructureSet(plains_timber_pile.setStr(c), new RandomSpreadStructurePlacement(
                    18, 6, RandomSpreadType.TRIANGULAR, 202552201)));
            c.register(plains_cave_house.set(), new StructureSet(plains_cave_house.setStr(c), new RandomSpreadStructurePlacement(
                    32, 16, RandomSpreadType.TRIANGULAR, 202552202)));
            c.register(taiga_tower.set(), new StructureSet(taiga_tower.setStr(c), new RandomSpreadStructurePlacement(
                    32, 16, RandomSpreadType.TRIANGULAR, 202552203)));
            c.register(taiga_ruined_camp.set(), new StructureSet(taiga_ruined_camp.setStr(c), new RandomSpreadStructurePlacement(
                    32, 16, RandomSpreadType.TRIANGULAR, 202552204)));
            c.register(taiga_church.set(), new StructureSet(taiga_church.setStr(c), new RandomSpreadStructurePlacement(
                    28, 10, RandomSpreadType.TRIANGULAR, 202552205)));
            c.register(birch_white_fountain.set(), new StructureSet(birch_white_fountain.setStr(c), new RandomSpreadStructurePlacement(
                    18, 9, RandomSpreadType.TRIANGULAR, 202552206)));
            c.register(cherry_swing_camp.set(), new StructureSet(cherry_swing_camp.setStr(c), new RandomSpreadStructurePlacement(
                    18, 9, RandomSpreadType.TRIANGULAR, 202552207)));
            c.register(desert_house_ruins.set(), new StructureSet(desert_house_ruins.setStr(c), new RandomSpreadStructurePlacement(
                    18, 7, RandomSpreadType.TRIANGULAR, 202552208)));
            c.register(desert_well_ruins.set(), new StructureSet(desert_well_ruins.setStr(c), new RandomSpreadStructurePlacement(
                    21, 12, RandomSpreadType.TRIANGULAR, 202552209)));
            c.register(jungle_tree_house.set(), new StructureSet(jungle_tree_house.setStr(c), new RandomSpreadStructurePlacement(
                    26, 10, RandomSpreadType.TRIANGULAR, 202552210)));
            c.register(sky_tree_house.set(), new StructureSet(sky_tree_house.setStr(c), new RandomSpreadStructurePlacement(
                    38, 16, RandomSpreadType.TRIANGULAR, 202552211)));
            c.register(nether_black_tower.set(), new StructureSet(nether_black_tower.setStr(c), new RandomSpreadStructurePlacement(
                    35, 13, RandomSpreadType.TRIANGULAR, 202552212)));
        });
        return builder;
    }

    private static Structure.StructureSettings biomeSet(BootstapContext<Structure> c, TagKey<Biome> tag) {
        return biomeSet(c, tag, TerrainAdjustment.NONE);
    }

    private static Structure.StructureSettings biomeSet(BootstapContext<Structure> c, TagKey<Biome> tag, TerrainAdjustment adjustment) {
        return new Structure.StructureSettings(c.lookup(Registries.BIOME).getOrThrow(tag),
                Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, adjustment);
    }

    private static StructureTemplatePool element(BootstapContext<StructureTemplatePool> c, StructureKey key) {
        Holder.Reference<StructureTemplatePool> empty = c.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY);
        Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> pair = Pair.of(SinglePoolElement.single(key.startId()), 1);
        return new StructureTemplatePool(empty, ImmutableList.of(pair), StructureTemplatePool.Projection.RIGID);
    }

}
