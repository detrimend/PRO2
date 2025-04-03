package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Log
{
  private static Map<String, Log> map = new HashMap<>();
  private ArrayList<LogLine> logLines;
  private String filename;

  private Log(String filename)
  {
    logLines = new ArrayList<>();
    this.filename = filename;
  }

  public static Log getInstance(String filename)
  {
    Log instance = map.get(filename);
    if (instance == null)
    {
      synchronized (map)
      {
        instance = map.get(filename);
        if (instance == null)
        {
          instance = new Log(filename);
          map.put(filename, instance);
        }
      }
    }
    return instance;
  }

  public void addLog(String text)
  {
    LogLine log = new LogLine(text);
    logLines.add(log);
    addToFile(log);
    System.out.println(log.toString());
  }

  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();
    for (LogLine log : logLines)
    {
      sb.append(log).append("\n");
    }
    return sb.toString();
  }

  private void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      out = new BufferedWriter(new FileWriter(filename, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
