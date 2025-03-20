package comPackage.lld7_new;

import comPackage.lld7_new.ExpenseType;
import lombok.Getter;

import java.util.Map;


public class Expense {
     private final String expenseId;
     private final Double amount;
     private final ExpenseType expenseType;
     private final Map<String,Double> splitRatio;

    public Expense(String expenseId, Double amount, ExpenseType expenseType, Map<String, Double> splitRatio) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.expenseType = expenseType;
        this.splitRatio = splitRatio;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public Double getAmount() {
        return amount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public Map<String, Double> getSplitRatio() {
        return splitRatio;
    }
}
