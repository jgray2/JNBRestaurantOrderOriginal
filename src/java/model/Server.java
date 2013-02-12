package model;

/**
 *
 * @author Jenni Burgmeier
 */
public class Server {

    private String entree;
    private String side;
    private String drink;
    private double entreeCost;
    private double sideCost;
    private double drinkCost;
    private double totalOrder;
    private double tax;
    private double taxPerc = 0.051;
    private double suggestedTip;
    private double tipPerc = 0.15;

    public Server() {
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public final double getEntreeCost() {
        if (entree.equals("Steak")) {
            entreeCost = 19.95;
        } else if (entree.equals("Chicken")) {
            entreeCost = 12.95;
        } else if (entree.equals("Lobster")) {
            entreeCost = 24.95;
        } else {
            entreeCost = 18.95;
        }
        return entreeCost;
    }

    public final double getSideCost() {
        if (side.equals("Salad")) {
            sideCost = 4.95;
        } else {
            sideCost = 3.95;
        }
        return sideCost;
    }

    public final double getDrinkCost() {
        if (drink.equals("Soda")){
            drinkCost = 1.95;
        } else if (drink.equals("Beer")) {
            drinkCost = 3.50;
        } else {
            drinkCost = 0;
        }
        return drinkCost;
    }
    
    public final void calculateOrder () {
        totalOrder = entreeCost + sideCost + drinkCost;
        tax = totalOrder * taxPerc;
        totalOrder = totalOrder + tax;
    }

    public final double getTotalOrder() {
        return totalOrder;
    }

    public final double getTax() {
        return tax;
    }

    public final double getSuggestedTip() {
        suggestedTip = totalOrder * tipPerc;
        return suggestedTip;
    }
    
    
}
