package com.xiaoyue.celestial_structure.content;

import com.xiaoyue.celestial_structure.CelestialStructure;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.jetbrains.annotations.NotNull;

public record StructureKey(ResourceLocation loc, ResourceKey<StructureTemplatePool> pool, ResourceKey<Structure> structure, ResourceKey<StructureSet> set) {

    public String path() {
        return loc.getPath();
    }

    @Override
    public @NotNull String toString() {
        return loc.toString();
    }

    public ResourceKey<StructureTemplatePool> startRes() {
        return Pools.createKey(pool.location() + "/start_pool");
    }

    public String startId() {
        return pool.location() + "/start_pool";
    }

    public Holder.Reference<StructureTemplatePool> startPool(BootstapContext<Structure> c) {
        return c.lookup(Registries.TEMPLATE_POOL).getOrThrow(pool);
    }

    public Holder.Reference<Structure> setStr(BootstapContext<StructureSet> c) {
        return c.lookup(Registries.STRUCTURE).getOrThrow(structure);
    }

    public static StructureKey create(ResourceLocation key) {
        return new StructureKey(key, Pools.createKey(key.toString()), ResourceKey.create(Registries.STRUCTURE, key),
                ResourceKey.create(Registries.STRUCTURE_SET, key));
    }

    public static StructureKey create(String key) {
        return new StructureKey(CelestialStructure.loc(key), Pools.createKey(CelestialStructure.loc(key).toString()), ResourceKey.create(Registries.STRUCTURE, CelestialStructure.loc(key)),
                ResourceKey.create(Registries.STRUCTURE_SET, CelestialStructure.loc(key)));
    }
}
