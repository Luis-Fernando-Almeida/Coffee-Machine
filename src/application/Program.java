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
        Money money = new Money();

        MenuItem menuItem = new MenuItem();
        MenuItem espresso = new MenuItem("Espresso", 1.5, Map.of("water", 50, "coffee", 18));
        MenuItem latte = new MenuItem("Latte", 2.5, Map.of("water", 200, "milk", 150, "coffee", 24));
        MenuItem cappuccino = new MenuItem("Cappuccino", 3.0, Map.of("water", 250, "milk", 100, "coffee", 24));


        boolean machineOn = true;
        while (true) {

            System.out.println("O que você deseja ? (Espresso, Latte, Cappuccino)");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("off")) {
                machineOn = false;
                break;
            } else if (choice.equalsIgnoreCase("report")) {
                coffeMaker.report();
                money.report();
            } else if (choice.equalsIgnoreCase("espresso")) {
                System.out.println("Bebida escolhida: " + espresso.getName() + " - Valor: " + espresso.getCost());
                coffeMaker.areResourcesSufficient(cappuccino);
                money.processCoins(sc);
                money.makePayment(1.5);
                coffeMaker.makeCoffee(espresso);
                System.out.println();


            } else if (choice.equalsIgnoreCase("latte")) {
                System.out.println("Bebida escolhida: " + latte.getName() + " - Valor: " + latte.getCost());
                coffeMaker.areResourcesSufficient(latte);
                money.processCoins(sc);
                money.makePayment(2.5);
                coffeMaker.makeCoffee(latte);
                System.out.println();


            } else if (choice.equalsIgnoreCase("cappuccino")) {
                System.out.println("Bebida escolhida: " + cappuccino.getName() + " - Valor: " + cappuccino.getCost());
                coffeMaker.areResourcesSufficient(cappuccino);
                money.processCoins(sc);
                money.makePayment(3.0);
                coffeMaker.makeCoffee(cappuccino);
                System.out.println();

            }
        }
    }
}



