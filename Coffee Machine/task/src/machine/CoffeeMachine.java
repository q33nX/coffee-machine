package machine;

import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker cf = new CoffeeMaker();

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = scanner.next();

            if (command.equals("exit")) {
                break;
            }

            cf.changeAction(command);
        }
    }
}
