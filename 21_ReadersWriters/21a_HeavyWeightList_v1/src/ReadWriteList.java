public interface ReadWriteList extends ReadList
{
  void write(int value);
  @Override int read();
}
