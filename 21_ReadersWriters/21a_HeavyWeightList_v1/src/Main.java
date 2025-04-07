public class Main
{
  public static void main(String[] args)
  {
    HeavyWeightList heavyList = new HeavyWeightList(3, 5);
    ReadWriteAccess sharedResource = new ListAccess(heavyList);
    Thread[] readers = new Thread[25];
    Thread[] writers = new Thread[2];
    for (int i = 0; i < readers.length; i++)
    {
      readers[i] = new Thread(new Reader(sharedResource), "Reader " + i);
      readers[i].start();
    }
    for (int i = 0; i < writers.length; i++)
    {
      writers[i] = new Thread(new Writer(sharedResource), "Writer " + i);
      writers[i].start();
    }
  }
}
