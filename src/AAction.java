import java.util.Objects;

public abstract class AAction implements IAction {
    private final String description;

    public AAction(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Objects.equals(((IAction) obj).getDescription(), description);
    }
}
