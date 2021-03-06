package me.north.easybase.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import me.north.easybase.api.event.EventManager;
import me.north.easybase.api.module.ModuleManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

//Main class where everything is handled
@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
	
    public static final String MODID = "easybase";
    public static final String NAME = "EasyBase";
    public static final String VERSION = "v1.2";

    @Instance
    public static Main INSTANCE;
    
    public static final Logger LOGGER = LogManager.getLogger("EasyBase");

    
    private ModuleManager moduleManager;
    private EventManager eventManager;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(INSTANCE);
    	
    	LOGGER.info("Setting up EasyBase {}...", Main.VERSION);
    	
    	moduleManager = new ModuleManager();
    	LOGGER.info("Modules Initialized.");
    	
    	eventManager = new EventManager();
    	LOGGER.info("Events Initialized.");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	Display.setTitle(Main.NAME + " " + Main.VERSION);
    }
    
    public ModuleManager getModuleManager() {
    	return moduleManager;
    }
    
    public EventManager getEventManager() {
    	return eventManager;
    }

}
