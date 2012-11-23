package com.fasterxml.jackson.module.jsonSchema.factories;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema;

/**
 * While JSON Schema does not have notion of "Map" type (unlimited property
 * names), Jackson has, so the distinction is exposed. We will need
 * to handle it here, produce JSON Schema Object type.
 */
public class MapVisitor extends StructuredTypeVisitor
    implements JsonMapFormatVisitor, JsonSchemaProducer
{
    protected final JsonSchemaReference parent;
    protected final ObjectSchema schema;
    
    public MapVisitor(SerializerProvider provider,
            JsonSchemaReference parent, ObjectSchema schema)
    {
        super(provider);
        this.parent = parent;
        this.schema = schema;
    }

    /*
    /*********************************************************************
    /* JsonSchemaProducer
    /*********************************************************************
     */

    public ObjectSchema getSchema() {
        return schema;
    }
    
    /*
    /*********************************************************************
    /* JsonMapFormatVisitor
    /*********************************************************************
     */
    
    @Override
    public void keyFormat(JsonFormatVisitable handler, JavaType keyType)
            throws JsonMappingException {
        // JSON Schema only allows String types so let's not bother too much
    }

    @Override
    public void valueFormat(JsonFormatVisitable handler, JavaType valueType)
            throws JsonMappingException {
        /* Also... not sure what to do with value type either.
         */
    }
}
