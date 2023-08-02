package sushiotle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SushiotleClient {
    public static void runSushiotle() {

        Scanner stdin= new Scanner(System.in);
        String input = "";
        boolean activeOrdering = true;


        List totalOrder = new ArrayList();
        sushiotle.CustomizedOrder firstOrder = new sushiotle.CustomizedOrder();
        List<sushiotle.OrderFillings> firstOrderFillings = new ArrayList<>();
        //CustomizedOrder secondOrder = new CustomizedOrder();
        List menuNavigator = new ArrayList();



        totalOrder.add(firstOrder);
        //totalOrder.add(secondOrder);
        menuNavigator.add("1. Protein selection");
        menuNavigator.add("2. Filling Selection");
        menuNavigator.add("3. Sauce Selection");
        menuNavigator.add("4. Add another item");
        menuNavigator.add("5. Checkout");
        firstOrder.setOrderType(pickASushiType());


        while(activeOrdering) {
            System.out.println("What would you like to add to you sushi?(Please select the menu number)");
            printListStatus(menuNavigator);

            input = stdin.nextLine();

            //struggle with the passing and use of lists and objects in methods and best way to receive multiple object information items.
            if(input.equalsIgnoreCase("1")){
                firstOrder.setOrderProtein(pickAProtein());
            } else if(input.equalsIgnoreCase("2")) {
                firstOrder.setFillings(pickFillings());
            } else if(input.equalsIgnoreCase("3")) {
                firstOrder.setSauces(pickSauces());
            } else if(input.equalsIgnoreCase("4")) {

            } else if(input.equalsIgnoreCase("5")) {
                checkout(totalOrder);
                activeOrdering = false;
            } else {
                System.out.println("Please pick a valid destination number.");
            }
        }
    }
    public static sushiotle.OrderType pickASushiType() {


        Scanner stdin = new Scanner(System.in);
        String input = "";
        List<sushiotle.OrderType> availableTypesOfSushi = new ArrayList<>();
        sushiotle.OrderType customerSelectedTypeOfSushi = new sushiotle.OrderType();
        boolean activeOrder = true;

        sushiotle.OrderType roll = new sushiotle.OrderType(  4.99, "You've chosen a roll.", "1. Sushi roll; starting at $4.99");
        sushiotle.OrderType bowl = new sushiotle.OrderType(  6.99, "You've chosen a Poke Bowl.", "2. Poke Bowl, starting at $6.99");

        availableTypesOfSushi.add(roll);
        availableTypesOfSushi.add(bowl);

        while(activeOrder) {
            System.out.println("Welcome to Sushiotle, Please select your type of sushi.(enter the menu number)");
            for (int i = 0; i < availableTypesOfSushi.size(); i++) {
                System.out.println(availableTypesOfSushi.get(i).getGreeting());
            }

            input = stdin.nextLine();
            if (input.equalsIgnoreCase("1")) {
                System.out.println("You have selected a sushi roll.");
                activeOrder = false;
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("You have selected a poke bowl.");
                activeOrder = false;
            } else {
                System.out.println("You are suppose to enter either 1 for a Roll or 2 for a Bowl.");
            }
            customerSelectedTypeOfSushi = (availableTypesOfSushi.get(Integer.parseInt(input) - 1));
        }
        return customerSelectedTypeOfSushi;
    }

    public static sushiotle.OrderProtein pickAProtein() {
        Scanner stdin = new Scanner(System.in);
        String input = "";
        List<sushiotle.OrderProtein> availableTypesOfProtein = new ArrayList<>();
        sushiotle.OrderProtein customerSelectedTypeOfProtein = new sushiotle.OrderProtein();

        sushiotle.OrderProtein salmon = new sushiotle.OrderProtein(2.99, "1. Salmon","Protein selected is Salmon.");
        sushiotle.OrderProtein tuna = new sushiotle.OrderProtein(1.99, "2. Tuna", "Protein selected is Tuna.");
        sushiotle.OrderProtein yellowTail = new sushiotle.OrderProtein(2.99, "3. Yellow Tail", "Protein selected is Yellow Tail.");

        availableTypesOfProtein.add(salmon);
        availableTypesOfProtein.add(tuna);
        availableTypesOfProtein.add(yellowTail);

        System.out.println("Please select a type of fish to add to your order(enter the menu number).");
        for( int i = 0; i < availableTypesOfProtein.size(); i++) {
            System.out.println(availableTypesOfProtein.get(i));
        }

        input = stdin.nextLine();
        customerSelectedTypeOfProtein = (availableTypesOfProtein.get(Integer.parseInt(input) - 1));

        return customerSelectedTypeOfProtein;
    }
    //confusion on whether to return the object or just the list of the objects
    public static List<sushiotle.OrderFillings> pickFillings() {

        Scanner stdin = new Scanner(System.in);
        String input = "";

        List<sushiotle.OrderFillings> availableFillings = new ArrayList(12);
        List<sushiotle.OrderFillings> customersSelectedFillings  = new ArrayList<>(10);

        sushiotle.OrderFillings avocado = new sushiotle.OrderFillings("1. Avocado", 1.99);
        sushiotle.OrderFillings cucumber = new sushiotle.OrderFillings("2. Cucumber", 0.99);
        sushiotle.OrderFillings redCabbage = new sushiotle.OrderFillings("3. Red Cabbage", 0.99);
        sushiotle.OrderFillings corn = new sushiotle.OrderFillings("4. Corn", 0.99);
        sushiotle.OrderFillings lettuce = new sushiotle.OrderFillings("5. Lettuce", 0.00);
        sushiotle.OrderFillings carrots = new sushiotle.OrderFillings("6. Carrots", 0.99);
        sushiotle.OrderFillings daikon = new sushiotle.OrderFillings("7. Daikon", 1.49);
        sushiotle.OrderFillings tamago = new sushiotle.OrderFillings("8. Tamago", 1.99);
        sushiotle.OrderFillings salmonRoe = new sushiotle.OrderFillings("9. Salmon Roe", 1.99);
        sushiotle.OrderFillings sesameSeeds = new sushiotle.OrderFillings("10. Sesame Seeds", 0.00);
        sushiotle.OrderFillings bonitoFlakes = new sushiotle.OrderFillings("11. Bonito Flakes", 0.99);
        sushiotle.OrderFillings jalapenos = new sushiotle.OrderFillings("12. Jalapenos", 0.99);

        availableFillings.add(avocado);
        availableFillings.add(cucumber);
        availableFillings.add(redCabbage);
        availableFillings.add(corn);
        availableFillings.add(lettuce);
        availableFillings.add(carrots);
        availableFillings.add(daikon);
        availableFillings.add(tamago);
        availableFillings.add(salmonRoe);
        availableFillings.add(sesameSeeds);
        availableFillings.add(bonitoFlakes);
        availableFillings.add(jalapenos);

        boolean addFillingFlag = true;

        while(addFillingFlag) {

            System.out.println("Please choose one filling from the list below(Select the item number,You may add more later)");
            for(int i = 0; i < availableFillings.size(); i++ ) {
                System.out.println(availableFillings.get(i));
            }

            input = stdin.nextLine();
            customersSelectedFillings.add(availableFillings.get(Integer.parseInt(input) - 1));
            for(int i = 0; i < customersSelectedFillings.size(); i++ ) {
                System.out.println("Current fillings include " + customersSelectedFillings.get(i));
            }
            if(input.equals("1") || input.equals("8") || input.equals("9")) {
                System.out.println("You've selected a premium topping(+1.99)");
            }

            if(customersSelectedFillings.equals(10)) {
                System.out.println("You cannot add anymore fillings.");
                addFillingFlag = false;
            } else {
                System.out.println("Would you like to add more fillings? Y/N?");
                input = stdin.nextLine();
                if (input.equalsIgnoreCase("Y")) {
                    addFillingFlag = true;
                } else if(input.equalsIgnoreCase("N")) {
                    addFillingFlag = false;
                } else {
                    System.out.println("Invalid answer, you will be taken back to the menu navigator.");
                    addFillingFlag = false;
                }
            }
        }
        return customersSelectedFillings;
    }

    public static List pickSauces() {
        Scanner stdin = new Scanner(System.in);
        String input = "";
        List<String> availableSauces = new ArrayList();
        List<String> customerSelectedSauces = new ArrayList<>(3);

        availableSauces.add("1. Spicy Mayo");
        availableSauces.add("2. Ponzu");
        availableSauces.add("3. Unagi Sauce");
        availableSauces.add("4. Wasabi Mayo");
        availableSauces.add("5. Sweet Pepper Sacue");

        boolean addFillingFlag = true;
        while (addFillingFlag) {
            System.out.println("Please pick which sauce you would like in your sushi.(enter menu item number)");

            for (int i = 0; i < availableSauces.size(); i++) {
                System.out.println(availableSauces.get(i));
            }


            input = stdin.nextLine();
            customerSelectedSauces.add(availableSauces.get(Integer.parseInt(input) - 1));
            if (customerSelectedSauces.size() == 3) {
                System.out.println("You cannot add anymore sauces.");
                addFillingFlag = false;
            } else {
                System.out.println("Would you like to add more sauces? Y/N?");
                input = stdin.nextLine();
                if (input.equalsIgnoreCase("Y")) {
                    addFillingFlag = true;
                } else if (input.equalsIgnoreCase("N")) {
                    addFillingFlag = false;
                }
            }
        }
        return customerSelectedSauces;

    }

    public static void printListStatus(List creationOrder) {
        for(int i = 0; i < creationOrder.size(); i++) {
            System.out.println(creationOrder.get(i));
        }
    }

    public static void checkout(List customerCompleteOrder) {
        for ( int i = 0; i < customerCompleteOrder.size(); i++) {

            System.out.println(customerCompleteOrder.get(i));

        }
    }
}
