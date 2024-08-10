package it.italiandudes.ghost_hunting_tool.client.javafx.scenes;

import it.italiandudes.ghost_hunting_tool.client.javafx.components.SceneController;
import it.italiandudes.ghost_hunting_tool.client.javafx.controllers.ControllerSceneGhostHuntingTool;
import it.italiandudes.ghost_hunting_tool.client.javafx.utils.JFXDefs;
import it.italiandudes.ghost_hunting_tool.utils.Defs;
import it.italiandudes.idl.common.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class SceneGhostHuntingTool {

    // Scene Generator
    @NotNull
    public static SceneController getScene() {
        try {
            FXMLLoader loader = new FXMLLoader(Defs.Resources.get(JFXDefs.Resources.FXML.FXML_GHOST_HUNTING_TOOL));
            Parent root = loader.load();
            ControllerSceneGhostHuntingTool controller = loader.getController();
            return new SceneController(root, controller);
        } catch (IOException e) {
            Logger.log(e);
            System.exit(-1);
            return null;
        }
    }
}
