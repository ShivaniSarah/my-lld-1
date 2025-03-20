package comPackage.lld7_new;

import comPackage.lld7_new.ExpenseStrategy.ExpenseStrategy;

import java.util.HashMap;
import java.util.Map;

public class ExpenseController {

    private final ExpenseStrategy expenseStrategy;

    public ExpenseController(ExpenseStrategy expenseStrategy) {
        this.expenseStrategy = expenseStrategy;
    }

    public void splitAmount(String userId, Expense expense){

       expenseStrategy.splitAmount(userId,expense);

    }
}
