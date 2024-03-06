package cn.iweekyi.datagen;

import cn.iweekyi.block.ModBlocks;
import cn.iweekyi.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

/**
 * ClassName ModRecipesProvider
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 21:26
 * Version: 1.0
 */
public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> TEST_BLOCK_LIST = List.of(ModBlocks.TEST_BLOCK);
    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // 九宫格互相转化，例如钻石变成钻石块，钻石块变成钻石
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.FIRECORE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIRE_CORE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.EXAMPLE_ITEM,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.TEST_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR, 3)
                .pattern("###")
                .input('#', Items.BEETROOT)
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))  //成就显示
                .offerTo(exporter, new Identifier("sugar_from_beetroot"));  //注册
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRECORE, 1)
                .pattern("###")
                .pattern("#A#")
                .pattern("###")
                .input('A', Items.GUNPOWDER)
                .input('#', Items.MAGMA_CREAM)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
                .offerTo(exporter, new Identifier("magma_cream_gunpowder_to_fire_core"));
        //钻石建材
//        ShapedRecipeJsonBuilder.create()


        // 熔炉和高炉配方
        offerSmelting(exporter, TEST_BLOCK_LIST, RecipeCategory.MISC, Items.DIAMOND, 0.5f, 200, "test_block_smelting_to_diamond");
        offerBlasting(exporter, TEST_BLOCK_LIST, RecipeCategory.MISC, Items.DIAMOND, 0.5f, 200, "test_block_blasting_to_diamond");

    }
}
