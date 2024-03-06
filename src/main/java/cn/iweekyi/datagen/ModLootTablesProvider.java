package cn.iweekyi.datagen;

import cn.iweekyi.block.ModBlocks;
import cn.iweekyi.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

/**
 * ClassName ModLootTablesProvider
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 21:28
 * Version: 1.0
 */
public class ModLootTablesProvider extends FabricBlockLootTableProvider {
    public ModLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TEST_BLOCK);  // 挖掉时掉落本身
        addDrop(ModBlocks.FIRE_CORE_BLOCK);
        addDrop(ModBlocks.TEST_BLOCK_ORE, TestBlockOreDrops(ModBlocks.TEST_BLOCK_ORE, ModItems.EXAMPLE_ITEM));
        addDrop(ModBlocks.DIAMOND_BUTTON);
        addDrop(ModBlocks.DIAMOND_WALL);
        addDrop(ModBlocks.DIAMOND_STAIR);
        addDrop(ModBlocks.DIAMOND_TRAPDOOR);
        addDrop(ModBlocks.DIAMOND_FENCE);
        addDrop(ModBlocks.DIAMOND_FENCE_GATE);
        addDrop(ModBlocks.DIAMOND_STAIR);
        addDrop(ModBlocks.DIAMOND_DOOR, doorDrops(ModBlocks.DIAMOND_DOOR));
        addDrop(ModBlocks.DIAMOND_SLAB, slabDrops(ModBlocks.DIAMOND_SLAB));
    }


        public LootTable.Builder TestBlockOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
