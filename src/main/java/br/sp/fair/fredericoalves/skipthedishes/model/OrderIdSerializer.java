package br.sp.fair.fredericoalves.skipthedishes.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Order Serializer for Entity Support
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public class OrderIdSerializer extends StdSerializer<Order> {
	/**
	 * serial
	 */
	private static final long serialVersionUID = 2433581203589165904L;

	public OrderIdSerializer() {
		this(null);
	}

	protected OrderIdSerializer(Class<Order> t) {
		super(t);
	}

	@Override
	public void serialize(Order order, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeStartObject();
		generator.writeNumberField("id", order.getId());
		generator.writeEndObject();
	}

}
