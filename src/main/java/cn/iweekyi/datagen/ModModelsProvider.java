package cn.iweekyi.datagen;

import cn.iweekyi.block.ModBlocks;
import cn.iweekyi.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

/**
 * ClassName ModModelsProvider
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 21:27
 * Version: 1.0
 */
public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool diamondBuildingBlockPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(Blocks.DIAMOND_BLOCK);  // 用钻石块的材质池
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_BLOCK_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIRE_CORE_BLOCK);
        //利用池注册
        diamondBuildingBlockPool.stairs(ModBlocks.DIAMOND_STAIR);
        diamondBuildingBlockPool.slab(ModBlocks.DIAMOND_SLAB);
        diamondBuildingBlockPool.button(ModBlocks.DIAMOND_BUTTON);
        diamondBuildingBlockPool.fence(ModBlocks.DIAMOND_FENCE);
        diamondBuildingBlockPool.fenceGate(ModBlocks.DIAMOND_FENCE_GATE);
        diamondBuildingBlockPool.pressurePlate(ModBlocks.DIAMOND_PRESSURE_PLATE);
        diamondBuildingBlockPool.wall(ModBlocks.DIAMOND_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.DIAMOND_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.DIAMOND_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FIRECORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.EXAMPLE_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        // 注册工具
        itemModelGenerator.register(ModItems.FIRECORE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRECORE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRECORE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRECORE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRECORE_SWORD, Models.HANDHELD);
        // 注册盔甲
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIRECORE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIRECORE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIRECORE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIRECORE_BOOTS);
    }
}
