package cc.cassian.wilderflowers.events;

import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import cc.cassian.wilderflowers.tags.WilderFlowersBiomeTags;
import cc.cassian.wilderflowers.tags.WilderFlowersEntityTypeTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.List;

import static cc.cassian.wilderflowers.tags.WilderFlowersEntityTypeTags.GARLAND_WEARERS;

public class CommonEvents {

	public static void onEntityJoinWorld(Entity entity) {

		if (!(entity instanceof Mob mob)) return;

		//? if >26 {
		if (!mob.is(GARLAND_WEARERS))
		//?} else {
		/*if (!mob.getType().is(GARLAND_WEARERS))
		 *///?}
			 return;

		BlockPos pos = entity.blockPosition();
		var level = entity.level();
		var random = mob.getRandom();
		double roll = random.nextDouble();

		Holder<Biome> biome = level.getBiome(pos);

		boolean frequent = roll < WilderFlowers.CONFIG.highGarlandChance && biome.is(WilderFlowersBiomeTags.MORE_GARLANDS);
		boolean infrequent = roll < WilderFlowers.CONFIG.garlandChance && biome.is(WilderFlowersBiomeTags.INFREQUENT_GARLANDS);

		if (!frequent && !infrequent) return;

		List<ItemStack> roulette = new ArrayList<>();

		if (biome.is(WilderFlowersBiomeTags.CHEERY_GARLANDS)) {
			roulette.add(WilderFlowersBlocks.CHEERY_WILDFLOWERS.garlandItem().getDefaultInstance());
		}
		if (biome.is(WilderFlowersBiomeTags.MOODY_GARLANDS)) {
			roulette.add(WilderFlowersBlocks.MOODY_WILDFLOWERS.garlandItem().getDefaultInstance());
		}
		if (biome.is(WilderFlowersBiomeTags.PLAYFUL_GARLANDS)) {
			roulette.add(WilderFlowersBlocks.PLAYFUL_WILDFLOWERS.garlandItem().getDefaultInstance());
		}
		if (biome.is(WilderFlowersBiomeTags.HOPEFUL_GARLANDS)) {
			roulette.add(WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.garlandItem().getDefaultInstance());
		}

		if (roulette.isEmpty()) return;

		ItemStack stack = roulette.get(random.nextInt(roulette.size()));
		mob.setItemSlot(EquipmentSlot.HEAD, stack);
	}
}
