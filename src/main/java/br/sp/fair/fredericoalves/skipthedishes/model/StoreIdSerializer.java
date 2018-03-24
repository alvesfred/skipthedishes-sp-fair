package br.sp.fair.fredericoalves.skipthedishes.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Serializer for JSON
 *
 * @author frederico.alves
 *
 */
public class StoreIdSerializer extends StdSerializer<Store> {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -9185910279927943441L;

	public StoreIdSerializer() {
		this(null);
	}

	protected StoreIdSerializer(Class<Store> t) {
		super(t);
	}

	@Override
	public void serialize(Store store, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeStartObject();
		generator.writeNumberField("id", store.getId());
		generator.writeEndObject();
	}
}
