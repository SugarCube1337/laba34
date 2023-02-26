import java.util.Objects;

public class Work extends AAction implements IWork {
    private final WorkType workType;

    public Work(WorkType workType, String description) {
        super(description);
        this.workType = workType;
    }

    @Override
    public int hashCode() {
        return workType.hashCode() + getWorkType().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return workType == ((IWork) obj).getWorkType() && Objects.equals(getDescription(), ((IAction) obj).getDescription());
    }

    @Override
    public String toString() {
        return getDescription();
    }

    public WorkType getWorkType() {
        return workType;
    }
}
