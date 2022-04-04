package com.gussoft.pedidoscr.utils;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.time.LocalDate;

//@Converter(autoApply = true)
public class LocalDateConvert implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date == null ? null : date.toLocalDate();
    }
}
