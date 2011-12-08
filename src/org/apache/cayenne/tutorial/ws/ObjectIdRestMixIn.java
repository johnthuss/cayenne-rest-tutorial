package org.apache.cayenne.tutorial.ws;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

abstract class ObjectIdRestMixIn {
	
	@JsonIgnore abstract boolean isReplacementIdAttached();
	@JsonIgnore abstract Map<String, Object> getReplacementIdMap();
}
