package com.based.lynx.module.movement;

import com.based.lynx.event.EventTarget;
import com.based.lynx.module.Category;
import com.based.lynx.module.Module;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class NoSlow extends Module {

    public NoSlow() {
        super("NoSlow", "", Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onInput(InputUpdateEvent event) {
        if (mc.player.isHandActive() && !mc.player.isRiding()) {
            event.getMovementInput().moveStrafe *= 5;
            event.getMovementInput().moveForward *= 5;
        }
    }


}