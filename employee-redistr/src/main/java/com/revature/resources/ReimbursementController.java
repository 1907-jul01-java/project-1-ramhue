package com.revature.resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.revature.util.ConnectionUtil;
import com.revature.domain.Reimbursement;
import com.revature.domain.ReimbursementService;
import com.revature.entities.ReimbursementDao;

/**
 * ReimbursementController
 * 
 */
@Path(value ="reimbursements")
public class ReimbursementController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reimbursement> getAllReimbursementsJSON() {
		List<Reimbursement> reimbursements = null;

		try (Connection connection = new ConnectionUtil().getConnection()) {
			ReimbursementDao dao = new ReimbursementDao(connection);
			ReimbursementService service = new ReimbursementService(dao);
			reimbursements = service.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public void insertReimbursement(@FormParam("id") String id, @FormParam("type") String type, @FormParam("amount") int ammount,
			@FormParam("aproval")  String aproval, @FormParam ("username") String uname, @Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			ReimbursementDao dao = new ReimbursementDao(connection);
			ReimbursementService service = new ReimbursementService(dao);
			service.insert(new Reimbursement(0, type, ammount, aproval, uname));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/employee-redistr/index2.html");
	}
}