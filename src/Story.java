public class Story {
    public static void main(String[] args) throws NoNameException {

        Place home = new Place("Home");
        Human snezhinka = new Human("Snezhinka", home);
        Human sineglazka = new Human("Sineglazka", home);
        Human neznaika = new Human("Neznaika", home);

        Place outside = new Place("Outside");
        outside.addKeySubject(new Place.KeySubject("Fences woven from willow twigs"));
        outside.addKeySubject(new Place.KeySubject("Buildings"));
        outside.addKeySubject(new Place.KeySubject("Apple tree, pear tree, plum tree"));
        snezhinka.moveTo(outside);
        sineglazka.moveTo(outside);
        neznaika.moveTo(outside);

        System.out.println();

        neznaika.makeAction(new Action("Looking around and wondering of clean"));
        System.out.println();

        Place yard = new Place("Yard");
        yard.addKeySubject(new Place.KeySubject("Kitchen-garden"));

        new IWorker() { // Anonymous class
            @Override
            public String getName() throws NoNameException {
                return "Some kid";
            }

            @Override
            public void makeAction(IAction action) throws NoNameException {
                return;
            }

            @Override
            public Place getPlace() {
                return null;
            }
            @Override
            public IWork getWork() {
                return null;
            }
            @Override
            public void work(IWork work) throws NoNameException {
                System.out.println("Some kid works: " + work.toString());
            }
        }.work(new Work(WorkType.CUTTING_THE_GRASS, "Cutting the grass"));

        IWorker kid = new Worker("Some kid", yard);
        kid.work(new Work(WorkType.LAYING_OUT_THE_TRACK, "Laying out the track"));
        kid.work(new Work(WorkType.KNOCKING_OUT_THE_DUST, "Knocking out the dust"));

        System.out.println();
        Human host = new Human("Host", yard);
        host.makeAction(new Action("Warn them not to walk on the doormats"));

        IWork cleaning_the_garden = new Work(WorkType.WORK_AT_GARDEN, "Cleaning the garden");
        IWork wrap_a_turnip_and_carrot = new Work(WorkType.WORK_AT_GARDEN, "Wrap a turnip and carrot with a rope and pull");

        System.out.println();
        neznaika.moveTo(yard);

        neznaika.makeAction(new Action("Notice the kid"));
        neznaika.makeAction(new Action("Notice " + kid.getName() + ": " + cleaning_the_garden.getDescription()));
        neznaika.makeAction(new Action("Notice " + kid.getName() + ": " + wrap_a_turnip_and_carrot.getDescription()));
        kid.work(cleaning_the_garden);
        kid.work(wrap_a_turnip_and_carrot);

        System.out.println();

        neznaika.makeAction(new Action("Laughing, listening the story"));

        System.out.println();

        Place appleTree = new Place("Apple tree in the middle of the street");
        appleTree.addKeySubject(new Place.KeySubject("Wooden staircase"));
        appleTree.addKeySubject(new Place.KeySubject("Huge green balls, the size of a two-story house"));
        neznaika.moveTo(appleTree);
        snezhinka.moveTo(appleTree);
        sineglazka.moveTo(appleTree);

        kid.work(new Work(WorkType.SAWING_WOOD, "Sawing the wood"));
        System.out.println();

        neznaika.moveTo(new Place("Huge green balls, the size of a two-story house"));
        neznaika.makeAction(new Action("Notice the nature's miracle, that have never seen"));
    }
}
