package br.sp.fair.fredericoalves.skipthedishes.model;

/**
 * Customer Serializer for Entity Support
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public class CustomerIdSerializer extends BaseLongPKSerializer<Customer> {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 113581203589165904L;

	public CustomerIdSerializer(Class<Customer> entity) {
		super(entity);
	}
}
