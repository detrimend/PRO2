public class Main
{
  public static void main(String[] args)
  {
    Burgerbar burgerbar = new Burgerbar(50);

    BurgerBarEmployee employee1 = new BurgerBarEmployee("Martin", burgerbar);
    BurgerBarEmployee employee2 = new BurgerBarEmployee("Rasmus", burgerbar);

    BurgerBarCustomer customer1 = new BurgerBarCustomer("Oksen", burgerbar, 5);
    BurgerBarCustomer customer2 = new BurgerBarCustomer("Marx", burgerbar, 9);
    BurgerBarCustomer customer3 = new BurgerBarCustomer("Steffen", burgerbar, 6);
    BurgerBarCustomer customer4 = new BurgerBarCustomer("Wabungus", burgerbar, 10);
    BurgerBarCustomer customer5 = new BurgerBarCustomer("Sumsar", burgerbar, 2);

    Thread eThread1 = new Thread(employee1);
    Thread eThread2 = new Thread(employee2);

    Thread cThread1 = new Thread(customer1);
    Thread cThread2 = new Thread(customer2);
    Thread cThread3 = new Thread(customer3);
    Thread cThread4 = new Thread(customer4);
    Thread cThread5 = new Thread(customer5);

    eThread1.start();
    eThread2.start();

    cThread1.start();
    cThread2.start();
    cThread3.start();
    cThread4.start();
    cThread5.start();
  }
}
