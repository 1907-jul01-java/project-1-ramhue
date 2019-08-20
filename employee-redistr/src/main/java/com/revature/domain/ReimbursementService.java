package com.revature.domain;

import java.util.List;

import com.revature.entities.Dao;

/**
 * ReimbursementService
 */
public class ReimbursementService implements Service<Reimbursement> {
    private Dao<Reimbursement> dao;

    public ReimbursementService(Dao<Reimbursement> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Reimbursement reimbursement) {
        this.dao.insert(reimbursement);
    }

    @Override
    public List<Reimbursement> getAll() {
        return dao.getAll();
    }

    public List<Reimbursement> getByUsername(String name){
        return dao.getByEmployee(name);
    }
    
    @Override
    public void update(int id, String status ) {
        this.dao.update(id, status);
    }

    @Override
    public void delete() {
		
    }

}