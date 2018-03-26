package br.sp.fair.fredericoalves.skipthedishes.model;

/**
 * Serializer for Product
 *
 * @author frederico.alves
 *
 */
public class ProductIdSerializer extends BaseLongPKSerializer<Product> {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 8359786829650258765L;

	public ProductIdSerializer(Class<Product> entity) {
		super(entity);
	}	
}
