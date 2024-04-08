package net.barry.firstmod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Moonshine extends Item {

    private static final Settings ITEM_SETTINGS = new Item.Settings();

    public Moonshine() {
        super(ITEM_SETTINGS);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        //Send a message to the player on their action-bar(overlay)
        user.sendMessage(Text.of("Gulp gulp gulp..."), true);

        //This will return a success and will not consume the item
        return TypedActionResult.success(user.getStackInHand(hand), false);
    }
}
