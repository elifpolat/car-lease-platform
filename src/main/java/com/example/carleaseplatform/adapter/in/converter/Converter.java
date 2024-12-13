package com.example.carleaseplatform.adapter.in.converter;

import java.util.function.Function;

public interface Converter<T, R> extends Function<T, R> {

  default R convert(T t) {
    return apply(t);
  }
}
