package comPackage.lld7_new.ExpenseStrategy;

import comPackage.lld7_new.Expense;
import comPackage.lld7_new.User;
import comPackage.lld7_new.UserController;

import java.util.HashMap;
import java.util.Map;

public class EqualSplitStrategy implements ExpenseStrategy{
    private final UserController userController;

    public EqualSplitStrategy(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void splitAmount(String userId, Expense expense) {
        double cursplitAmount=  expense.getAmount()/(expense.getSplitRatio().size()+1);
        for(Map.Entry<String,Double> e: expense.getSplitRatio().entrySet()){
            String OweUserId = e.getKey();
            User Oweuser = userController.getUser(OweUserId);
            Map<String,Double> temp =new HashMap<>();
            temp.put(userId,-cursplitAmount);
            Oweuser.updateOweAmount(temp);
        }
    }
}
