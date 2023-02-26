public interface IHuman {
    abstract public String getName() throws NoNameException;
    public void makeAction(IAction action) throws NoNameException;
    abstract public Place getPlace();


}
