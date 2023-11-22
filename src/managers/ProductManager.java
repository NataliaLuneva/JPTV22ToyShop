
package managers;

import entity.Buyer;
import entity.Product;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;


/**
 *
 * @author user
 */
public class ProductManager {

    private final Scanner scanner;

    public ProductManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Product addProduct() {
        System.out.println("----- Add new product -----");
        Product product = new Product();
        
        System.out.print("Enter title: ");
        product.setTitle(scanner.nextLine());
        

        System.out.print("How many toys: ");
        int countBuyers = InputFromKeyboard.inputNumberFromRange(1, 5);
        for (int i = 0; i < countBuyers; i++) {
            System.out.printf("Toy %d:%n", i + 1);
            System.out.print("Enter firstname: ");
            String buyerFirstname = scanner.nextLine();
        }

        System.out.print("Enter quantity copy: ");
        product.setQuantity(InputFromKeyboard.inputNumberFromRange(1, 10));

        System.out.print("Enter price: ");
        product.setPrice(InputFromKeyboard.inputNumberFromRange(1, 145));

        product.setCount(product.getQuantity());
        System.out.println("Added product: " + product.toString());
        return product;
    }  
public void updateProducts(List<Product> products) {
        int productIndex = selectProductIndex(products);
        if (productIndex != -1) {
            Product productToUpdate = products.get(productIndex);

            System.out.println("Enter new data for the product:");
            System.out.print("Title: ");
            productToUpdate.setTitle(scanner.nextLine());
            System.out.print("Published Price: ");

            System.out.print("Buyers (separate authors with comma): ");
            String buyersInput = scanner.nextLine();
            String[] buyersArray = buyersInput.split(","); 
            
            Buyer[] buyers = new Buyer[buyersArray.length]; 
            for (int i = 0; i < buyersArray.length; i++) {
                String[] buyersNames = buyersArray[i].trim().split(" ");
                if (buyersNames.length == 2) {
                } else {
                    System.out.println("Invalid author format for: " + buyersArray[i]);
                }
            }

            productToUpdate.setBuyers(buyers);
            
            System.out.print("Quantity: ");
            productToUpdate.setQuantity(InputFromKeyboard.inputNumberFromRange(1, 10));

            System.out.print("Price: ");
            productToUpdate.setPrice(InputFromKeyboard.inputNumberFromRange(1, 145));

            productToUpdate.setCount(productToUpdate.getQuantity());

            System.out.println("Product data updated successfully:");
            System.out.println(productToUpdate.toString());
        } else {
            System.out.println("Product not found.");
        }
    }


    private int selectProductIndex(List<Product> products) {
        int count = printListProducts(products);
        if (count > 0) {
            System.out.print("Enter the number of the product to update: ");
            int productNumber = scanner.nextInt();
            scanner.nextLine(); // очистить буфер

            if (productNumber >= 1 && productNumber <= count) {
                return productNumber - 1;
            }
        }
        return -1;
    }

    public int printListProducts(List<Product> products) {
        int count = 0;
        System.out.println("List products: ");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s. %d. %s. In stock: %d.  Price: %d%n",
                    i + 1,
                    products.get(i).getTitle(),
                    products.get(i).getCount(),
                    products.get(i).getPrice()
            );
            count++;
        }
        return count;
    }
}