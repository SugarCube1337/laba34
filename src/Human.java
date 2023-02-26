import java.util.Objects;

public class Human implements IHuman, IServiceMethods {

    private final String name;
    private Place place;
    public Human(String name, Place place) {
        this.name = name;
        this.place = place;
    }

    public void moveTo(Place other_place) throws NoNameException {
        if (other_place == null) {
            throw new CannotMoveException("Trying to move to null-place");
        }
        if (place.equals(other_place)) {
            throw new CannotMoveException("Trying to move to the same place");
        }
        place = other_place;
        System.out.println(getName() + " moved to\n" + place.toString());
    }

    public void makeAction(IAction action) throws NoNameException {
        System.out.println(getName() + ": " + action.toString());
    }

    public Place getPlace() {
        return place;
    }

    public String getName() throws NoNameException {
        if (name == null || name.isEmpty()) {
            throw new NoNameException("This object has no name");
        }
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final IHuman other_human = (IHuman) obj;
        final String other_name;
        try {
            other_name = other_human.getName();
        } catch (NoNameException e) {
            if (name == null || name.isEmpty()) {
                return place == other_human.getPlace();
            }
            return false;
        }
        return Objects.equals(other_name, name) && Objects.equals(place, other_human.getPlace());
    }

    @Override
    public int hashCode() {
        return name.hashCode() + place.hashCode();
    }

    @Override
    public String toString() {
        return name + " at " + place.toString();
    }
}
