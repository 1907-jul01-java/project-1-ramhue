package com.revature.domain;



/**
 * Employee
 * 
 */
public class Employee{
    int id;
    String username;
    String password;
    String fname;
    String lname;
    Boolean isAdmin;
    String email;
    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  

   /* public List<Reimbursements> getMyReimbursements() {
        return myReimbursements;
    }

    public void setMyReimbursements(List<Reimbursements> myReimbursements) {
        this.myReimbursements = myReimbursements;
    }
*/
    public Employee(int id, String username, String password, String fname, String lname, Boolean isAdmin, String email
    ){    
        //List<Reimbursements> myReimbursements) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.isAdmin = isAdmin;
        this.email = email;
        //this.myReimbursements = myReimbursements;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "email=" + email +"\r\n"+"First Name=" + fname + "\r\n id=" + id + "\r\n isAdmin=" + isAdmin + "\r\n Last name="
                + lname + "\r\n username=" + username;
    }
    
}