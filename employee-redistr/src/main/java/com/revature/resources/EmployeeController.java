package com.revature.resources;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// import com.revature.entities.EmployeeDao;
import com.revature.domain.Employee;

@Path("employee")
public class EmployeeController{
    public static List<Employee> ListOfEmp;
    public EmployeeController(){
        //EmployeeDao edao = new EmployeeDao();
        //ListOfEmp = edao.getAll();

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployeesJSON(){
        return ListOfEmp;
    }
    @GET  
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeById(@PathParam("id") int id){
        return ListOfEmp.get(id-1);
    }
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeByName(@QueryParam ("username") String username){
        for(Employee E:ListOfEmp){
            if (E.getUserName().equalsIgnoreCase(username)){
                return E;
            }
        }
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee postEmployee(Employee employee){
        return employee;
    }
}
