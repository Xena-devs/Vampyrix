package dev.based.vampyrix.impl.modules.client;

import dev.based.vampyrix.api.module.Category;
import dev.based.vampyrix.api.module.Module;
import dev.based.vampyrix.api.module.setting.Setting;

import java.awt.*;

public class Colour extends Module {

    public static Colour INSTANCE;

    public final Setting<Color> colour = new Setting<>("Colour", new Color(50, 80, 255)).setDescription("The client's main colour");

    public Colour() {
        super("Colour", "The client's main colour", Category.CLIENT);
        INSTANCE = this;
    }

    @Override
    public void setupSettings() {
        registerSetting(colour);
    }
}