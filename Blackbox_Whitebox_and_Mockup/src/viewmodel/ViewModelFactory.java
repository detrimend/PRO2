package viewmodel;

import model.UserModel;

public class ViewModelFactory
{
  private CreateAccountViewModel createAccountViewModel;
  private MessageViewModel messageViewModel;

  public ViewModelFactory(UserModel model)
  {
    createAccountViewModel = new CreateAccountViewModel(model);
    messageViewModel = new MessageViewModel(model);
  }

  public CreateAccountViewModel getCreateAccountViewModel()
  {
    return createAccountViewModel;
  }

  public MessageViewModel getMessageViewModel()
  {
    return messageViewModel;
  }
}
