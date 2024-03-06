package cn.iweekyi.block;

import cn.iweekyi.TestMod;
import cn.iweekyi.block.custom.FireCoreBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

/**
 * ClassName ModBlocks
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/26 20:03
 * Version: 1.0
 */
public class ModBlocks  {
    public static final Block TEST_BLOCK = registerBlocks("test_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block TEST_BLOCK_ORE = registerBlocks("test_block_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(5f), UniformIntProvider.create(2, 5)));
    public static final Block FIRE_CORE_BLOCK = registerBlocks("fire_core_block",
            new FireCoreBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DIAMOND_STAIR = registerBlocks("diamond_stair",
            new StairsBlock(Blocks.DIAMOND_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DIAMOND_SLAB = registerBlocks("diamond_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DIAMOND_BUTTON = registerBlocks("diamond_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE), BlockSetType.STONE, 20, true));
    public static final Block DIAMOND_PRESSURE_PLATE = registerBlocks("diamond_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.STONE),
                    BlockSetType.STONE));
    public static final Block DIAMOND_FENCE_GATE = registerBlocks("diamond_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.STONE), WoodType.OAK));
    public static final Block DIAMOND_FENCE = registerBlocks("diamond_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DIAMOND_WALL = registerBlocks("diamond_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DIAMOND_DOOR = registerBlocks("diamond_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque(), BlockSetType.STONE));
    public static final Block DIAMOND_TRAPDOOR = registerBlocks("diamond_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque(), BlockSetType.STONE));
    private static Block registerBlocks(String name, Block block){
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(TestMod.MODID, name),
                block);
    }
    private static Item registerBlockItems(String name, Block block){
        return Registry.register(Registries.ITEM,
                new Identifier(TestMod.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){

    }
}
