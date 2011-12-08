package org.apache.cayenne.tutorial.ws;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.apache.cayenne.ObjectId;
import org.apache.cayenne.PersistentObject;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.Pair;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

@Provider
public class RestMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;
    final ObjectMapper combinedObjectMapper;

    public RestMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
        combinedObjectMapper = createCombinedObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        if (PersistentObject.class.isAssignableFrom(type)) {
            return combinedObjectMapper;
        } else {
            return defaultObjectMapper;
        }
    }

    private static ObjectMapper createCombinedObjectMapper() {
        Pair combinedIntrospector = createJaxbJacksonAnnotationIntrospector();
        ObjectMapper result = new ObjectMapper();
        result.configure(Feature.INDENT_OUTPUT, true);
        
        result.setDeserializationConfig(result.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
        result.setSerializationConfig(result.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));
        
        result.getSerializationConfig().addMixInAnnotations(ObjectId.class, ObjectIdRestMixIn.class);
        result.getDeserializationConfig().addMixInAnnotations(ObjectId.class, ObjectIdRestMixIn.class);
        return result;
    }

    private static ObjectMapper createDefaultMapper() {
        ObjectMapper result = new ObjectMapper();
        result.configure(Feature.INDENT_OUTPUT, true);
        return result;
    }

    private static Pair createJaxbJacksonAnnotationIntrospector() {
        AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
        AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
        return new AnnotationIntrospector.Pair(jaxbIntrospector, jacksonIntrospector);
    }
    
}