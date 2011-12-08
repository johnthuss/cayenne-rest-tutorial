package org.apache.cayenne.tutorial.ws.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.cayenne.tutorial.ws.model.auto._Thing;
import org.codehaus.jackson.annotate.JsonManagedReference;

@XmlRootElement
public class Thing extends _Thing {

	@JsonManagedReference
	@Override
	public List<Other> getOthers() {
		return super.getOthers();
	}
	
}
