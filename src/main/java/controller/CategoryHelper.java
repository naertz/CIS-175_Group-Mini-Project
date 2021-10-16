/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Oct 15, 2021
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Category;

public class CategoryHelper {
    private static EntityManagerFactory categoriesEMF = Persistence.createEntityManagerFactory("TasklistPlanner");
    
    public Category searchForCategoriesById(int id) {
        EntityManager categoriesEM = categoriesEMF.createEntityManager();
        categoriesEM.getTransaction().begin();
        
        Category foundCategory = categoriesEM.find(Category.class, id);
        
        categoriesEM.close();
        return foundCategory;
    }
    
    public void insertNewCategory(Category category) {
        EntityManager categoriesEM = categoriesEMF.createEntityManager();
        categoriesEM.getTransaction().begin();
        
        categoriesEM.persist(category);
        categoriesEM.getTransaction().commit();
        categoriesEM.close();
    }
    
    public void updateCategory(Category category) {
        EntityManager categoriesEM = categoriesEMF.createEntityManager();
        categoriesEM.getTransaction().begin();
        
        categoriesEM.merge(category);
        categoriesEM.getTransaction().commit();
        categoriesEM.close();
    }
    
    public List<Category> getCategories() {
        EntityManager categoriesEM = categoriesEMF.createEntityManager();
        TypedQuery<Category> categoryTypedQuery = categoriesEM.createQuery("SELECT category FROM Category category", Category.class);
        
        List<Category> categories = categoryTypedQuery.getResultList();
        
        categoriesEM.close();
        return categories;
    }
    
    public void deleteCategory(Category category) {
        EntityManager categoriesEM = categoriesEMF.createEntityManager();
        categoriesEM.getTransaction().begin();
        
        TypedQuery<Category> categoryTypedQuery = categoriesEM.createQuery("SELECT category FROM Category category WHERE category.id = :selectedId", Category.class);
        
        categoryTypedQuery.setParameter("selectedId", category.getId());
        
        categoryTypedQuery.setMaxResults(1);
        
        Category categoryResult = categoryTypedQuery.getSingleResult();
        
        categoriesEM.remove(categoryResult);
        categoriesEM.getTransaction().commit();
        categoriesEM.close();
    }
}
