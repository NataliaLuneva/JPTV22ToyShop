/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enttity;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author user
 */
public class Author implements Serializable{
    
    private String firstname;

    public Author() {
    }

    public Author(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.firstname);
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" 
                + "firstname=" + firstname 
                + '}';
    }
}