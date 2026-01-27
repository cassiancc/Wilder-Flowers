package cc.cassian.wilderflowers.mixin;

import cc.cassian.wilderflowers.WilderFlowers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static cc.cassian.wilderflowers.tags.WilderFlowersEntityTypeTags.GARLAND_WEARERS;
import static cc.cassian.wilderflowers.tags.WilderFlowersItemTags.FLOWER_GARLANDS;

@Mixin(Mob.class)
public class MobMixin {
	@Inject(method = "setTarget", at = @At(value = "HEAD"), cancellable = true)
	private void mixin(LivingEntity target, CallbackInfo ci) {
		LivingEntity living = (LivingEntity)(Object)this;
		if (living.level().isClientSide()) return;
		if (!(living instanceof Mob mob)) return;

		//? if >26 {
		if (!mob.is(GARLAND_WEARERS)
		//?} else {
		/*if (!mob.getType().is(GARLAND_WEARERS)
		*///?}
		|| !mob.getItemBySlot(EquipmentSlot.HEAD).is(FLOWER_GARLANDS)) return;

		if (WilderFlowers.CONFIG.garlandWearersPassive) {
			ci.cancel();
			return;
		}

		if (!WilderFlowers.CONFIG.garlandWearersNeutral) return;

		if (target == null) return;

		if (target == mob.getLastAttacker()) return; // retribution is a must

		if (target instanceof ServerPlayer) {
			ci.cancel();
		}
	}
}
