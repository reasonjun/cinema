package com.reasonjun.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Converter
public class EnumMapper<E extends Enum<E> & EnumMapperType> implements AttributeConverter<E, String> {

    private Class<E> enumClass;

    @Override
    public String convertToDatabaseColumn(E attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getCode();
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        return EnumSet.allOf(enumClass).stream()
                .filter(v -> v.getCode().equals(dbData))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}