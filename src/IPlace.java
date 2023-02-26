import java.util.LinkedList;

public interface IPlace {
    public String getDescription();
    public void addKeySubject(IKeySubject keySubject);
    public LinkedList<IKeySubject> getKeySubjects();
}
