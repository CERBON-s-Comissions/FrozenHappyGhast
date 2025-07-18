package com.cerbon.frozenhappyghast;

import com.cerbon.frozenhappyghast.creative_tabs.FHGCreativeTabs;
import com.cerbon.frozenhappyghast.item.FHGItems;
import com.cerbon.frozenhappyghast.particle.FHGParticles;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class FrozenHappyGhast {
	public static final String MOD_ID = "frozenhappyghast";
	public static final String MOD_NAME = "FrozenHappyGhast";

	public static final Logger LOGGER = LogUtils.getLogger();

	public static void init() {
		FHGItems.register();
		FHGParticles.register();
		FHGCreativeTabs.register();
	}
}
