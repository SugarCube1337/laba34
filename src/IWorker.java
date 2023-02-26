public interface IWorker extends IHuman {
    public void work(IWork work) throws NoNameException;

    public IWork getWork();
}
