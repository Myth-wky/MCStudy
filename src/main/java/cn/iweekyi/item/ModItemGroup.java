package cn.iweekyi.item;

import cn.iweekyi.TestMod;
import cn.iweekyi.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * ClassName ModItemGroup
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/26 19:39
 * Version: 1.0
 */
public class ModItemGroup {
    public static final ItemGroup EXAMPLE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MODID, "example_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.example_group"))
                    .icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.EXAMPLE_ITEM);
                        entries.add(ModBlocks.TEST_BLOCK);
                        entries.add(ModBlocks.TEST_BLOCK_ORE);
                        entries.add(ModItems.PROSPECTOR);
                        entries.add(ModItems.FIRECORE);
                        entries.add(ModBlocks.FIRE_CORE_BLOCK);
                        entries.add(ModItems.CORN);
                        entries.add(ModBlocks.DIAMOND_BUTTON);
                        entries.add(ModBlocks.DIAMOND_SLAB);
                        entries.add(ModBlocks.DIAMOND_STAIR);
                        entries.add(ModBlocks.DIAMOND_PRESSURE_PLATE);
                        entries.add(ModBlocks.DIAMOND_DOOR);
                        entries.add(ModBlocks.DIAMOND_FENCE);
                        entries.add(ModBlocks.DIAMOND_FENCE_GATE);
                        entries.add(ModBlocks.DIAMOND_WALL);
                        entries.add(ModBlocks.DIAMOND_TRAPDOOR);
                        entries.add(ModItems.FIRECORE_AXE);
                        entries.add(ModItems.FIRECORE_HOE);
                        entries.add(ModItems.FIRECORE_PICKAXE);
                        entries.add(ModItems.FIRECORE_SHOVEL);
                        entries.add(ModItems.FIRECORE_SWORD);
                        entries.add(ModItems.FIRECORE_HELMET);
                        entries.add(ModItems.FIRECORE_CHESTPLATE);
                        entries.add(ModItems.FIRECORE_LEGGINGS);
                        entries.add(ModItems.FIRECORE_BOOTS);
                    })).build());
    public static void registerModItemGroup(){

    }
}
