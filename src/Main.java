import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Cinema cinema = new Cinema();

        System.out.println("Enter the number of rows:");
        cinema.setNumberOfRows(keyboard.nextInt());
        System.out.println("Enter the number of seats in each row");
        cinema.setNumberOfColumns(keyboard.nextInt());
        cinema.createCinemaRoom();

        int userChoice = 0;
        while (userChoice <= 3 && userChoice >= 0) {
            printMenuOptions();
            userChoice = keyboard.nextInt();

            switch (userChoice) {
                case 0:
                    return;
                case 1:
                    cinema.printCinemaRoom();
                    break;
                case 2:
                    cinema.buyTicket();
                    break;
                case 3:
                    cinema.showStatistics();
                    break;
            }
        }
    }

    private static void printMenuOptions() {

        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
}