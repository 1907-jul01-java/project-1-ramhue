package com.revature.Servlets;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import com.revature.domain.Employee;
import com.revature.entities.EmployeeDao;
import com.revature.util.ConnectionUtil;  
public class LoginServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
          
        if(LoginAuthenticate(name, password)){
            Employee employee = retrieveEmployeeByUserName(name);  
            out.print("Welcome, "+ employee.getFname() + " " + employee.getLname());  
            HttpSession session=request.getSession();  
            session.setAttribute("username",name);
              
        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }
    public Employee retrieveEmployeeByUserName(String username) {
        ConnectionUtil connection = new ConnectionUtil();
        EmployeeDao employeeDao = new EmployeeDao(connection.getConnection());
        Employee employee = employeeDao.getEmployeeByUsername(username);
        connection.close();
        return employee;
    }

    public boolean LoginAuthenticate(String uname, String password){
        ConnectionUtil connection = new ConnectionUtil();
        EmployeeDao employeeDao = new EmployeeDao(connection.getConnection());
        boolean isValid = employeeDao.Authenticator(uname, password); 
        return isValid;
    }
}  