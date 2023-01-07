import java.util.Scanner;

public class Cinema {

    private String[][] cinemaRoom;
    private int numberOfRows;
    private int numberOfColumns;
    private int totalNumberOfSeats;
    private static int purchasedTicketsCount;

    private static int currentIncome;

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public void printCinemaRoom() {
        System.out.println("Cinema:");
        System.out.print("  ");

        for(int i = 0; i < numberOfColumns; i ++)
        {
            System.out.print(i + 1 + " ");
        }

        System.out.println();

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns + 1; j++) {
                System.out.print(cinemaRoom[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void createCinemaRoom() {
        cinemaRoom = new String[numberOfRows][numberOfColumns + 1];
        totalNumberOfSeats = numberOfRows * numberOfColumns;

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns + 1; j++) {
                if (j == 0) {
                    cinemaRoom[i][j] = Integer.toString(i + 1);
                } else {
                    cinemaRoom[i][j] = "S";
                }
            }
        }
    }

    public int getTicketPrice(int rowNumber) {
        int ticketPrice;
        if (totalNumberOfSeats < 60) {
            ticketPrice = 10;
        } else {
            int frontHalf = numberOfRows / 2;

            if (rowNumber <= frontHalf){
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        return ticketPrice;
    }

    public void buyTicket() {
        Scanner keyboard = new Scanner(System.in);
        int rowNumber;
        int seatNumber;

        while (true) {
            System.out.println("Enter a row number:");
            rowNumber = keyboard.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = keyboard.nextInt();

            if (rowNumber > numberOfRows || rowNumber < 1 || seatNumber > numberOfColumns || seatNumber < 1) {
                System.out.println("Wrong input!");
                continue;
            }

            if (cinemaRoom[rowNumber - 1][seatNumber] == "B") {
                System.out.println("That ticket has already been purchased!");
            } else {
                int ticketPrice = getTicketPrice(rowNumber);
                System.out.println("Ticket price: $" + ticketPrice);
                cinemaRoom[rowNumber - 1][seatNumber] = "B";
                currentIncome += ticketPrice;
                purchasedTicketsCount++;
                break;
            }
        }
    }

    public int getTotalIncome()
    {
        int ticketPrice;
        int totalIncome;
        if (totalNumberOfSeats < 60) {
            ticketPrice = 10;
            totalIncome = ticketPrice * totalNumberOfSeats;
        } else {
            int frontHalf = numberOfRows / 2;
            int backHalf;

            if (numberOfRows % 2 == 0) {
                backHalf = numberOfRows / 2;
            } else {
                backHalf = numberOfRows / 2 + 1;
            }

            totalIncome = frontHalf * numberOfColumns * 10 + backHalf * numberOfColumns * 8;
        }
        return totalIncome;
    }

    public void showStatistics()
    {
        double numberOfPurchasedTickets = (double) purchasedTicketsCount / totalNumberOfSeats * 100;
        System.out.println("Number of purchased tickets: " + purchasedTicketsCount);
        System.out.printf("Percentage: %.2f%% \n", numberOfPurchasedTickets);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + getTotalIncome());
    }
}
