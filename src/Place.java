import java.util.LinkedList;
import java.util.Objects;

public class Place implements IPlace, IServiceMethods {
    private final String description;
    private final LinkedList<IKeySubject> keySubjects;

    public Place(String description) {
        this.description = description;
        keySubjects = new LinkedList<IKeySubject>();
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void addKeySubject(IKeySubject keySubject) {
        keySubjects.add(keySubject);
    }

    @Override
    public LinkedList<IKeySubject> getKeySubjects() {
        return keySubjects;
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
        return description.equals(((IPlace) obj).getDescription()) && ((IPlace) obj).getKeySubjects().equals(keySubjects);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(description);
        builder.append('\n');
        if (!keySubjects.isEmpty()) {
            builder.append("Key subjects:");
            for (var subj: keySubjects) {
                builder.append(subj.toString());
                builder.append('\n');
            }
        }
        return builder.toString();
    }

    public static class KeySubject implements IKeySubject {
        private final String description;

        public KeySubject(String description) {
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
            return Objects.equals(((IKeySubject) obj).getDescription(), description);
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
