package comPackage.lld7_new.ExpenseStrategy;

import comPackage.lld7_new.Expense;
import comPackage.lld7_new.User;
import comPackage.lld7_new.UserController;

import java.util.HashMap;
import java.util.Map;

public class UnequalSplitStrategy implements ExpenseStrategy{
    private final UserController userController;

    public UnequalSplitStrategy(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void splitAmount(String userId, Expense expense) {
        double totalExpenses = expense.getSplitRatio().values().stream().mapToDouble(k->k).sum();
        if(totalExpenses>expense.getAmount()) throw  new IllegalArgumentException("UnEqual Split Expense incorrect");

        for(Map.Entry<String,Double> e: expense.getSplitRatio().entrySet()){
            double cursplitAmount = e.getValue();
            String OweUserId = e.getKey();
            User Oweuser = userController.getUser(OweUserId);
            Map<String,Double> temp =new HashMap<>();
            temp.put(userId,-cursplitAmount);
            Oweuser.updateOweAmount(temp);
        }
    }
}
