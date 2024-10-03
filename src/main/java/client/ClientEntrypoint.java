package client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class ClientEntrypoint implements ClientModInitializer {
    public static final Text MASK_OF_SHADOWS_TITLE = Text.translatable("key.charms.mask_of_shadows");
    public static final Text CHARMS_TITLE = Text.translatable("category.charms.charms");

    public static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                MASK_OF_SHADOWS_TITLE.getString(),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                CHARMS_TITLE.getString()
        ));
    }
}
