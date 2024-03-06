package cn.iweekyi.item.custom;

import cn.iweekyi.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * ClassName Prospector
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 10:17
 * Version: 1.0
 */
public class Prospector extends Item {

    public Prospector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient) {
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean isOre = false;
            for (int i = -64; i <= blockPos.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(blockPos.down(i));
                if (isRightBlock(state)){
                    outPutMessage(blockPos.down(i), player, state.getBlock());
                    isOre = true;
                    break;
                }
            }
            if (!isOre){
                assert player != null;
                player.sendMessage(Text.literal("No wanted ore found"));
            }
        }
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand())); // 1.17 (playerEntity
        return ActionResult.SUCCESS;
    }

    private void outPutMessage(BlockPos down, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Find "+ block.asItem().getName().getString() + " at " + down.getX() + " " + down.getY() + " " + down.getZ()), false);
    }

    private boolean isRightBlock(BlockState state){
        return state.isIn(ModTags.Blocks.PROSPECTOR_LIST);
    }
}
