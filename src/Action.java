public class Action extends AAction {

    public Action(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return getDescription();
    }
}