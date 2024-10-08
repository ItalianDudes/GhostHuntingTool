package it.italiandudes.ghost_hunting_tool.utils;

import it.italiandudes.ghost_hunting_tool.GhostHuntingTool;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public final class Defs {

    // App File Name
    public static final String APP_FILE_NAME = "GhostHuntingTool";

    // Charset
    public static final String DEFAULT_CHARSET = "UTF-8";

    // Jar App Position
    public static final String JAR_POSITION;
    static {
        try {
            JAR_POSITION = new File(GhostHuntingTool.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    // Resources Location
    public static final class Resources {

        //Resource Getters
        public static URL get(@NotNull final String resourceConst) {
            return Objects.requireNonNull(GhostHuntingTool.class.getResource(resourceConst));
        }
        public static InputStream getAsStream(@NotNull final String resourceConst) {
            return Objects.requireNonNull(GhostHuntingTool.class.getResourceAsStream(resourceConst));
        }

        // JSON
        public static final class JSON {
            public static final String JSON_SETTINGS = "settings.json";
            public static final String DEFAULT_JSON_SETTINGS = "/json/" + JSON_SETTINGS;
        }

        // Images
        public static final class Image {
            private static final String IMAGE_DIR = "/image/";
        }
    }
}
