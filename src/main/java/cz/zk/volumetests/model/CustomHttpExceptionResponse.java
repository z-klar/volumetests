package cz.zk.volumetests.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@Getter
@JsonIgnoreProperties("order")
public class CustomHttpExceptionResponse {

    private int statusCode;
    private String message;
    private String error;
    private long timestamp;

    public CustomHttpExceptionResponse() {
        /* empty */
    }

    public CustomHttpExceptionResponse(HttpStatus status, String message) {
        this.statusCode = status.value();
        this.message = message;
        this.error = status.getReasonPhrase();
        this.timestamp = new Date().getTime();
    }

    public CustomHttpExceptionResponse(HttpStatus status, String error, String message) {
        this.statusCode = status.value();
        this.message = message;
        this.error = error;
        this.timestamp = new Date().getTime();
    }
}
