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

import model.Task;

public class TaskHelper {
    static EntityManagerFactory tasksEMF = Persistence.createEntityManagerFactory("TasklistPlanner");
    
    public Task searchForTasksById(int id) {
        EntityManager tasksEM = tasksEMF.createEntityManager();
        tasksEM.getTransaction().begin();
        
        Task foundTask = tasksEM.find(Task.class, id);
        
        tasksEM.close();
        return foundTask;
    }
    
    public void insertTask(Task task) {
        EntityManager tasksEM = tasksEMF.createEntityManager();
        tasksEM.getTransaction().begin();
        
        tasksEM.persist(task);
        tasksEM.getTransaction().commit();
        tasksEM.close();
    }
    
    public void updateTask(Task task) {
        EntityManager tasksEM = tasksEMF.createEntityManager();
        tasksEM.getTransaction().begin();
        
        tasksEM.merge(task);
        tasksEM.getTransaction().commit();
        tasksEM.close();
    }
    
    public void deleteTask(Task task) {
        EntityManager tasksEM = tasksEMF.createEntityManager();
        tasksEM.getTransaction().begin();
        TypedQuery<Task> taskTypedQuery = tasksEM.createQuery("SELECT task FROM Task task WHERE task.id = :selectedId", Task.class);
        
        taskTypedQuery.setParameter("selectedId", task.getId());
        
        taskTypedQuery.setMaxResults(1);
        
        Task taskResult = taskTypedQuery.getSingleResult();
        
        tasksEM.remove(taskResult);
        tasksEM.getTransaction().commit();
        tasksEM.close();
    }
    
    public List<Task> showAllTasks() {
        EntityManager tasksEM = tasksEMF.createEntityManager();
        TypedQuery<Task> taskTypedQuery = tasksEM.createQuery("SELECT task FROM Task task", Task.class);
        
        List<Task> tasks = taskTypedQuery.getResultList();
        
        tasksEM.close();
        return tasks;
    }
    
    public void cleanUp() {
        tasksEMF.close();
    }
}
