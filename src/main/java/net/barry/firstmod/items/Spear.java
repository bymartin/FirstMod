package net.barry.firstmod.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

// custom item
public class Spear extends Item {
    public Spear(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of("This is a spear!"));
        tooltip.add(Text.of("Right click to use."));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //return super.use(world, user, hand);
        if (hand == Hand.MAIN_HAND) {
            user.playSound(SoundEvents.BLOCK_CALCITE_BREAK, 1.0f, 1.0f);
            user.sendMessage(Text.of("Wooosh!!!"));
        } else {
            user.playSound(SoundEvents.BLOCK_ROOTS_BREAK, 1.0f, 1.0f);
            user.setHealth(0);
            user.sendMessage(Text.of("You speared yourself! Ouch. You died."));
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
