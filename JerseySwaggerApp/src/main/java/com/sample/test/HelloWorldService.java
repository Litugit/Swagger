package com.sample.test;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


// http://localhost:8080/JerseySwaggerApp/rest/api-docs
// http://localhost:8080/JerseySwaggerApp/rest/hello/etr
// http://localhost:8080/JerseySwaggerApp/
// google it for 406-Not Acceptable Response” in HTTP in swagger ui when MediaType.APPLICATION_XML

@Path("/hello")
@Api(value="hello", description="Sample hello world application")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	@ApiOperation(value="just to test the sample api")
	public Response getMsg(@ApiParam(value="param",required=true)@PathParam("param") String msg ) {
 
		String output = "Hello : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="All Employee api")
	public Employees getAllEmployees() {
		Employees list = new Employees();
		list.setEmployeeList(new ArrayList<Employee>());

		list.getEmployeeList().add(new Employee(1, "Lokesh Gupta"));
		list.getEmployeeList().add(new Employee(2, "Alex Kolenchiskey"));
		list.getEmployeeList().add(new Employee(3, "David Kameron"));

		return list;
	}
	
}
