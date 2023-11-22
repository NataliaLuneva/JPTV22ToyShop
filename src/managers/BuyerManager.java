/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;
import entity.Buyer;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;
/**
 *
 * @author user
 */
public class BuyerManager {

    private final Scanner scanner;

    public BuyerManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Buyer addBuyer() {
        Buyer buyer;
        buyer = new Buyer();
        System.out.println(" ----- Add new buyer -----");
        System.out.print("Firstname: ");
        buyer.setFirstname(scanner.nextLine());
        System.out.print("Lastname: ");
        buyer.setLastname(scanner.nextLine());
        System.out.print("Phone: ");
        buyer.setPhone(scanner.nextLine());
        System.out.print("Initial Balance: ");
        int initialBalance = scanner.nextInt();
        buyer.setBalance(initialBalance);
        System.out.println("Added buyer " + buyer.toString());
        return buyer;
    }

    public void viewBalance(Buyer buyer) {
        System.out.println("Buyer Balance:");
        System.out.println(buyer.toString());
    }

public void replenishBalance(Buyer buyer) {
    System.out.print("Enter the amount to replenish: ");
    int replenishAmount = InputFromKeyboard.inputNumberFromRange(1, Integer.MAX_VALUE);
    
    int currentBalance = buyer.getBalance();
    int newBalance = currentBalance + replenishAmount;
    buyer.setBalance(newBalance);

    System.out.println("Balance replenished successfully.");
    System.out.println("New balance for " + buyer.getFirstname() + ": " + newBalance);
}
    public int printListBuyers(List<Buyer> buyer) {
        
    int count = 0;
        System.out.println("List buyers: ");
        for (int i = 0; i < buyer.size(); i++) {
            System.out.printf("%d. %s %s - Phone: %s, Balance: %d%n",
                    i + 1,
                    buyer.get(i).getFirstname(),
                    buyer.get(i).getLastname(),
                    buyer.get(i).getPhone(),
                    buyer.get(i).getBalance()
            );
            count++;
        }
        return count;
    
        }
 public void deductBalanceForProduct(Buyer buyer, int productPrice) {
        if (buyer.getBalance() >= productPrice) {
            int newBalance = buyer.getBalance() - productPrice;
            buyer.setBalance(newBalance);
            System.out.println("Price deducted successfully.");
            System.out.println("New balance for " + buyer.getFirstname() 
                    + ": " + newBalance);
        } else {
            System.out.println("Insufficient funds. Unable to deduct price.");
        }
    }
 
    private int selectBuyerIndex(List<Buyer> buyers) {
        int count = printListBuyers(buyers);
        if (count > 0) {
            System.out.print("Enter the number of the buyer to update: ");
            int buyerNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            if (buyerNumber >= 1 && buyerNumber <= count) {
                return buyerNumber - 1; // adjusting index for the selected customer
            }
        }
        return -1; // customer not found or invalid input
    }

    public void updateBuyers(List<Buyer> buyers) {
        int buyerIndex = selectBuyerIndex(buyers);
        if (buyerIndex != -1) {
            Buyer buyerToUpdate = buyers.get(buyerIndex);

            System.out.println("Enter new data for the buyers:");
            System.out.print("Firstname: ");
            buyerToUpdate.setFirstname(scanner.nextLine());
            System.out.print("Lastname: ");
            buyerToUpdate.setLastname(scanner.nextLine());
            System.out.print("Phone: ");
            buyerToUpdate.setPhone(scanner.nextLine());
            System.out.print("Initial Balance: ");
            int initialBalance = scanner.nextInt();
            buyerToUpdate.setBalance(initialBalance);

            System.out.println("Buyer data updated successfully:");
            System.out.println(buyerToUpdate.toString());
        } else {
            System.out.println("Buyer not found.");
        }
    }
}