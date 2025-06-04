package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Installment {

    int number;
    BigDecimal interestRate;
    BigDecimal remaingBalance;

    @Override
    public String toString() {
        return "Installment{" +
                "number=" + number +
                ", interestRate=" + interestRate +
                ", remaingBalance=" + remaingBalance +
                ", principalInstallment=" + principalInstallment +
                ", interest=" + interest +
                ", totalRepayment=" + totalRepayment +
                '}';
    }

    BigDecimal principalInstallment;
    BigDecimal interest;
    BigDecimal totalRepayment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Installment that = (Installment) o;
        return number == that.number && Objects.equals(interestRate, that.interestRate) && Objects.equals(remaingBalance, that.remaingBalance) && Objects.equals(principalInstallment, that.principalInstallment) && Objects.equals(interest, that.interest) && Objects.equals(totalRepayment, that.totalRepayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, interestRate, remaingBalance, principalInstallment, interest, totalRepayment);
    }

    public Installment(int number, BigDecimal interestRate, BigDecimal remaingBalance,
                       BigDecimal principalInstallment, BigDecimal interest, BigDecimal totalRepayment
                       ){

        this.number = number;
        this.interestRate = interestRate;
        this.remaingBalance = remaingBalance;
        this.principalInstallment = principalInstallment;
        this.interest = interest;
        this.totalRepayment = totalRepayment;

    }

}
