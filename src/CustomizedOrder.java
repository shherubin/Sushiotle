package sushiotle;

import java.util.ArrayList;
import java.util.List;

public class CustomizedOrder {

    private sushiotle.OrderType orderType;
    private sushiotle.OrderProtein orderProtein;
    private List<sushiotle.OrderFillings> orderFillings;
    private List fillings;


    private List sauces;

    public CustomizedOrder() {
    }

    public CustomizedOrder(sushiotle.OrderType orderType, sushiotle.OrderProtein orderProtein, List<sushiotle.OrderFillings> orderFillings) {
        this.orderType = orderType;
        this.orderProtein = orderProtein;
        this.orderFillings = orderFillings;
    }


    public sushiotle.OrderType getOrderType(sushiotle.OrderType orderType) {
        return this.orderType;
    } public void setOrderType(sushiotle.OrderType orderType) {
        this.orderType = orderType;
    }

    public sushiotle.OrderProtein getOrderProtein(sushiotle.OrderProtein orderProteins) {
        return orderProtein;
    } public void setOrderProtein(sushiotle.OrderProtein orderProtein) {
        this.orderProtein = orderProtein;
    }

    public List <sushiotle.OrderFillings> getFillings(List <sushiotle.OrderFillings> chosenOrderFillings) {
        return chosenOrderFillings;
    } public void setFillings(List <sushiotle.OrderFillings> fillings) { this.orderFillings = fillings; }

    public List getSauces() {
        return sauces;
    } public void setSauces(List sauces) { this.sauces = sauces; }


    @Override
    public String toString() {
        return
                "Order style: " + "[" + orderType + "]\n" +
                        "Order protein: " +  "[" + orderProtein + "]\n" +
                        "Fillings: " + orderFillings + "\n" +
                        "Sauces: " + sauces + "\n" +
                        "Your total for your order is: " + calculateTotal();

    }

    public double calculateTotal() {
        double fillingTotal = 0.0;
        for (int i = 0; i < orderFillings.size(); i++) {
            //want to take this value and set it to use outside the for loop for the return statement
            fillingTotal = fillingTotal + ((orderFillings.get(i).getFillingPrice()));

        }

        return orderType.getPriceOfType() + orderProtein.getPriceofProtein() + fillingTotal;
    }
}
