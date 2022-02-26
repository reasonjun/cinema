package com.reasonjun.common;

import java.util.EnumSet;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Converter
public class EnumMapper<E extends Enum<E> & EnumMapperType> implements
    AttributeConverter<E, String> {

  private Class<E> enumClass;

  @Override
  public String convertToDatabaseColumn(E attribute) {
    if (attribute == null) {
      return null;
    }

    return attribute.name();
  }

  @Override
  public E convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }

    return EnumSet.allOf(enumClass).stream()
        .filter(v -> v.name().equals(dbData))
        .findAny()
        .orElseThrow(IllegalArgumentException::new);
  }
}