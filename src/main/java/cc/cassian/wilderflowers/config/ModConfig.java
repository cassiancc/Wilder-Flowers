package cc.cassian.wilderflowers.config;

import folk.sisby.kaleido.api.ReflectiveConfig;
import folk.sisby.kaleido.api.WrappedConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.DisplayName;
import folk.sisby.kaleido.lib.quiltconfig.api.values.TrackedValue;

public class ModConfig extends WrappedConfig {
	@Comment("Chance of mobs in garland_wearers spawning with flower garlands")
	@DisplayName("Base garland chance")
	public Double garlandChance = 0.05;
	@DisplayName("Frequent garland chance")
	@Comment("Chance of mobs in garland_wearers spawning with flower garlands in frequent_garland biomes")
	public Double highGarlandChance = 0.35;
	@Comment("Mobs in garland_wearers wearing flower garlands are neutral")
	public Boolean garlandWearersNeutral = false;
	@Comment("Mobs in garland_wearers wearing flower garlands are passive. If true, overrides garlandWearersNeutral")
	public Boolean garlandWearersPassive = false;
}
