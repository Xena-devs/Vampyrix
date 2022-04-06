package dev.based.vampyrix;

import me.wolfsurge.cerauno.EventBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import dev.based.vampyrix.managers.EventManager;
import dev.based.vampyrix.managers.ModuleManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = Vampyrix.MODID, name = Vampyrix.NAME, version = Vampyrix.VERSION)
public class Vampyrix {

    public static final String MODID = "vampyrix";
    public static final String NAME = "Vampyrix";
    public static final String VERSION = "0.1";

    @Instance
    public static Vampyrix INSTANCE;

    private final Logger logger = LogManager.getLogger("vampyrix");
    private final EventBus eventBus = new EventBus();

    private ModuleManager moduleManager;
    private EventManager eventManager;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(INSTANCE);

        logger.info("Setting up Vampyrix {}...", Vampyrix.VERSION);

        moduleManager = new ModuleManager();
        logger.info("Modules Initialized.");

        eventManager = new EventManager();
        logger.info("Events Initialized.");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Display.setTitle(Vampyrix.NAME + " " + Vampyrix.VERSION);
    }

    public Logger getLogger() {
        return logger;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

}