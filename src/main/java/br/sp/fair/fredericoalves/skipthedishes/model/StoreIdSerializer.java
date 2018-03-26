package br.sp.fair.fredericoalves.skipthedishes.model;

/**
 * Serializer for JSON
 *
 * @author frederico.alves
 *
 */
public class StoreIdSerializer extends BaseLongPKSerializer<Store> {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -9185910279927943441L;

	public StoreIdSerializer(Class<Store> entity) {
		super(entity);
	}
}
