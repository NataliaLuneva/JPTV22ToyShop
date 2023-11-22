/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv22toyshop;

import managers.BuyerManager;
import managers.HistoryManager;
import managers.ProductManager;
import managers.SaveManager;
import entity.Buyer;
import entity.History;
import entity.Product;
import java.util.List;
import java.util.Scanner;
import managers.BuyerManager;
import managers.HistoryManager;
import managers.ProductManager;
import managers.SaveManager;
import tools.InputFromKeyboard;

public class App {
    private final Scanner scanner;
    private  List<Product> products;
    private  List <Buyer> buyers;
    private  List<History> histories;
    private  ProductManager productManager;
    private  BuyerManager buyerManager;
    private  HistoryManager historyManager;
    private  SaveManager saveManager;

    public App() {
        this.scanner = new Scanner(System.in);
        this.saveManager = new SaveManager();
        this.products = saveManager.loadProducts();
        this.histories = saveManager.loadHistories();
        this.buyers = saveManager.loadBuyers();
        this.productManager = new ProductManager(scanner);
        this.buyerManager = new BuyerManager(scanner);
        this.historyManager = new HistoryManager(scanner);
    }

    public void run() {
        boolean repeat = true;
        System.out.println("------ Welcome to Toy Shop -------");
        do {
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add Product");
            System.out.println("2. Add Buyers");
            System.out.println("3. Print list products");
            System.out.println("4. Print list buyers");
            System.out.println("5. Sell product to buyers");
            System.out.println("6. Print selling products");
            System.out.println("7. Ranking of products being sold");
            System.out.println("8. Top up balance");
            System.out.println("9. Store rating");
            System.out.print("Enter number task: ");
            int task = InputFromKeyboard.inputNumberFromRange(0, 10);
            System.out.printf("Selected task %d, continue? (y/n): ", task);
            String continueRun = InputFromKeyboard.inputSymbolYesOrNo();
            if (continueRun.equals("n")) {
                continue;
            }
            switch (task) {
                case 0:
                    repeat = false;
                    System.out.println("Bye!");
                    break;
                case 1:
                    products.add(productManager.addProduct());
                    saveManager.saveProducts(this.products);//save to file
                    break;
                case 2:
                    buyers.add(buyerManager.addBuyer());
                    saveManager.saveBuyers(buyers);
                    break;
                case 3:
                    productManager.printListProducts(products);
                    boolean updateProducts = InputFromKeyboard.askForProductUpdate();
                    if (updateProducts) {
                        productManager.updateProducts(products);
                        saveManager.saveProducts(products);
                    }
                    break;
                case 4:
                    buyerManager.printListBuyers(buyers);
                    boolean updateBuyers = InputFromKeyboard.askForBuyerUpdate();
                    if (updateBuyers) {
                        buyerManager.updateBuyers(buyers);
                        saveManager.saveBuyers(buyers);
                    }
                    break;
                case 5:
                    History history = historyManager.sellProductToBuyer(buyers, products);
                    if (history != null) {
                        this.histories.add(history);
                        saveManager.saveHistories(histories);
                        buyerManager.deductBalanceForProduct(history.getBuyer(), history.getProduct().getPrice());
                        saveManager.saveBuyers(buyers);
                    }
                    break;
                case 6:
                    historyManager.printListSoldProduct(histories);
                    break;
                case 7:
                    historyManager.printRankingOfProductsBeingSold(this.histories);
                    break;
                case 8:
                    buyerManager.printListBuyers(buyers);
                    System.out.print("Enter the number of the buyer to replenish balance: ");
                    int buyerNumber = InputFromKeyboard.inputNumberFromRange(1, buyers.size());
                    Buyer selectedBuyer = buyers.get(buyerNumber - 1);
                    buyerManager.replenishBalance(selectedBuyer);
                    saveManager.saveBuyers(buyers);
                    break;
                case 9:
                    historyManager.calculateTotalSales(histories);
                    break;
                default:
                    System.out.println("Select number from list tasks!");
            }
            System.out.println("-------------------------");
        } while (repeat);
    }
}