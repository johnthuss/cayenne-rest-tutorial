package org.apache.cayenne.tutorial.ws.model;

import org.apache.cayenne.CayenneDataObject;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({"objectContext", "objEntity", "snapshotVersion", "persistenceState"})
public class RestDataObject extends CayenneDataObject {

}
