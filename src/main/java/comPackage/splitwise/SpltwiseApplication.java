package comPackage.lld7_new;

import comPackage.lld7_new.ExpenseController;
import comPackage.lld7_new.ExpenseStrategy.EqualSplitStrategy;
import comPackage.lld7_new.ExpenseStrategy.PercentageSplitStrategy;
import comPackage.lld7_new.ExpenseStrategy.UnequalSplitStrategy;
import comPackage.lld7_new.ExpenseType;
import comPackage.lld7_new.Expense;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpltwiseApplication {


    public static void main(String args[]){

        UserController userController = new UserController();
        User user1 = new User("user001","S");
        User user2 = new User("user002","U");
        User user3 = new User("user003","G");
        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
        ExpenseController expenseController = new ExpenseController(new UnequalSplitStrategy((userController)));

        // Transaction 1
        Map<String,Double> expenseRatio = new LinkedHashMap<>();
        expenseRatio.put("user002",50d);
        expenseRatio.put("user003",40d);
        System.out.println("User 1 spent 3000 ");
        Expense expense = new Expense("expense001",3000d, ExpenseType.PERCENTAGE,expenseRatio);

        expenseController.splitAmount("user001",expense);
        System.out.println("user1 owe amount: "+ user1.showOweAmount());
        System.out.println("user2 owe amount: "+ user2.showOweAmount());
        System.out.println("user3 owe amount: "+ user3.showOweAmount());

        // Transaction 2
        Map<String,Double> expenseRatio2 = new LinkedHashMap<>();
        expenseRatio2.put("user001",10d);
        expenseRatio2.put("user003",70d);
        Expense expense2 = new Expense("expense002",6000d, ExpenseType.PERCENTAGE,expenseRatio2);

        expenseController.splitAmount("user002",expense2);
        System.out.println("User 2 spent 6000 ");
        System.out.println("user1 owe amount: "+ user1.showOweAmount());
        System.out.println("user2 owe amount: "+ user2.showOweAmount());
        System.out.println("user3 owe amount: "+ user3.showOweAmount());

        // show balance
        System.out.println("user1 balance: "+ user1.showBalance());
        System.out.println("user2 balance: "+ user2.showBalance());
        System.out.println("user3 balance: "+ user3.showBalance());
    }
}
