package com.mypack.service;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.mypack.dao.EmployeeDao;
import com.mypack.model.Employee;

@Path("/test")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeService {

	EmployeeDao empDao = new EmployeeDao();

	@POST
	public Response addEmployee(Employee e,@Context UriInfo uriInfo) throws ClassNotFoundException, SQLException  {
		 Employee emp =empDao.insertEmployee(e);
		 String newId = String.valueOf(emp.getId());
		 URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
			return Response.created(uri)
					.entity(emp)
					.build();
	}
	
	@GET
	public List<Employee> getAllEMP() throws ClassNotFoundException, SQLException {
		return empDao.getAllEmployee();
	}

	@DELETE
	@Path("/{id}")
	public String deleteEmployee(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		return empDao.deleteEmployee(id);
		
	}
	@GET
	@Path("/{id}")
	public Employee getEmpbyId(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		return empDao.getEmployeeById(id);
	}
	
	@PUT
	public Employee updateEmployee(Employee e) throws ClassNotFoundException, SQLException {
		return empDao.updateEmployee(e);
	}
	
}
