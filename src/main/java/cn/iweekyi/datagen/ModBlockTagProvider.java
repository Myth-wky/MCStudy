package cn.iweekyi.datagen;

import cn.iweekyi.block.ModBlocks;
import cn.iweekyi.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

/**
 * ClassName ModBlockTagProvider
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 21:26
 * Version: 1.0
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.PROSPECTOR_LIST)  //添加扫描器的检测的矿石清单
                .add(ModBlocks.TEST_BLOCK_ORE)
                .forceAddTag(BlockTags.COAL_ORES)  //从minecraft标签中加入
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.GOLD_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)  //镐子挖掘
                .add(ModBlocks.TEST_BLOCK)  //添加自定义方块
                .add(ModBlocks.TEST_BLOCK_ORE)
                .add(ModBlocks.FIRE_CORE_BLOCK)
                .add(ModBlocks.DIAMOND_DOOR)
                .add(ModBlocks.DIAMOND_SLAB);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);  //斧头挖掘
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);  //锄头挖掘
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);  //铲子挖掘
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FIRE_CORE_BLOCK)
                .add(ModBlocks.TEST_BLOCK);   //添加需要铁工具的方块
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TEST_BLOCK_ORE);  //添加需要石头工具的方块
        //建筑材料
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.DIAMOND_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.DIAMOND_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.DIAMOND_WALL);
    }
}
