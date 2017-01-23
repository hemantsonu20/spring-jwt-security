package com.github.spring.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * A controller which adds additional details in case of some error occurred in
 * the service
 * 
 * @author pratapihemant.patel
 *
 */
public class ErrorController extends BasicErrorController {

    private final ErrorAttributes errorAttributes;

    public ErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
        this.errorAttributes = errorAttributes;
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {

        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        Throwable throwable = errorAttributes.getError(new ServletRequestAttributes(request));

        HttpStatus status;
        if (throwable instanceof WebServiceException) {
            status = ((WebServiceException) throwable).getHttpStatus();
            body.put("status", status.value());
            body.put("error", status.getReasonPhrase());
        }
        else {
            status = getStatus(request);
        }
        return new ResponseEntity<>(body, status);
    }
}
