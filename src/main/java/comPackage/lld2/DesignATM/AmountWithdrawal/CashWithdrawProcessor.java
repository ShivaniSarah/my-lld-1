package comPackage.lld2.DesignATM.AmountWithdrawal;

import comPackage.lld2.DesignATM.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawalProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {

        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;

    }

    public void withdraw(ATM atm, int remainingAmount) {

        if (nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}
