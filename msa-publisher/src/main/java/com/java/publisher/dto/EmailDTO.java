package com.java.publisher.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailDTO {
    UUID id;
    String header;
    String body;
    Integer code;
}
