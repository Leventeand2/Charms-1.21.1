package net.levente;

import net.fabricmc.api.ClientModInitializer;
import net.levente.util.ClientModEvents;

public class CharmsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientModEvents.registerModEvents();
    }
}
