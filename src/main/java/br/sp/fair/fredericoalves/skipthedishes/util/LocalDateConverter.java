package br.sp.fair.fredericoalves.skipthedishes.util;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Converter;

/**
 * LocalDate converter to avoid serialization problems
 *
 * @author frederico.alves
 *
 */
@Converter
public class LocalDateConverter extends BaseConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate entityValue) {
        if (entityValue == null) {
            return null;
        }

        return Date.valueOf(entityValue);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date databaseValue) {
        if (databaseValue == null) {
            return null;
        }

        return databaseValue.toLocalDate();
    }
}