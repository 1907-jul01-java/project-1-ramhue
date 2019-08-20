package com.revature.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;

/**
 * ReimbursementDao
 */
public class ReimbursementDao implements Dao<Reimbursement> {
    Connection connection;
    
    public ReimbursementDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Reimbursement reimbursement) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into reimbursement(type, amount, aproval, employeuname) values(?, ?, ?, ?)");
            pStatement.setString(1, reimbursement.getType());
            pStatement.setFloat(2, reimbursement.getAmount());
            pStatement.setString(3, reimbursement.getAproval());
            pStatement.setString(4, reimbursement.getEmployeuname());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Reimbursement> getAll() {
        Reimbursement reimbursement;
        List<Reimbursement> reimbursements = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from reimbursement");
            while (resultSet.next()) { 
                reimbursement = new Reimbursement();
                reimbursement.setId(resultSet.getInt("id"));
                reimbursement.setType(resultSet.getString("type"));
                reimbursement.setAmount(resultSet.getFloat("amount"));
                reimbursement.setAproval(resultSet.getString("aproval"));
                reimbursement.setEmployeuname(resultSet.getString("employeuname"));
                reimbursements.add(reimbursement);
            }
        } catch (SQLException e) {

        }
        return reimbursements;
    }
    @Override
    public List<Reimbursement> getByEmployee(String uname) {
        Reimbursement reimbursement;
        List<Reimbursement> reimbursements = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from reimbursement WHERE employename = ? ");
            statement.setString(1, uname);
            ResultSet resultSet =statement.executeQuery();
            if (resultSet.next()) { 
                reimbursement = new Reimbursement();
                reimbursement.setId(resultSet.getInt("id"));
                reimbursement.setType(resultSet.getString("type"));
                reimbursement.setAmount(resultSet.getFloat("amount"));
                reimbursement.setAproval(resultSet.getString("aproval"));
                reimbursement.setEmployeuname(resultSet.getString("employeuname"));
                reimbursements.add(reimbursement);
            }
        } catch (SQLException e) {

        }
        return reimbursements;
    }

    @Override
    public void update(int id, String status) {
        PreparedStatement pState;
        try {
            pState = connection.prepareStatement("UPDATE reimbursement SET aproval = ? WHERE id = ?");
            pState.setString(1,"status");
            pState.setInt(2, id);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {

    }
}