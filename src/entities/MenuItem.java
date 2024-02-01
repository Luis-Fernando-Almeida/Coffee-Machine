package entities;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class MenuItem {
    private String name;
    private double cost;
    private Map<String, Integer> ingredients;

    public MenuItem() {
    }

    public MenuItem(String name, double cost, Map<String, Integer> ingredients) {
        this.name = name;
        this.cost = cost;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", Ingredients=" + ingredients +
                '}';
    }

}
