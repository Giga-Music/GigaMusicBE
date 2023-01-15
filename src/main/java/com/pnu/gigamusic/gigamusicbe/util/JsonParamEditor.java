package com.pnu.gigamusic.gigamusicbe.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.beans.PropertyEditorSupport;

@RequiredArgsConstructor
public class JsonParamEditor<T> extends PropertyEditorSupport {

  private final ObjectMapper jsonMapper;
  private final Class<T> tClass;

  @SneakyThrows
  @Override
  public void setAsText(String text) {
      T object = jsonMapper.readValue(text, tClass);
      setValue(object);
  }

}
