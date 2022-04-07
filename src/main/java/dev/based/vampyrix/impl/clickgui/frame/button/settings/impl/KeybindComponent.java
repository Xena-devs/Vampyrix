package dev.based.vampyrix.impl.clickgui.frame.button.settings.impl;

import dev.based.vampyrix.api.util.Wrapper;
import dev.based.vampyrix.api.util.misc.Keybind;
import dev.based.vampyrix.api.util.render.ColourUtil;
import dev.based.vampyrix.api.util.render.RenderUtil;
import dev.based.vampyrix.impl.clickgui.frame.button.settings.SettingComponent;
import dev.based.vampyrix.impl.modules.Setting;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.awt.*;

import static org.lwjgl.opengl.GL11.glScaled;
import static org.lwjgl.opengl.GL11.glScalef;

public class KeybindComponent extends SettingComponent<Keybind> implements Wrapper {
    private boolean isListening;

    public KeybindComponent(float x, float y, float width, float height, Setting<Keybind> setting) {
        super(x, y, width, height, setting);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        RenderUtil.drawRect(x, y, width, height, isWithin(mouseX, mouseY) ? new Color(23, 23, 23, 200).getRGB() : 0x90000000);

        float scaleFactor = 1 / 0.75f;

        glScalef(0.75f, 0.75f, 0.75f);

        mc.fontRenderer.drawStringWithShadow(getSetting().getName(), (x + 5) * scaleFactor, (y + 4.5f) * scaleFactor, -1);
        mc.fontRenderer.drawStringWithShadow((isListening ? "..." : Keyboard.getKeyName(getSetting().getValue().getKeyCode())), (x + width - 4.5f - (mc.fontRenderer.getStringWidth(isListening ? "..." : Keyboard.getKeyName(getSetting().getValue().getKeyCode())) * 0.75f)) * scaleFactor, (y + 4.5f) * scaleFactor, -1);

        glScalef(scaleFactor, scaleFactor, scaleFactor);

        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isWithin(mouseX, mouseY) && mouseButton == 0) {
            isListening = !isListening;
        }

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        super.mouseReleased(mouseX, mouseY, mouseButton);
    }

    @Override
    public void keyTyped(char keyChar, int keyCode) {
        if (isListening) {
            if (keyCode == Keyboard.KEY_DELETE || keyCode == Keyboard.KEY_BACK) {
                getSetting().getValue().setKeyCode(0);
            } else {
                getSetting().getValue().setKeyCode(keyCode);
            }

            isListening = false;
        }

        super.keyTyped(keyChar, keyCode);
    }
}
