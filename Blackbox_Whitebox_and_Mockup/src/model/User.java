package model;

public class User
{
   private UserName userName;
   private Password password;
   private MyDate registerDate;

   public User(UserName userName, Password password)
   {
      this.userName = userName;
      this.password = password;
      this.registerDate = new MyDate();
   }

   public User(String userName, String password, String email)
   {
      this(new UserName(userName, email), new Password(password));
   }

   public String toString()
   {
      return userName + ", password = " + password;
   }

   public UserName getUserName()
   {
      return userName;
   }

   public Password getPassword()
   {
      return password;
   }

   public MyDate getRegisterDate()
   {
      return registerDate;
   }

}
