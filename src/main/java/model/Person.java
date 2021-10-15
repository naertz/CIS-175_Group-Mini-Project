/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Oct 15, 2021
 */

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
    // Instance Variable(s) =====
    @Id
    @GeneratedValue
    private int id;       // Id
    private String name;  // Name
    // ==========================
    
    // Constructor(s) ==================
    // Default
    public Person() {
        super();
    }
    
    // Name
    public Person(String name) {
        super();
        this.name = name;
    }
    
    // Main
    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    // =================================
    
    // Setter(s) =====================
    // Id
    public void setId(int id) {
        this.id = id;
    }
    
    // Name
    public void setName(String name) {
        this.name = name;
    }
    // ===============================
    
    // Getter(s) ============
    // Id
    public int getId() {
        return id;
    }
    
    // Name
    public String getName() {
        return name;
    }
    // ======================
    
    // Method(s) ==========================================
    // toString Override
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
    // ====================================================
}
