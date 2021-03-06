package br.sp.fair.fredericoalves.skipthedishes.model;

import java.io.Serializable;

/**
 * Parent Model
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public interface Model<T> extends Serializable {

	/**
	 * ID (PK)
	 *
	 * @return
	 */
	T getPK();
}
