package net.levente.items.custom.food;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ARTIFACT_ESSENCE = new FoodComponent.Builder().nutrition(1)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 20, 2), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20, 2), 1f).build();

}
