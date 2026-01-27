package cc.cassian.wilderflowers.neoforge;

//? neoforge {
/*import cc.cassian.wilderflowers.Platform;
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.events.CommonEvents;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import cc.cassian.wilderflowers.registry.WilderFlowersParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import static cc.cassian.wilderflowers.WilderFlowers.MOD_ID;
import static cc.cassian.wilderflowers.tags.WilderFlowersEntityTypeTags.GARLAND_WEARERS;
import static cc.cassian.wilderflowers.tags.WilderFlowersItemTags.FLOWER_GARLANDS;

@Mod(MOD_ID)
@EventBusSubscriber(modid = MOD_ID)
public class NeoforgeEntrypoint {

    public NeoforgeEntrypoint() {
        WilderFlowers.init();
    }

    @SubscribeEvent
    static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            WilderFlowersBlocks.getWildflowerItems().forEach((wildflowerSupplier -> {
                //? if >1.21.4 {
                event.insertAfter(Items.WILDFLOWERS.getDefaultInstance(), wildflowerSupplier, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                //?} else {
                /^event.insertAfter(Items.PINK_PETALS.getDefaultInstance(), wildflowerSupplier.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                ^///?}
            }));
        }
    }

    @SubscribeEvent
    static void register(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.BLOCK)) {
            WilderFlowersBlocks.touch();
        }
        if (event.getRegistryKey().equals(Registries.PARTICLE_TYPE)) {
            WilderFlowersParticleTypes.touch();
        }
    }

    @SubscribeEvent
    static void addResourcePack(AddPackFindersEvent event) {
        event.addPackFinders(WilderFlowers.locate("resourcepacks/wildflowers"), PackType.CLIENT_RESOURCES, Component.literal("Wilder Flowers"), PackSource.BUILT_IN, true, Pack.Position.TOP);
    }

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        CommonEvents.onEntityJoinWorld(event.getEntity());
    }

    @SubscribeEvent
    public static void onChangeTarget(LivingChangeTargetEvent event) {
        LivingEntity living = event.getEntity();
        if (living.level().isClientSide) return;
        if (!(living instanceof Mob mob)) return;

        if (!mob.getType().is(GARLAND_WEARERS) || !mob.getItemBySlot(EquipmentSlot.HEAD).is(FLOWER_GARLANDS)) return;

        if (WilderFlowers.CONFIG.garlandWearersPassive) {
            event.setNewAboutToBeSetTarget(null);
            return;
        }

        if (!WilderFlowers.CONFIG.garlandWearersNeutral) return;

        LivingEntity target = event.getOriginalAboutToBeSetTarget();
        if (target == null) return;

        if (target == mob.getLastAttacker()) return; // retribution is a must

        if (target instanceof ServerPlayer) {
            event.setNewAboutToBeSetTarget(null);
        }
    }

}
*///?}