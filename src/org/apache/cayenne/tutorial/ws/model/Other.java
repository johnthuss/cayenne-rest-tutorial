package org.apache.cayenne.tutorial.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.cayenne.tutorial.ws.model.auto._Other;
import org.codehaus.jackson.annotate.JsonBackReference;

@XmlRootElement
public class Other extends _Other {

	@JsonBackReference
	@Override
	public Thing getThing() {
		return super.getThing();
	}
	
}
