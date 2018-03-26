package br.sp.fair.fredericoalves.skipthedishes.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Converter;

/**
 * LocalDateTime converter to avoid serialization problems
 *
 * @author frederico.alves
 *
 */
@Converter
public class LocalDateTimeConverter extends BaseConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime entityValue) {
        if (entityValue == null) {
            return null;
        }
        return Timestamp.valueOf(entityValue);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        return databaseValue.toLocalDateTime();
    }
}