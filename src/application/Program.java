package application;

import entities.CoffeMaker;

import entities.MenuItem;
import entities.Money;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        CoffeMaker coffeMaker = new CoffeMaker();
        MenuItem menuItem = new MenuItem();
        Money money = new Money();

        MenuItem espresso = new MenuItem("Espresso", 1.5, Map.of("water", 50, "coffee", 18));
        MenuItem latte = new MenuItem("Latte", 2.5, Map.of("water", 200, "milk", 150, "coffee", 24));
        MenuItem cappuccino = new MenuItem("Cappuccino", 3.0, Map.of("water", 250, "milk", 100, "coffee", 24));


        boolean machineOn = true;
        while (true) {

            System.out.println("What would you like? (Espresso, Latte, Cappuccino, Off, Report)");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("off")) {
                machineOn = false;
                break;
            } else if (choice.equalsIgnoreCase("report")) {
                coffeMaker.report();
            } else if (choice.equalsIgnoreCase("espresso")) {
                money.processCoins(sc);
                money.makePaymeynt(1.5);
                coffeMaker.areResourcesSufficiente(cappuccino);
                coffeMaker.makeCoffee(espresso);

            } else if (choice.equalsIgnoreCase("latte")) {
                money.processCoins(sc);
                money.makePaymeynt(2.5);
                coffeMaker.areResourcesSufficiente(latte);
                coffeMaker.makeCoffee(latte);

            } else if (choice.equalsIgnoreCase("cappuccino")) {
                money.processCoins(sc);
                money.makePaymeynt(3.0);
                coffeMaker.areResourcesSufficiente(cappuccino);
                coffeMaker.makeCoffee(cappuccino);
            }
        }
    }
}



