package com.worm.service.rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

import com.worm.core.db.DbHelper;
import com.worm.da.TeamDa;

@Path("/example-service")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleService {
	
	
	@Context
	ServletContext context;
	
	
	
	@GET
	@Path("home")
	public Response hello() {
		JSONObject jsonObj = new JSONObject();
		TeamDa td = new TeamDa(DbHelper.getSessionFactory(context));
		List<Object[]> teams = td.getAll();
		for (Object[] object : teams) {
			jsonObj.put("Team Name", String.valueOf(object[1]));
			jsonObj.put("Home", String.valueOf(object[3]));
			jsonObj.put("Rule", String.valueOf(object[4]));
			jsonObj.put("Description", String.valueOf(object[5]));
		}
		
		
		return Response.status(200).entity(jsonObj.toString()).build();
	}
	
	@GET
	@Path("search")
	public Response search(@QueryParam("param1") String name) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("param 1 is : ", name);
		return Response.status(200).entity(jsonObj.toString()).build();
	}
}
