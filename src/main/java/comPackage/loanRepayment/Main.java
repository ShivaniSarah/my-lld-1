package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

class LoanRepaymentPlanner{

    public List<Installment> generateRepaymentPlan(BigDecimal[] interestRates, BigDecimal loanAmount, BigDecimal maxInterest ){

        for(int months = 12; months>=3;months--){
            List<Installment> schedule = new ArrayList<>();
            BigDecimal remaining = loanAmount;
            BigDecimal monthlyPrincipal = loanAmount.divide(BigDecimal.valueOf(months),10, RoundingMode.HALF_UP);
            BigDecimal totalInterest = BigDecimal.ZERO;

            for(int i = 0; i<months; i++){
                BigDecimal interestRate =  interestRates[i];
                BigDecimal interest = remaining.multiply(interestRate).divide(BigDecimal.valueOf(100));

                BigDecimal actualPrincipal = (i== months -1) ? remaining : monthlyPrincipal;
                BigDecimal totalPayment  = actualPrincipal.add(interest);

                schedule.add(new Installment(i+1,interestRate, remaining, actualPrincipal, interest, totalPayment));
                totalInterest = totalInterest.add(interest);
                remaining =remaining.subtract(actualPrincipal);

            }

            if(totalInterest.compareTo(maxInterest)<= 0){
                printSchedule(schedule, totalInterest);
                return schedule;
            }

        }
    System.out.println("No Valid plan");
    return  new ArrayList<>();
    }

    private void printSchedule(List<Installment> schedule, BigDecimal totalInterest){
        for(Installment installment : schedule){
            System.out.println(installment);
        }
        System.out.println("Total Cost of the plan "+ totalInterest.setScale(2,RoundingMode.HALF_UP));
    }


    public static void main(String[] args) {
        BigDecimal[] interestRates = {
                new BigDecimal( "1"),new BigDecimal("1.5"),new BigDecimal("1.5"),
                new BigDecimal( "3"),new BigDecimal("0.5"),new BigDecimal("0.5"),
                new BigDecimal( "0.5"),new BigDecimal("2"),new BigDecimal("2"),
                new BigDecimal( "2"),new BigDecimal("1.5"),new BigDecimal("1"),
        };

        BigDecimal loanAmount = new BigDecimal( "1000");
        BigDecimal maxInterest = new BigDecimal( "45");
        LoanRepaymentPlanner  loanRepaymentPlanner = new LoanRepaymentPlanner();
        loanRepaymentPlanner.generateRepaymentPlan(interestRates,loanAmount,maxInterest);

    }


}
