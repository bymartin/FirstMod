package net.barry.firstmod;

import net.barry.firstmod.items.Spear;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
    public static final String MOD_ID = "firstmod";
	public static final Item BANANA = new Item(new Item.Settings().maxCount(20).food(FoodComponents.BEEF)); // or new FabricItemSettings()
	public static final Item SPEAR = new Spear(new Item.Settings().maxCount(1));

	// custom item group
	public static final ItemGroup WEAPONS = Registry.register(Registries.ITEM_GROUP,
			new Identifier(MOD_ID, "weapons_group"),
			FabricItemGroup.builder()
					.displayName(Text.of("Weapons"))
					.noScrollbar()
					.icon(() -> new ItemStack(Items.CHIPPED_ANVIL)).entries((displayContext, entries) -> {
						entries.add(SPEAR);
						entries.add(BANANA);
					}).build());

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world from firstmod!");

		// Add to a vanilla group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
			entries.add(BANANA);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.addAfter(Items.IRON_SWORD, SPEAR);
		});

		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "banana"), BANANA);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spear"), SPEAR);
	}
}