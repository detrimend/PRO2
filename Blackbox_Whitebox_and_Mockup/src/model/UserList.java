package model;

import java.util.ArrayList;

public class UserList
{
  private ArrayList<User> users;

  public UserList()
  {
    this.users = new ArrayList<>();
  }

  public int size()
  {
    return users.size();
  }

  public User getUser(int index)
  {
    return users.get(index);
  }

  public User getUserByEmail(String email)
  {
    for (int i = 0; i < users.size(); i++)
    {
      if (users.get(i).getUserName().getEmail().toString()
          .equalsIgnoreCase(email))
      {
        return users.get(i);
      }
    }
    return null;
  }

  public User getUserByEmail(Email email)
  {
    for (int i = 0; i < users.size(); i++)
    {
      if (users.get(i).getUserName().getEmail().equals(email))
      {
        return users.get(i);
      }
    }
    return null;
  }

  public User getUserByName(String name)
  {
    for (int i = 0; i < users.size(); i++)
    {
      if (users.get(i).getUserName().getName().equalsIgnoreCase(name))
      {
        return users.get(i);
      }
    }
    return null;
  }

  public void addUser(User user)
  {
    if (!contains(user))
    {
      users.add(user);
    }
    else
    {
      throw new IllegalStateException("User already exist");
    }
  }

  public void addUser(UserName userName, Password password)
  {
    addUser(new User(userName, password));
  }

  public void addUser(String userName, String password, String email)
  {
    addUser(new User(userName, password, email));
  }

  public boolean contains(User user)
  {
    return getUserByEmail(user.getUserName().getEmail()) != null
        || getUserByName(user.getUserName().getName()) != null;
  }

  @Override public String toString()
  {
    return "UserList{" + "users=" + users + '}';
  }
}
