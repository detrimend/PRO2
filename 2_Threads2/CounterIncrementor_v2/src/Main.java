public class Main
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(-10, 10);

    CounterIncrementor c1 = new CounterIncrementor(counter, 200);
    CounterIncrementor c2 = new CounterIncrementor(counter, 200);
    CounterDecrementor d1 = new CounterDecrementor(counter, 200);
    CounterDecrementor d2 = new CounterDecrementor(counter, 200);

    Thread t1 = new Thread(c1, "Incrementor1");
    Thread t2 = new Thread(c2, "Incrementor2");
    Thread t3 = new Thread(d1, "Decrementor1");
    Thread t4 = new Thread(d2, "Decrementor2");

    t1.start();
    t2.start();
    t3.start();
    t4.start();

    System.out.println(Thread.currentThread().getName() + ": " + counter.getValue());
  }
}
