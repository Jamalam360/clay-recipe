package com.jamalam360.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.FluidTags;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Jamalam360
 */

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {
    public ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract void setStack(ItemStack stack);

    @Shadow public abstract ItemStack getStack();

    @Inject(at = @At("TAIL"), method = "tick()V")
    public void setStack(CallbackInfo ci) {
        if (this.getStack().getItem() == Items.DIRT && this.world.getBlockState(this.getBlockPos()).getFluidState().isIn(FluidTags.WATER)) {
            this.setStack(Items.CLAY_BALL.getDefaultStack());
        }
    }
}
