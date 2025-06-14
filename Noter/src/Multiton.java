import java.util.HashMap;
import java.util.Map;

public class Multiton
{
  private static Map<String, Multiton> map = new HashMap<>();

  private Multiton()
  { /* ... */ }

  public static Multiton getInstance(String key)
  {
    Multiton instance = map.get(key);
    if (instance == null)
    {
      synchronized (map)
      {
        instance = map.get(key);
        if (instance == null)
        {
          instance = new Multiton();
          map.put(key, instance);
        }
      }
    }
    return instance;
  }
  //...
}