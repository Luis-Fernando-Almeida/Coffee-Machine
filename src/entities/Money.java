package entities;

import java.util.Scanner;

public class Money {

    private static final String CURRENCY = "BRL";
    private static final double[] COIN_VALUES  = {0.50,0.25,0.10,0.05};
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
        System.out.println("Money: " + CURRENCY + profit);
    }

    public double processCoins(Scanner sc){
        System.out.println("Please insert coins.");

        for (double coinValue : COIN_VALUES){
            System.out.println("How many " + coinValue + " coins would you like to insert?");
            int coinCount = sc.nextInt();
            moneyReceived += coinValue * coinCount;
        }
        return moneyReceived;
    }

    public boolean makePaymeynt(double price){
        processCoins(new Scanner(System.in));
        if (moneyReceived >= price){
            double change = Math.round((moneyReceived - price)*100);
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
