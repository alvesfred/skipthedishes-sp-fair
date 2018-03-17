package br.sp.fair.fredericoalves.skipthedishes.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Serializer for Product
 *
 * @author frederico.alves
 *
 */
public class ProductIdSerializer extends StdSerializer<Product> {
	/**
	 * serial
	 */
	private static final long serialVersionUID = 8359786829650258765L;

	public ProductIdSerializer() {
		this(null);
	}

	protected ProductIdSerializer(Class<Product> t) {
		super(t);
	}

	@Override
	public void serialize(Product item, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeStartObject();
		generator.writeNumberField("id", item.getId());
		generator.writeEndObject();
	}

}
