public class Worker extends Human implements IWorker {
    private IWork work;

    public Worker(String name, Place place) {
        super(name, place);
    }

    @Override
    public void work(IWork work) throws NoNameException {
        this.work = work;
        makeAction(work);
    }

    @Override
    public IWork getWork() {
        return work;
    }

    @Override
    public String toString() {
        return super.toString() + ". Work: " + work;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && work.equals(((IWorker) obj).getWork());
    }
}
