package tech.lapsa.javax.faces.commons.conerters;

import java.time.Instant;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import tech.lapsa.java.commons.function.MyObjects;

@FacesConverter(forClass = Instant.class)
public class InstantConverter implements Converter {

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
	if (MyObjects.isNull(value))
	    return null;
	try {
	    return Instant.parse(value);
	} catch (final DateTimeParseException e) {
	    throw new ConverterException(e);
	}
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
	if (MyObjects.isNull(value))
	    return null;
	try {
	    return MyObjects.requireA(value, Instant.class, "value") //
		    .toString();
	} catch (final IllegalArgumentException e) {
	    throw new ConverterException(e);
	}
    }
}
