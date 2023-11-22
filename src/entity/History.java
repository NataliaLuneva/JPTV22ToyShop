/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author user
 */
public class History implements Serializable{
    private Product product;
    private Buyer buyer;
    private Date sellProducttoBuyerDate;
    private Date returnProduct;
 public History() {
    }

    public History(Product product, Buyer buyer, Date sellProducttoBuyerDate, Date returnProduct) {
        this.product = product;
        this.buyer = buyer;
        this.sellProducttoBuyerDate = sellProducttoBuyerDate;
        this.returnProduct = returnProduct;
    }

    public Date getReturnProduct() {
        return returnProduct;
    }

    public void setReturnProduct(Date returnProduct) {
        this.returnProduct = returnProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getSellProductToBuyerDate() {
        return sellProducttoBuyerDate;
    }

    public void setSellProductToBuyerDate(Date sellProducttoBuyerDate) {
        this.sellProducttoBuyerDate = sellProducttoBuyerDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.product);
        hash = 17 * hash + Objects.hashCode(this.buyer);
        hash = 17 * hash + Objects.hashCode(this.sellProducttoBuyerDate);
        hash = 17 * hash + Objects.hashCode(this.returnProduct);
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
        final History other = (History) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.buyer, other.buyer)) {
            return false;
        }
        if (!Objects.equals(this.sellProducttoBuyerDate, other.sellProducttoBuyerDate)) {
            return false;
        }
        if (!Objects.equals(this.returnProduct, other.returnProduct)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "History " 
                + "Product " + product.getTitle()
                + ", Buyer" + buyer.getFirstname()
                + " " + buyer.getLastname()
                + ", Sold Product" + sellProducttoBuyerDate 
                + ", Return product " + returnProduct 
                + ' ';
    }
}  