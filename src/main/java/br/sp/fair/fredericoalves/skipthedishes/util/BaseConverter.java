package br.sp.fair.fredericoalves.skipthedishes.util;

import javax.persistence.AttributeConverter;

/**
 * Base Converter
 *
 * @author frederico.alves
 *
 * @param <R>
 * @param <T>
 */
public abstract class BaseConverter<R, T> implements AttributeConverter<R, T> {

	/**
	 * Database column converter
	 */
	@Override
	public abstract T convertToDatabaseColumn(R entityValue);

	/**
	 * Entity converter
	 */
	@Override
	public abstract R convertToEntityAttribute(T databaseValue);

}
