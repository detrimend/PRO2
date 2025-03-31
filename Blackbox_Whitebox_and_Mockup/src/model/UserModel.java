package model;

public interface UserModel
{
  public void addUser(String userName, String password, String email);

  public User getUser(String userName);

  public int getUserCount();
}
