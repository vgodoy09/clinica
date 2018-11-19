package br.com.clinica.exception;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) 
public class ResourceNotFoundException extends RuntimeException implements Externalizable {
	private String resourceName;
    private String fieldName;
    private Object fieldValue;
    
    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		resourceName = (String) in.readObject();
		fieldName = (String) in.readObject();
		fieldValue = in.readObject();
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(resourceName);
		out.writeObject(fieldName);
		out.writeObject(fieldValue);
	}
    
}
