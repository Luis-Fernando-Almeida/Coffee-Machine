package entities;

import java.util.HashMap;
import java.util.Map;

public class CoffeMaker {
    private Map<String, Integer> resources;

    public CoffeMaker() {
        this.resources = new HashMap<>();
        initialResources();
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    private void initialResources() {
        resources.put("water", 300);
        resources.put("milk", 300);
        resources.put("coffee", 300);
    }

    public void report() {
        System.out.println(resources);
    }

    public boolean areResourcesSufficient(MenuItem menuItem) {
        boolean canMake = true;

        for (Map.Entry<String, Integer> entry : menuItem.getIngredients().entrySet()) {
            String item = entry.getKey();
            int requiredAmount = entry.getValue();

            if (requiredAmount > resources.getOrDefault(item, 0)) {
                System.out.println("Desculpe, não temos: " + item);
                canMake = false;
            }
        }
        return canMake;
    }

    public void makeCoffee(MenuItem menuItem) {
        Map<String, Integer> ingredients = menuItem.getIngredients();
        for (Map.Entry<String, Integer> entry : ingredients.entrySet()){
            String item = entry.getKey();
            int requiredAmount = entry.getValue();
            resources.put(item, resources.getOrDefault(item, 0) - requiredAmount);
        }
        System.out.println("Saindo um " + menuItem.getName() + "!");
    }

}
