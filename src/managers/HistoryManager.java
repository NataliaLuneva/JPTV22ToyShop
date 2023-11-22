/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;
import entity.Product;
import entity.History;
import entity.Buyer;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import tools.InputFromKeyboard;


public class HistoryManager {

    private final Scanner scanner;
    private final BuyerManager buyerManager;
    private final ProductManager productManager;

    public HistoryManager(Scanner scanner) {
        this.scanner = scanner;
        this.buyerManager = new BuyerManager(scanner);
        this.productManager = new ProductManager(scanner);
    }

    public History sellProductToBuyer(List<Buyer>buyers, List<Product> products) {
        System.out.println("------------- Sell the Product to Buyer ----------------");
        History history = new History();

        int countBuyersInList = buyerManager.printListBuyers(buyers);
        System.out.print("Enter number buyer: ");
        int readerNumber = InputFromKeyboard.inputNumberFromRange(1, 
                countBuyersInList);
        history.setBuyer(buyers.get(readerNumber - 1));

        int countProductsInList = productManager.printListProducts(products);
        System.out.print("Enter number product: ");
        int bookNumber = InputFromKeyboard.inputNumberFromRange(1, 
                countProductsInList);
        if (products.get(bookNumber - 1).getCount() > 0) {
            history.setProduct(products.get(bookNumber - 1));
            products.get(bookNumber - 1).setCount(products.get
        (bookNumber - 1).getCount() - 1);
            history.setSellProductToBuyerDate(new 
        GregorianCalendar().getTime());
            return history;
        } else {
            System.out.println("All products are sold ");
            return null;
        }
    }


    public int printListSoldProduct(List<History> histories) {
        int countSoldProduct = 0;
        System.out.println("List selling products:");

        for (int i = 0; i < histories.size(); i++) {
            if (histories.get(i).getReturnProduct() == null) {
                System.out.printf("%d. %s. selling %s %s%n",
                        i + 1,
                        histories.get(i).getProduct().getTitle(),
                        histories.get(i).getBuyer().getFirstname(),
                        histories.get(i).getBuyer().getLastname()
                );
                countSoldProduct++;
            }
        }

        if (countSoldProduct < 1) {
            System.out.println("\tNo products to sell");
        }

        return countSoldProduct;
    }

    public void printRankingOfProductsBeingSold(List<History> histories) {
        Map<Product, Integer> mapProducts = new HashMap<>();
        for (int i = 0; i < histories.size(); i++) {
            Product product = histories.get(i).getProduct();
            if (mapProducts.containsKey(product)) {
                mapProducts.put(product, mapProducts.get(product) + 1);
            } else {
                mapProducts.put(product, 1);
            }
        }

        Map<Product, Integer> sortedMap = mapProducts.entrySet()
                .stream()
                .sorted(Map.Entry.<Product, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

           System.out.println("Ranking of products being sold:");
    int n = 1;
    for (Map.Entry<Product, Integer> entry : sortedMap.entrySet()) {
        System.out.printf("%d. %s - %d times%n",
                n++, entry.getKey().getTitle(), entry.getValue());
    }
}
  
    public void calculateTotalSales(List<History> histories) {
       int totalSalesAmount = 0;
        int totalSoldProducts = 0;

        for (History history : histories) {
            if (history.getReturnProduct() == null) {
                totalSalesAmount += history.getProduct().getPrice();
                totalSoldProducts++;
            }
        }

        System.out.println("Total sales amount: " + totalSalesAmount);
        System.out.println("Total sold products: " + totalSoldProducts);
    }
 
    }