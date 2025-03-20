package comPackage.lld7_new;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class User {
    private final String userId;
    private final String userName;
    private final Map<String,Double> oweAmount;
    private double balance;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.oweAmount = new HashMap<>();
        this.balance =0d;
    }
    public void updateOweAmount(Map<String,Double> newOweAmount){
        for(Map.Entry<String,Double> e: newOweAmount.entrySet()){
            oweAmount.put(e.getKey(),oweAmount.getOrDefault(e.getKey(),0d)+ e.getValue());
            balance+= e.getValue();
        }
    }
    public Map<String,Double> showOweAmount(){
        return oweAmount;
    }

    public double showBalance(){
        return  balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Map<String, Double> getOweAmount() {
        return oweAmount;
    }

    public double getBalance() {
        return balance;
    }
}
