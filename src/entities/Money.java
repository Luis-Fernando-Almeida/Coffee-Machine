package entities;

import java.util.Scanner;

public class Money {

    private static final String CURRENCY = "reais";
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
        System.out.println("Money: " + profit + " " + CURRENCY);
    }

    public double processCoins(Scanner sc){
        System.out.println("Por favor insira moedas.");

        for (double coinValue : COIN_VALUES){
            System.out.printf("Quantas moedas de %.2f centavos você vai inserir?%n", coinValue);
            int coinCount = sc.nextInt();
            moneyReceived += coinValue * coinCount;
        }
        return moneyReceived;
    }

    public void makePayment(double price){
        if (moneyReceived >= price){
            double change = moneyReceived - price;
            System.out.println("Valor recebido: " + moneyReceived);
            System.out.printf("Aqui está seu troco: %.2f %s%n",  change,  CURRENCY);
            profit += price;
        } else {
            System.out.println("Desculpe nõa foi inserido dinheiro o suficiente, devolvendo seu dinheiro.");
        }
        moneyReceived = 0;
    }
}
