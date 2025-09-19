package net.levente.component;

import com.mojang.serialization.Codec;
import net.levente.Charms;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<Boolean> IS_INVISIBILITY_MASK_ACTIVE = register("is_invisibility_mask_active",
            builder -> builder.codec(Codec.BOOL));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Charms.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataCompTypes() {

    }
}
