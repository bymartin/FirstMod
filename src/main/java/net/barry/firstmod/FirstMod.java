package net.barry.firstmod;

import net.barry.firstmod.items.Spear;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
    public static final String MOD_ID = "firstmod";
	public static final Item BANANA = new Item(new Item.Settings().maxCount(20).food(FoodComponents.BEEF)); // or new FabricItemSettings()
	public static final Item SPEAR = new Spear(new Item.Settings().maxCount(1));

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world from firstmod!");
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "banana"), BANANA);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spear"), SPEAR);
	}
}