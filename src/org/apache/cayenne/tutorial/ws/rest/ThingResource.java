package org.apache.cayenne.tutorial.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.tutorial.ws.RestApplication;
import org.apache.cayenne.tutorial.ws.model.Thing;

@Path("/thing/{id}")
public class ThingResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Thing getUser(@PathParam("id") int id) {
		ObjectContext context = RestApplication.runtime.getContext();
		Thing result = Cayenne.objectForPK(context, Thing.class, id);
		if (result == null) {
			result = new Thing();
			result.setName("new thing");
		}
		return result;
	}
	
}