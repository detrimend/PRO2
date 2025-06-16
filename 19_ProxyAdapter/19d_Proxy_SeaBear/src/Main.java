public class Main
{
  public static void main(String[] args)
  {
    VisitSeaBear seaBear = new SeaBear();
    VisitSeaBear seaBearGuard = new SeaBearGuard(seaBear);
    ZooVisitor zookeeper = new ZooVisitor(seaBearGuard, "zookeeper");
    ZooVisitor child = new ZooVisitor(seaBearGuard, "child");
    ZooVisitor adult = new ZooVisitor(seaBearGuard, "adult");

    adult.viewSeaBear();
    adult.feedSeaBear();

    child.viewSeaBear();
    child.petSeaBear();

    zookeeper.feedSeaBear();
    zookeeper.petSeaBear();
  }
}
