package it.italiandudes.ghost_hunting_tool.client.javafx.controllers;

import it.italiandudes.ghost_hunting_tool.client.javafx.Client;
import it.italiandudes.ghost_hunting_tool.client.javafx.components.GhostButton;
import it.italiandudes.ghost_hunting_tool.client.javafx.components.EvidenceCheckBox;
import it.italiandudes.ghost_hunting_tool.data.Evidence;
import it.italiandudes.ghost_hunting_tool.data.EvidenceState;
import it.italiandudes.ghost_hunting_tool.data.Ghost;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public final class ControllerSceneGhostHuntingTool {

    // Attributes
    private static final int WIDTH = 525;
    private static final int HEIGHT = 700;
    private final HashMap<@NotNull Evidence, @NotNull EvidenceState> evidences = new HashMap<>();
    private FilteredList<@NotNull GhostButton> ghostButtons = null;
    private EvidenceCheckBox evidenceEMF5 = null;
    private EvidenceCheckBox evidenceFingerprints = null;
    private EvidenceCheckBox evidenceGhostWriting = null;
    private EvidenceCheckBox evidenceFreezingTemperatures = null;
    private EvidenceCheckBox evidenceDOTSProjector = null;
    private EvidenceCheckBox evidenceGhostOrb = null;
    private EvidenceCheckBox evidenceSpiritBox = null;

    // Graphic Elements
    @FXML private CheckBox checkBoxEMF5;
    @FXML private CheckBox checkBoxFingerprints;
    @FXML private CheckBox checkBoxGhostWriting;
    @FXML private CheckBox checkBoxFreezingTemperatures;
    @FXML private CheckBox checkBoxDOTSProjector;
    @FXML private CheckBox checkBoxGhostOrb;
    @FXML private CheckBox checkBoxSpiritBox;
    @FXML private Button buttonSpirit;
    @FXML private Button buttonPoltergeist;
    @FXML private Button buttonMare;
    @FXML private Button buttonDemon;
    @FXML private Button buttonYokai;
    @FXML private Button buttonMyling;
    @FXML private Button buttonRaiju;
    @FXML private Button buttonMoroi;
    @FXML private Button buttonWraith;
    @FXML private Button buttonBanshee;
    @FXML private Button buttonRevenant;
    @FXML private Button buttonYurei;
    @FXML private Button buttonHantu;
    @FXML private Button buttonOnryo;
    @FXML private Button buttonObake;
    @FXML private Button buttonDeogen;
    @FXML private Button buttonPhantom;
    @FXML private Button buttonJinn;
    @FXML private Button buttonShade;
    @FXML private Button buttonOni;
    @FXML private Button buttonGoryo;
    @FXML private Button buttonTheTwins;
    @FXML private Button buttonTheMimic;
    @FXML private Button buttonThaye;

    //Initialize
    @FXML
    private void initialize() {
        Client.getStage().setFullScreen(false);
        Client.getStage().setMaximized(false);
        Client.getStage().setResizable(false);
        Client.getStage().setWidth(WIDTH);
        Client.getStage().setHeight(HEIGHT);

        evidences.put(Evidence.EMF_LEVEL_5, EvidenceState.NONE);
        evidences.put(Evidence.FINGERPRINT, EvidenceState.NONE);
        evidences.put(Evidence.GHOST_WRITING, EvidenceState.NONE);
        evidences.put(Evidence.FREEZING_TEMPERATURES, EvidenceState.NONE);
        evidences.put(Evidence.DOTS_PROJECTOR, EvidenceState.NONE);
        evidences.put(Evidence.GHOST_ORB, EvidenceState.NONE);
        evidences.put(Evidence.SPIRIT_BOX, EvidenceState.NONE);

        evidenceEMF5 = new EvidenceCheckBox(checkBoxEMF5);
        evidenceFingerprints = new EvidenceCheckBox(checkBoxFingerprints);
        evidenceGhostWriting = new EvidenceCheckBox(checkBoxGhostWriting);
        evidenceFreezingTemperatures = new EvidenceCheckBox(checkBoxFreezingTemperatures);
        evidenceDOTSProjector = new EvidenceCheckBox(checkBoxDOTSProjector);
        evidenceGhostOrb = new EvidenceCheckBox(checkBoxGhostOrb);
        evidenceSpiritBox = new EvidenceCheckBox(checkBoxSpiritBox);

        ghostButtons = new FilteredList<>(FXCollections.observableList(Arrays.asList(
                new GhostButton(Ghost.SPIRIT, buttonSpirit),
                new GhostButton(Ghost.POLTERGEIST, buttonPoltergeist),
                new GhostButton(Ghost.MARE, buttonMare),
                new GhostButton(Ghost.DEMON, buttonDemon),
                new GhostButton(Ghost.YOKAI, buttonYokai),
                new GhostButton(Ghost.MYLING, buttonMyling),
                new GhostButton(Ghost.RAIJU, buttonRaiju),
                new GhostButton(Ghost.MOROI, buttonMoroi),
                new GhostButton(Ghost.WRAITH, buttonWraith),
                new GhostButton(Ghost.BANSHEE, buttonBanshee),
                new GhostButton(Ghost.REVENANT, buttonRevenant),
                new GhostButton(Ghost.YUREI, buttonYurei),
                new GhostButton(Ghost.HANTU, buttonHantu),
                new GhostButton(Ghost.ONRYO, buttonOnryo),
                new GhostButton(Ghost.OBAKE, buttonObake),
                new GhostButton(Ghost.DEOGEN, buttonDeogen),
                new GhostButton(Ghost.PHANTOM, buttonPhantom),
                new GhostButton(Ghost.JINN, buttonJinn),
                new GhostButton(Ghost.SHADE, buttonShade),
                new GhostButton(Ghost.ONI, buttonOni),
                new GhostButton(Ghost.GORYO, buttonGoryo),
                new GhostButton(Ghost.TWINS, buttonTheTwins),
                new GhostButton(Ghost.MIMIC, buttonTheMimic),
                new GhostButton(Ghost.THAYE, buttonThaye)
        )));
    }

    // EDT
    @FXML
    private void changeEMF5() {
        evidenceEMF5.rotateEvidenceState();
        switch (evidenceEMF5.getEvidenceState()) {
            case NONE:
                evidences.put(Evidence.EMF_LEVEL_5, EvidenceState.NONE);
                break;
            case ENABLED:
                evidences.put(Evidence.EMF_LEVEL_5, EvidenceState.ENABLED);
                break;
            case DISABLED:
                evidences.put(Evidence.EMF_LEVEL_5, EvidenceState.DISABLED);
                break;
        }
        updateGhostList();
    }
    @FXML
    private void changeFingerprints() {
        evidenceFingerprints.rotateEvidenceState();
        switch (evidenceFingerprints.getEvidenceState()) {
            case NONE:
                evidences.put(Evidence.FINGERPRINT, EvidenceState.NONE);
                break;
            case ENABLED:
                evidences.put(Evidence.FINGERPRINT, EvidenceState.ENABLED);
                break;
            case DISABLED:
                evidences.put(Evidence.FINGERPRINT, EvidenceState.DISABLED);
                break;
        }
        updateGhostList();
    }
    @FXML
    private void changeGhostWriting() {
        evidenceGhostWriting.rotateEvidenceState();
        switch (evidenceGhostWriting.getEvidenceState()) {
            case NONE:
                evidences.put(Evidence.GHOST_WRITING, EvidenceState.NONE);
                break;
            case ENABLED:
                evidences.put(Evidence.GHOST_WRITING, EvidenceState.ENABLED);
                break;
            case DISABLED:
                evidences.put(Evidence.GHOST_WRITING, EvidenceState.DISABLED);
                break;
        }
        updateGhostList();
    }
    @FXML
    private void changeFreezingTemperatures() {
        evidenceFreezingTemperatures.rotateEvidenceState();
        switch (evidenceFreezingTemperatures.getEvidenceState()) {
            case NONE:
                evidences.put(Evidence.FREEZING_TEMPERATURES, EvidenceState.NONE);
                break;
            case ENABLED:
                evidences.put(Evidence.FREEZING_TEMPERATURES, EvidenceState.ENABLED);
                break;
            case DISABLED:
                evidences.put(Evidence.FREEZING_TEMPERATURES, EvidenceState.DISABLED);
                break;
        }
        updateGhostList();
    }
    @FXML
    private void changeDOTSProjector() {
        evidenceDOTSProjector.rotateEvidenceState();
        switch (evidenceDOTSProjector.getEvidenceState()) {
            case NONE:
                evidences.put(Evidence.DOTS_PROJECTOR, EvidenceState.NONE);
                break;
            case ENABLED:
                evidences.put(Evidence.DOTS_PROJECTOR, EvidenceState.ENABLED);
                break;
            case DISABLED:
                evidences.put(Evidence.DOTS_PROJECTOR, EvidenceState.DISABLED);
                break;
        }
        updateGhostList();
    }
    @FXML
    private void changeGhostOrb() {
        evidenceGhostOrb.rotateEvidenceState();
        switch (evidenceGhostOrb.getEvidenceState()) {
            case NONE:
                evidences.put(Evidence.GHOST_ORB, EvidenceState.NONE);
                break;
            case ENABLED:
                evidences.put(Evidence.GHOST_ORB, EvidenceState.ENABLED);
                break;
            case DISABLED:
                evidences.put(Evidence.GHOST_ORB, EvidenceState.DISABLED);
                break;
        }
        updateGhostList();
    }
    @FXML
    private void changeSpiritBox() {
        evidenceSpiritBox.rotateEvidenceState();
        switch (evidenceSpiritBox.getEvidenceState()) {
            case NONE:
                evidences.put(Evidence.SPIRIT_BOX, EvidenceState.NONE);
                break;
            case ENABLED:
                evidences.put(Evidence.SPIRIT_BOX, EvidenceState.ENABLED);
                break;
            case DISABLED:
                evidences.put(Evidence.SPIRIT_BOX, EvidenceState.DISABLED);
                break;
        }
        updateGhostList();
    }

    // Methods
    private void updateGhostList() {
        for (GhostButton button : ghostButtons) {
            button.getButton().setStyle("-fx-text-fill: #000000;");
            for (Evidence evidence : evidences.keySet()) {
                boolean remove = false;
                switch (evidences.get(evidence)) {
                    case ENABLED:
                        if (!button.getGhost().getEvidences().contains(evidence)) {
                            button.getButton().setStyle("-fx-text-fill: #CABF91;");
                            remove = true;
                        }
                        break;
                    case DISABLED:
                        if (button.getGhost().getEvidences().contains(evidence)) {
                            button.getButton().setStyle("-fx-text-fill: #CABF91;");
                            remove = true;
                        }
                }
                if (remove) break;
            }
        }
    }
}