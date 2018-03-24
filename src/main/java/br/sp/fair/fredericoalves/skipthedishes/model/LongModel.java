package br.sp.fair.fredericoalves.skipthedishes.model;

/**
 * Parent Model
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public interface LongModel extends Model<Long> {

	/**
	 * ID (PK)
	 *
	 * @return
	 */
	Long getId();

	/**
	 * PK
	 */
	@Override
	default Long getPK() {
		return getId();
	}
}
