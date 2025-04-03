package model;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;

public interface Model extends UnnamedPropertyChangeSubject
{
  String convert(String source) throws Exception;
  void addLog(String log);
  void addListener(PropertyChangeListener listener);
  void removeListener(PropertyChangeListener listener);
}