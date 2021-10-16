/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Oct 15, 2021
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Person;

public class PersonHelper {
    private static EntityManagerFactory personsEMF = Persistence.createEntityManagerFactory("TasklistPlanner");
    
    public Person findPerson(String name) {
        EntityManager personsEM = personsEMF.createEntityManager();
        personsEM.getTransaction().begin();
        TypedQuery<Person> personTypedQuery = personsEM.createQuery("SELECT person FROM Person person WHERE person.name = :selectedName", Person.class);
        
        personTypedQuery.setParameter("selectedName", name);
        
        personTypedQuery.setMaxResults(1);
        
        Person foundPerson;
        
        try {
            foundPerson = personTypedQuery.getSingleResult();
        } catch (NoResultException error) {
            foundPerson = new Person(name);
        }
        
        personsEM.close();
        return foundPerson;
    }
    
    public void insertPerson(Person person) {
        EntityManager personsEM = personsEMF.createEntityManager();
        personsEM.getTransaction().begin();
        
        personsEM.persist(person);
        personsEM.getTransaction().commit();
        personsEM.close();
    }
    
    public List<Person> showAllPersons() {
        EntityManager personsEM = personsEMF.createEntityManager();
        TypedQuery<Person> personTypedQuery = personsEM.createQuery("SELECT person FROM Person person", Person.class);
        
        List<Person> persons = personTypedQuery.getResultList();
        
        personsEM.close();
        return persons;
    }
}
