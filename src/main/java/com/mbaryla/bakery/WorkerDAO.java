/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbaryla.bakery;

import com.mbaryla.bakery.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mbaryla
 */
public class WorkerDAO {
    
    private final WorkerJpaController workerController;
    private final EntityManagerFactory emf;
    
    public WorkerDAO() {
        emf = Persistence.createEntityManagerFactory("com.mbaryla_bakery_jar_1.0-SNAPSHOTPU");
        workerController = new WorkerJpaController(emf);
    }
    
    public void addWorker(Worker worker) throws Exception{
        workerController.create(worker);
    }
    public void editWorker(Worker worker) throws Exception{
        workerController.edit(worker);
    }
    public void removeWorker(int workerId) throws NonexistentEntityException{
        workerController.destroy(workerId);
    }
    public List<Worker> getAllWorkers() {
        return workerController.findWorkerEntities();
    }
    public Worker getWorkerById(int workerId) {
        return workerController.findWorker(workerId);
    }
    
    
    
    
}
