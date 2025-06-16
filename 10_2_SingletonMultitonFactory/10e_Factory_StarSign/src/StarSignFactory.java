import java.util.HashMap;
import java.util.Map;

public abstract class StarSignFactory
{
  private Map<String, StarSign> starSigns = new HashMap<>();

  protected abstract StarSign createStarSign(String name);

  public StarSign getStarSign(String name)
  {
    if (!starSigns.containsKey(name))
    {
      StarSign starSign = createStarSign(name);
      starSigns.put(name, starSign);
    }
    return starSigns.get(name);
  }
}
