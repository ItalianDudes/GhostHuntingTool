package it.italiandudes.ghost_hunting_tool.client.utils;

import it.italiandudes.ghost_hunting_tool.utils.Defs;
import it.italiandudes.ghost_hunting_tool.utils.JSONManager;
import it.italiandudes.idl.common.JarHandler;
import it.italiandudes.idl.common.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public final class Settings {

    // Settings
    private static JSONObject SETTINGS = null;

    // Settings Loader
    public static void loadSettingsFile() {
        File settingsFile = new File(Defs.Resources.JSON.JSON_SETTINGS);
        if (!settingsFile.exists() || !settingsFile.isFile()) {
            try {
                JarHandler.copyFileFromJar(new File(Defs.JAR_POSITION), Defs.Resources.JSON.DEFAULT_JSON_SETTINGS, settingsFile, true);
            } catch (IOException e) {
                Logger.log(e);
                return;
            }
        }
        try {
            SETTINGS = JSONManager.readJSON(settingsFile);
            fixJSONSettings();
        } catch (IOException | JSONException e) {
            Logger.log(e);
        }
    }

    // Settings Checker
    private static void fixJSONSettings() throws JSONException, IOException {
        writeJSONSettings();
    }

    // Settings Writer
    public static void writeJSONSettings() throws IOException {
        JSONManager.writeJSON(SETTINGS, new File(Defs.Resources.JSON.JSON_SETTINGS));
    }

    // Settings Getter
    @NotNull
    public static JSONObject getSettings() {
        return SETTINGS;
    }

    // JSON Settings
    public static final class Keys {
    }
}
