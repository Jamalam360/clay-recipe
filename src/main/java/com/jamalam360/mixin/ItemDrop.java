package com.jamalam360.mixin;

import com.jamalam360.ClayCreate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

@Mixin(PlayerEntity.class)
public class ItemDrop {
    @Inject(at = @At("TAIL"), method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void dropItem(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir, double d, ItemEntity itemEntity){
        ClayCreate.run(itemEntity);
    }
}
