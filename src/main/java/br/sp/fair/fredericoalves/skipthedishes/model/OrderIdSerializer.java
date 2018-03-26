package br.sp.fair.fredericoalves.skipthedishes.model;

/**
 * Order Serializer for Entity Support
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public class OrderIdSerializer extends BaseLongPKSerializer<Order> {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 2433581203589165904L;

	public OrderIdSerializer(Class<Order> entity) {
		super(entity);
	}
}
