package it.italiandudes.ghost_hunting_tool.client.javafx.components;

import it.italiandudes.ghost_hunting_tool.data.Ghost;
import javafx.scene.control.Button;
import org.jetbrains.annotations.NotNull;

public final class GhostButton {

    // Attributes
    @NotNull private final Ghost ghost;
    @NotNull private final Button button;

    // Constructors
    public GhostButton(@NotNull final Ghost ghost, @NotNull final Button button) {
        this.ghost = ghost;
        this.button = button;
    }

    // Methods
    @NotNull
    public Ghost getGhost() {
        return ghost;
    }
    @NotNull
    public Button getButton() {
        return button;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GhostButton)) return false;

        GhostButton that = (GhostButton) o;
        return getGhost() == that.getGhost() && getButton().equals(that.getButton());
    }
    @Override
    public int hashCode() {
        int result = getGhost().hashCode();
        result = 31 * result + getButton().hashCode();
        return result;
    }
    @Override
    public String toString() {
        return ghost.getName();
    }
}
