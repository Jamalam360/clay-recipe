package com.jamalam360;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ClayCreate {
    public static void run(ItemEntity itemEntity) {
        Block block = itemEntity.getEntityWorld().getBlockState(itemEntity.getBlockPos()).getBlock();
        System.out.println(itemEntity.getBlockPos());

        if (block == Blocks.WATER && itemEntity.getStack().getItem() == Items.DIRT) {
            try {
                java.util.concurrent.TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {}
            itemEntity.setStack(new ItemStack(Items.CLAY_BALL, itemEntity.getStack().getCount()));
        }
    }
}
