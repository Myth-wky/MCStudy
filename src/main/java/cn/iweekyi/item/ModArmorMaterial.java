package cn.iweekyi.item;

import cn.iweekyi.TestMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

/**
 * EnumName ModArmorMaterial
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/03/02 21:05
 * Version: 1.0
 */
public enum ModArmorMaterial implements ArmorMaterial {
    FIRECORE("fire_core", 25, new int[]{4, 6, 8, 3}, 20,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2f, 0.1f,
            () -> Ingredient.ofItems(ModItems.FIRECORE));
    ;
    private final String name;
    private final int durabilityMultiplier;  // 耐久度
    private final int[] protectionAmounts;  // 护甲值
    private final int enchantability;  // 附魔值
    private final SoundEvent equipSound;  // 装备声音
    private final float toughness;  // 韧性
    private final float knockbackResistance;  // 击退抗性
    private final Supplier<Ingredient> repairIngredientSupplier;  // 修复材料
    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return TestMod.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
