package org.apache.cayenne.tutorial.ws.model.auto;

import org.apache.cayenne.tutorial.ws.model.RestDataObject;
import org.apache.cayenne.tutorial.ws.model.Thing;

/**
 * Class _Other was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Other extends RestDataObject {

    public static final String NUMBER_PROPERTY = "number";
    public static final String THING_PROPERTY = "thing";

    public static final String ID_PK_COLUMN = "id";

    public void setNumber(Integer number) {
        writeProperty("number", number);
    }
    public Integer getNumber() {
        return (Integer)readProperty("number");
    }

    public void setThing(Thing thing) {
        setToOneTarget("thing", thing, true);
    }

    public Thing getThing() {
        return (Thing)readProperty("thing");
    }


}
