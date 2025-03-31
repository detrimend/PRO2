package model;

public class UserModelManager implements UserModel
{
  private UserList list;

  public UserModelManager()
  {
    list = new UserList();
  }

  @Override public void addUser(String userName, String password, String email)
  {
    list.addUser(userName, password, email);
  }

  @Override public User getUser(String userName)
  {
    return list.getUserByName(userName);
  }

  @Override public int getUserCount()
  {
    return list.size();
  }
}
