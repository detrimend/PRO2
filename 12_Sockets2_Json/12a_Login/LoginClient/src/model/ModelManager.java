package model;

import mediator.UserClient;

public class ModelManager implements Model
{
  private UserClient userClient;

  public ModelManager()
  {
    this.userClient = new UserClient("localhost", 2910);
  }

  public void login(String userName, String password)
      throws IllegalStateException, IllegalArgumentException
  {
    userClient.login(userName, password);
  }
}
