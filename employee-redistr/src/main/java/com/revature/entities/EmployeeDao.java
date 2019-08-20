package com.revature.entities;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import com.revature.domain.Employee;

/**
 * EmployeeDao
 */
public class EmployeeDao implements Dao<Employee> {

    Connection connection;

    public EmployeeDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Employee> getAll() {
        String q = "SELECT * FROM employee";
        Employee employee;
        List<Employee> employees = new ArrayList<Employee>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(q); 
            while(results.next()){
                employee = new Employee();
                employee.setFname(results.getString("fname"));
                employee.setLname(results.getString("lname"));
                employee.setPassword(results.getString("password"));
                employee.setUserName(results.getString("username"));
                employee.setEmail(results.getString("email"));
                employee.setId(results.getInt("id"));
                employee.setIsAdmin(results.getBoolean("isAdmin"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public boolean Authenticator(String uname, String password){
        boolean valid = false;
        try {
            PreparedStatement preStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
                preStatement.setString(1, uname);
                preStatement.setString(2,password);
                ResultSet results = preStatement.executeQuery();
    
                valid = results.next();
            } catch (SQLException e) {
                //TODO: handle exception
            }
            return valid;
        }
    @Override
    public void insert(Employee employee) {
        PreparedStatement preStatement;
        try {
            preStatement = connection.prepareStatement("INSERT INTO employee(userName, password, fname, lname, isAdmin, email ) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preStatement.setString(1, employee.getUserName());
            preStatement.setString(2, employee.getPassword());
            preStatement.setString(3, employee.getFname());
            preStatement.setString(4, employee.getLname());
            preStatement.setBoolean(5, employee.getIsAdmin());
            preStatement.setString(6, employee.getEmail());
            preStatement.executeUpdate();
            ResultSet addUserResults = preStatement.getGeneratedKeys();
            if(addUserResults.next())
                employee.setId(addUserResults.getInt(1));
        }catch(SQLException e){
            System.err.println("Something went wrong and could not insert employee");

        }
    }

    public Employee getEmployeeByUsername(String username){
        Employee employee = null;
        try {
            PreparedStatement pState = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            pState.setString(1, username);
            ResultSet results = pState.executeQuery();
            while(results.next()){
                String uname = results.getString("username");
                String password = results.getString("password");
                String fname = results.getString("fname");
                String lname = results.getString("lname");
                boolean isAdmin = results.getBoolean("isadmin");
                int id = results.getInt("id");
                String email = results.getString("email");
                employee = new Employee(id, uname, password, fname, lname, isAdmin, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return employee;
    }
    @Override
    public void update(int id, String status) {

    }

    @Override
    public void delete() {

    }

    @Override
    public List<Employee> getByEmployee(String e) {
        return null;
    }
/*
    public List<Reimbursement> getReimbursementsByEmployee(String name){
        try {
            PreparedStatement pState = connection.prepareStatement("SELECT * FROM reimbursement WHERE username = ?");
            pState.setString(1, name);
            ResultSet results = pState.executeQuery();
            while(results.next()){
                String uname = results.getString("username");
                String password = results.getString("password");
                String fname = results.getString("fname");
                String lname = results.getString("lname");
                boolean isAdmin = results.getBoolean("isadmin");
                int id = results.getInt("id");
                String email = results.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return employee;
    }*/
        
   // }


    
    
}