import java.util.ArrayList;

public class ThreadMain
{
  public static void main(String[] args)
  {
    ArrayList<String> list = new ArrayList<>();
    Adding adding = new Adding(list, "A", 1000);
    Thread thread = new Thread(adding);

    thread.start();

    System.out.println(list);
  }
}
