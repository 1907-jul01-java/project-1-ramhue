package com.revature.resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.revature.util.ConnectionUtil;
import com.revature.domain.ReimbursementService;
import com.revature.entities.ReimbursementDao;

@Path(value ="em/StatusController")
public class StatusController{
    @POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public void UpdatesReimbursement(@FormParam("id") int id, @FormParam("status") String status, @Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			ReimbursementDao dao = new ReimbursementDao(connection);
			ReimbursementService service = new ReimbursementService(dao);
            service.update(id, status );
		} catch (SQLException e) {
			e.printStackTrace();
        }
    
    }
}