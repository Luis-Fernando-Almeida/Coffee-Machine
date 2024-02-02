package entities;

import java.util.Scanner;

public class Money {

    private static final String CURRENCY = "REAIS";
    private static final int[] COIN_VALUES  = {50,25,10,5};
    private double profit;
    private double moneyReceived;

    public Money() {}

    public Money(double profit, double moneyReceived) {
        this.profit = profit;
        this.moneyReceived = moneyReceived;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getMoneyReceived() {
        return moneyReceived;
    }

    public void setMoneyReceived(double moneyReceived) {
        this.moneyReceived = moneyReceived;
    }

    public void report(){
        System.out.println("Money: " + profit + " " + CURRENCY);
    }

    public double processCoins(Scanner sc){
        System.out.println("Por favor insira moedas.");

        for (double coinValue : COIN_VALUES){
            System.out.printf("Quantas moedas de %.0f centavos você vai inserir?%n", coinValue);
            int coinCount = sc.nextInt();
            moneyReceived += coinValue * coinCount;
        }
        return moneyReceived;
    }

    public boolean makePaymeynt(double price){
        if (moneyReceived >= price){
            double change = Math.round((moneyReceived - price)* 100);
            System.out.println(moneyReceived);
            System.out.println("Here is " + CURRENCY + change + "in change");
            profit += price;
            moneyReceived = 0;
            return true;
        } else {
            System.out.println("Sorry that's not enough money. Money refunded.");
            moneyReceived = 0;
            return false;
        }
    }
}
