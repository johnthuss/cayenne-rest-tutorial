package org.apache.cayenne.tutorial.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.tutorial.ws.model.Other;
import org.apache.cayenne.tutorial.ws.model.Thing;
import org.apache.cayenne.tutorial.ws.rest.ThingResource;


public class RestApplication extends Application {
	
	public static ServerRuntime runtime = new ServerRuntime("cayenne-Rest.xml");

	public RestApplication() {
		ObjectContext context = runtime.getContext();
		Thing thing1 = context.newObject(Thing.class);
		thing1.setName("thing1");
		
		Other other1 = context.newObject(Other.class);
		other1.setNumber(100);
		thing1.addToOthers(other1);

		Other other2 = context.newObject(Other.class);
		other2.setNumber(200);
		thing1.addToOthers(other2);
		
		context.commitChanges();
		
		System.out.println("thing1 can be access at url: http://localhost:8080/cayenne-rest-tutorial/rest/thing/" + thing1.getObjectId().getIdSnapshot().get("id"));
	}
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(ThingResource.class);
		s.add(RestMapperProvider.class);
		return s;
	}

}
