package com.jamalam360;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClayRecipeInit implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "clayrecipefabric";
    public static final String MOD_NAME = "Clay Recipe";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing '" + MOD_NAME + "' under the ID '" + MOD_ID + "'");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}