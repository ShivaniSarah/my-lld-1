package comPackage.lld2.DesignATM.ATMStates;

import comPackage.lld2.DesignATM.ATM;
import comPackage.lld2.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
