/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Oct 15, 2021
 */

package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
    // Instance Variable(s) ===========================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;             // Id
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Person person;      // Person
    @Column(name="NAME")
    private String name;        // Name
    @Column(name="DUE_DATE")
    private LocalDate dueDate;  // Due Date
    // ================================================
    
    // Constructor(s) ==========================================
    // Default
    public Task() {
        super();
    }
    
    // Person, Name, Due Date
    public Task(Person person, String name, LocalDate dueDate) {
        super();
        this.person = person;
        this.name = name;
        this.dueDate = dueDate;
    }
    // =========================================================
    
    // Setter(s) ==============================
    // ID
    public void setId(int id) {
        this.id = id;
    }
    
    // Person
    public void setPerson(Person person) {
        this.person = person;
    }
    
    // Name
    public void setName(String name) {
        this.name = name;
    }
    
    // Due Date
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    // ========================================
    
    // Getter(s) ==================
    // ID
    public int getId() {
        return id;
    }
    
    // Person
    public Person getPerson() {
        return person;
    }
    
    // Name
    public String getName() {
        return name;
    }
    
    // Due Date
    public LocalDate getDueDate() {
        return dueDate;
    }
    // ============================
    
    // Method(s) ========================================================================================
    // toString Override
    @Override
    public String toString() {
        return "Task [id=" + id + ", person=" + person + ", name=" + name + ", dueDate=" + dueDate + "]";
    }
    // ==================================================================================================
}
