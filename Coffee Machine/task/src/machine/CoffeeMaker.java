package machine;

import java.util.Scanner;

public class CoffeeMaker {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMaker() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    protected void changeAction(String cmd) {
        Scanner scanner = new Scanner(System.in);
        switch (cmd) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String typeOfCoffee = scanner.next();
                if (typeOfCoffee.equals("back")) {
                    break;
                }
                buy(Integer.parseInt(typeOfCoffee));
            }
            case "fill" -> {
                System.out.println("Write how many ml of water you want to add: ");
                int water = scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                int milk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                int beans = scanner.nextInt();
                System.out.println("Write how many disposable cups you want to add: ");
                int cups = scanner.nextInt();
                fill(water, milk, beans, cups);
            }
            case "take" -> {
                take();
            }
            case "remaining" -> {
                remaining();
            }
        }
    }

    protected void remaining() {
        System.out.printf("The coffee machine has: %n" +
                "%d ml of water %n" +
                "%d ml of milk %n" +
                "%d g of coffee beans %n" +
                "%d disposable cups %n" +
                "$%d of money %n", this.water, this.milk, this.beans, this.cups, this.money);
    }

    protected void buy(int type) {
        switch (type) {
            case 1 -> {
                if (!hasIngredients(250, 0, 16)) {
                    break;
                }
                this.makeCoffee(250, 0, 16, 4);
            }
            case 2 -> {
                if (!hasIngredients(350, 75, 20)) {
                    break;
                }
                this.makeCoffee(350, 75, 20, 7);
            }
            case 3 -> {
                if (!hasIngredients(200, 100, 12)) {
                    break;
                }
                this.makeCoffee(200, 100, 12, 6);
            }
        }
    }

    private void makeCoffee(int water, int milk, int beans, int money) {
        this.water -= water;
        this.milk -= milk;
        this.beans -= beans;
        this.cups -= 1;
        this.money += money;
    }

    private boolean hasIngredients(int water, int milk, int beans) {
        String answer = "Sorry, not enough ";
        if (this.water < water) {
            answer += "water!";
        } else if (this.milk < milk) {
            answer += "milk!";
        } else if (this.beans < beans) {
            answer += "beans!";
        } else if (this.cups == 0) {
            answer += "cups!";
        } else {
            answer = "I have enough resources, making you a coffee!";
            System.out.println(answer);
            return true;
        }
        System.out.println(answer);
        return false;
    }

    protected void take() {
        System.out.printf("I gave you $%d%n", this.money);
        this.money = 0;
    }

    protected void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }
}
