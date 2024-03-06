package cn.iweekyi.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * ClassName FireCoreBlock
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 16:59
 * Version: 1.0
 */
public class FireCoreBlock extends Block {
    public FireCoreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        entity.setFireTicks(100);
        super.onEntityLand(world, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.literal("不要碰它!"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
