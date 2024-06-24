package com.nata.realworldspringboot.common.domain;

import java.util.Objects;

public class SingleValueObject<T> {
  T value;

  public SingleValueObject(T value) {
    this.value = value;
  }

  public T toPrimitives() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SingleValueObject<?> that = (SingleValueObject<?>) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
