package application;

import entities.CoffeeMaker;

import entities.MenuItem;
import entities.Money;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Money money = new Money();

        MenuItem menuItem = new MenuItem();
        MenuItem espresso = new MenuItem("Espresso", 1.5, Map.of("leite", 50, "café", 18));
        MenuItem latte = new MenuItem("Latte", 2.5, Map.of("água", 200, "leite", 150, "café", 24));
        MenuItem cappuccino = new MenuItem("Cappuccino", 3.0, Map.of("água", 250, "leite", 100, "café", 24));

        boolean machineOn = true;
        while (machineOn) {
            System.out.println("O que você deseja? (Espresso, Latte, Cappuccino)");

            String choice = sc.nextLine().trim().toLowerCase();


            switch (choice) {
                case "espresso":
                    System.out.println("Bebida escolhida: " + espresso.getName() + " - Valor: " + espresso.getCost());
                    if (coffeeMaker.areResourcesSufficient(espresso)) {
                        money.processCoins(sc);
                        if (money.makePayment(1.5)) {
                            coffeeMaker.makeCoffee(espresso);
                            System.out.println();
                            sc.nextLine();
                        }
                    }
                    break;
                case "latte":
                    System.out.println("Bebida escolhida: " + latte.getName() + " - Valor: " + latte.getCost());
                    if (coffeeMaker.areResourcesSufficient(latte)) {
                        money.processCoins(sc);
                        if (money.makePayment(2.5)) {
                            coffeeMaker.makeCoffee(latte);
                            System.out.println();
                            sc.nextLine();
                        }
                    }
                    break;
                case "cappuccino":
                    System.out.println("Bebida escolhida: " + cappuccino.getName() + " - Valor: " + cappuccino.getCost());
                    if (coffeeMaker.areResourcesSufficient(cappuccino)) {
                        money.processCoins(sc);
                        if (money.makePayment(3.0)) {
                            coffeeMaker.makeCoffee(cappuccino);
                            System.out.println();
                            sc.nextLine();
                        }
                    }
                    break;
                case "report":
                    coffeeMaker.report();
                    money.report();
                    break;
                case "off":
                    machineOn = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println();
                    break;
            }
        }
    }
}





