package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Log
{
  private static Log instance;
  private static Object lock = new Object();
  private ArrayList<LogLine> logLines;

  private Log()
  {
    logLines = new ArrayList<>();
  }

  public static Log getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new Log();
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
      String filename = "Log-" + log.getDateTime().getSortableDate() + ".txt";
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
