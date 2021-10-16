/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Oct 15, 2021
 */

package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
    // Instance Variable(s) ====================================
    @Id
    @GeneratedValue
    private int id;            // Id
    private String name;       // Name
    @OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    private List<Task> tasks;  // Tasklist
    // =========================================================
    
    // Constructor(s) ==============================
    // Default
    public Category() {
        super();
    }
    
    // Name, Tasklist
    public Category(String name, List<Task> tasks) {
        super();
        this.name = name;
        this.tasks = tasks;
    }
    // =============================================
    
    // Setter(s) ===========================
    // Id
    public void setId(int id) {
        this.id = id;
    }
    
    // Name
    public void setName(String name) {
        this.name = name;
    }
    
    // Tasklist
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    // =====================================
    
    // Getter(s) =================
    // Id
    public int getId() {
        return id;
    }
    
    // Name
    public String getName() {
        return name;
    }
    
    // Tasklist
    public List<Task> getTasks() {
        return tasks;
    }
    // ===========================
    
    // Method(s) =================================================================
    // toString Override
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
    }
    // ===========================================================================
}
