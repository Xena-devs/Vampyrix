package dev.based.vampyrix.impl.modules.impl.client;

import dev.based.vampyrix.impl.modules.Category;
import dev.based.vampyrix.impl.modules.Module;
import org.lwjgl.input.Keyboard;

import dev.based.vampyrix.impl.clickgui.ClickGUIScreen;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", "Initializes the ClickGUI", Category.CLIENT);
        this.getKeybind().getValue().setKeyCode(Keyboard.KEY_P);
    }

    @Override
    public void onEnable() {
        if (nullCheck()) {
            this.disable();
            return;
        }

        mc.displayGuiScreen(new ClickGUIScreen());
        this.disable();
    }

}