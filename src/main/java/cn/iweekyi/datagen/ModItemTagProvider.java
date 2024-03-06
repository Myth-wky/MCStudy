package cn.iweekyi.datagen;

import cn.iweekyi.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

/**
 * ClassName ModItemTagProvider
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 21:26
 * Version: 1.0
 */
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.FIRECORE_HELMET, ModItems.FIRECORE_CHESTPLATE,
                        ModItems.FIRECORE_LEGGINGS, ModItems.FIRECORE_BOOTS);
    }
}
