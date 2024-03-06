package cn.iweekyi.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

/**
 * ClassName ModFoodComponents
 * Author: Wang Keyi
 * Description:
 * CreateTime: 2024/02/28 19:56
 * Version: 1.0
 */
public class ModFoodComponents {
    public static final FoodComponent CORN = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 3), 0.5f).build();
}
