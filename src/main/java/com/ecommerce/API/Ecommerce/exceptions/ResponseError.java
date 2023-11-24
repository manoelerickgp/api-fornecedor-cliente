package com.ecommerce.API.Ecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError implements Serializable {

    @Serial
    private static final long serialVersionUID = -2688847009383216312L;

    private String message;
    private String details;
    private Integer status;
    private LocalDateTime timestamp;
}
