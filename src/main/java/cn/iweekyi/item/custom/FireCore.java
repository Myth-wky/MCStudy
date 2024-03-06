package cn.iweekyi.item.custom;

import cn.iweekyi.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * ClassName FireCore
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 14:24
 * Version: 1.0
 */
public class FireCore extends Item {
    public FireCore(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if(!world.isClient()){
            PlayerEntity player = context.getPlayer();  //获取玩家
            ItemStack stack = context.getStack();  //获取物品栏中的物品
            BlockState blockState = world.getBlockState(context.getBlockPos());  //获取方块状态
            lightFire(blockState, context, player);  //执行自定函数
            stack.damage(1, player, (p) -> p.sendToolBreakStatus(p.getActiveHand()));  //损坏物品
        }
        return ActionResult.SUCCESS;
    }
    private void lightFire(BlockState blockState, ItemUsageContext context, PlayerEntity player){
        boolean playerNotOnFire = !player.isOnFire();  //玩家是否着火
        if(context.getWorld().getRandom().nextFloat() > 0.5f){
            lightEntityOnFire(player, 10);  //点燃玩家
        } else if(playerNotOnFire && blockIsRight(blockState)){  //玩家未着火且方块状态正确
            gainFAAndDB(player, context.getWorld(), context.getBlockPos());  //执行自定函数
        } else {
            lightGround(context);  //对方块点火
        }
    }
    private boolean blockIsRight(BlockState blockState){
        return blockState.isOf(Blocks.ICE);  //方块是冰
    }
    private void lightEntityOnFire(PlayerEntity player, int time){
        player.setOnFireFor(time);  //点燃玩家
    }
    private void gainFAAndDB(PlayerEntity player, World world, BlockPos blockPos){
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 3));  //给予玩家火焰抗性
        world.breakBlock(blockPos, false);  //破坏方块
    }
    public void lightGround(ItemUsageContext context){
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockPos blockPos1 = blockPos.offset(context.getSide());  //获取方块面
        if(AbstractFireBlock.canPlaceAt(world, blockPos1, context.getHorizontalPlayerFacing())){
            world.playSound(player, blockPos1, SoundEvents.ITEM_FLINTANDSTEEL_USE,
                    SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4f + 0.8f);
            BlockState blockState2 = AbstractFireBlock.getState(world, blockPos1);  //获取方块状态
            world.setBlockState(blockPos1, blockState2, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);  //放置方块
            world.emitGameEvent((Entity)player, GameEvent.BLOCK_CHANGE, blockPos);  //发送游戏事件
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.testmod.fire_core.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
