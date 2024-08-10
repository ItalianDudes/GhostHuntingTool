package it.italiandudes.ghost_hunting_tool.client.javafx.controllers;

import it.italiandudes.ghost_hunting_tool.client.javafx.Client;
import javafx.fxml.FXML;

public final class ControllerSceneLoading {

    //Initialize
    @FXML
    private void initialize() {
        Client.getStage().setFullScreen(false);
        Client.getStage().setMaximized(false);
        Client.getStage().setResizable(false);
    }
}