package br.sp.fair.fredericoalves.skipthedishes.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Base serializer class
 *
 * @author frederico.alves
 *
 */
public class BaseLongPKSerializer<T extends LongModel> extends StdSerializer<T> {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -7932142409858092468L;

	public BaseLongPKSerializer() {
		this(null);
	}

	public BaseLongPKSerializer(Class<T> entity) {
		super(entity);
	}

	@Override
	public void serialize(T entity, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeStartObject();
		generator.writeNumberField("id", entity.getPK());
		generator.writeEndObject();
	}
}
