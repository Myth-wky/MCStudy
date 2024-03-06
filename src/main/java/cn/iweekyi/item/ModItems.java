package cn.iweekyi.item;

import cn.iweekyi.TestMod;
import cn.iweekyi.item.custom.FireCore;
import cn.iweekyi.item.custom.Prospector;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * ClassName Moditems
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/26 12:23
 * Version: 1.0
 */
public class ModItems {
    public static final Item EXAMPLE_ITEM = registerItem("example_item", new Item(new Item.Settings()));
    public static final Item PROSPECTOR = registerItem("prospector", new Prospector(new FabricItemSettings().maxDamage(64)));
    public static final Item FIRECORE = registerItem("fire_core", new FireCore(new FabricItemSettings().maxDamage(10)));
    public static final Item CORN = registerItem("corn", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    //自定义工具
    public static final Item FIRECORE_PICKAXE = registerItem("fire_core_pickaxe",
            new PickaxeItem(ModToolMaterial.FIRECORE, 2, 2f, new FabricItemSettings()));  // attack是额外的攻击伤害
    public static final Item FIRECORE_AXE = registerItem("fire_core_axe",
            new AxeItem(ModToolMaterial.FIRECORE, 5, 1f, new FabricItemSettings()));
    public static final Item FIRECORE_SHOVEL = registerItem("fire_core_shovel",
            new ShovelItem(ModToolMaterial.FIRECORE, 0, 0f, new FabricItemSettings()));
    public static final Item FIRECORE_SWORD = registerItem("fire_core_sword",
            new SwordItem(ModToolMaterial.FIRECORE, 4, 3f, new FabricItemSettings()));
    public static final Item FIRECORE_HOE = registerItem("fire_core_hoe",
            new HoeItem(ModToolMaterial.FIRECORE, 0, 0f, new FabricItemSettings()));
    //自定义盔甲
    public static final Item FIRECORE_HELMET = registerItem("fire_core_helmet",
            new ArmorItem(ModArmorMaterial.FIRECORE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item FIRECORE_CHESTPLATE = registerItem("fire_core_chestplate",
            new ArmorItem(ModArmorMaterial.FIRECORE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item FIRECORE_LEGGINGS = registerItem("fire_core_leggings",
            new ArmorItem(ModArmorMaterial.FIRECORE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item FIRECORE_BOOTS = registerItem("fire_core_boots",
            new ArmorItem(ModArmorMaterial.FIRECORE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static void addItemToIG(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(EXAMPLE_ITEM);  //向原材料物品栏注册物品
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MODID, name), item);
    }
    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);
        FuelRegistry.INSTANCE.add(ModItems.FIRECORE, 2000);  //注册燃料，value是tick
    }
}
