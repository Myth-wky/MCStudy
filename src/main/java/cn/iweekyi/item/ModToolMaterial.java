package cn.iweekyi.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

/**
 * EnumName ModToolMaterial
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/29 20:52
 * Version: 1.0
 */
public enum ModToolMaterial implements ToolMaterial {  //自定义的工具材料
    FIRECORE(3, 10, 24f, 8f, 25, () -> Ingredient.ofItems(ModItems.FIRECORE))
    ;

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;  // 挖掘等级
        this.itemDurability = itemDurability;  // 耐久度
        this.miningSpeed = miningSpeed;  // 挖掘速度
        this.attackDamage = attackDamage;  // 攻击伤害
        this.enchantability = enchantability;  // 附魔值
        this.repairIngredient = repairIngredient;  // 修复材料
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
