package com.manoj.userservice.dto.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDTO<T> {

  private T data;

  private String error;

  public static <T> ResponseDTO<T> ok (T data) {
    return ResponseDTO.<T>builder().data(data).build();
  }

  public static <T> ResponseDTO<T> er(String error) {
    return ResponseDTO.<T>builder()
        .error(error)
        .build();
  }
}
