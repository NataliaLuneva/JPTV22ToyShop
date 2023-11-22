package entity;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
/*
/**
 *
 * @author user
 */
public class Product implements Serializable{
    private String title;
    private Buyer[] buyers = new Buyer[0];
    private int quantity; //Всего закупленных в магазин экземпляров
    private int count; //экземпляров в наличии.
    private int price;
    public Product() {
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Arrays.deepHashCode(this.buyers);
        hash = 71 * hash + this.quantity;
        hash = 71 * hash + this.count;
        hash = 71 * hash + this.price;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Arrays.deepEquals(this.buyers, other.buyers)) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Buyer[] getBuyers() {
        return buyers;
    }

    public void setBuyers(Buyer[] buyers) {
        this.buyers = buyers;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" 
                + "title=" + title 
                + ", buyers=" + buyers 
                + ", quantity=" + quantity 
                + ", count=" + count 
                + ", price=" + price 
                + '}';
    }

    public void addBuyer(Buyer buyer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    