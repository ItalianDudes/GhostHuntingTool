package it.italiandudes.ghost_hunting_tool.client.javafx.components;

import it.italiandudes.ghost_hunting_tool.data.EvidenceState;
import javafx.scene.control.CheckBox;
import org.jetbrains.annotations.NotNull;

public class EvidenceCheckBox {

    // Attributes
    @NotNull private EvidenceState state = EvidenceState.NONE;
    @NotNull private final CheckBox checkBox;

    // Constructors
    public EvidenceCheckBox(@NotNull final CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    // Methods
    public void rotateEvidenceState() {
        switch (state) {
            case NONE:
                enableEvidence();
                break;
            case ENABLED:
                disableEvidence();
                break;
            default:
                clearEvidence();
                break;
        }
    }
    public void enableEvidence() {
        state = EvidenceState.ENABLED;
        checkBox.setSelected(true);
        checkBox.setIndeterminate(false);
    }
    public void disableEvidence() {
        state = EvidenceState.DISABLED;
        checkBox.setSelected(false);
        checkBox.setIndeterminate(true);
    }
    public void clearEvidence() {
        state = EvidenceState.NONE;
        checkBox.setSelected(false);
        checkBox.setIndeterminate(false);
    }

    public EvidenceState getEvidenceState() {
        return state;
    }
}
