package com.tuana9a.learnjavaspringweb.utils;

import com.tuana9a.learnjavaspringweb.config.AppConfig;
import com.tuana9a.learnjavaspringweb.dto.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JsonResponseUtils {

    @Autowired
    private AppConfig config;

    public ResponseEntity<JsonResponse> ok(Object data) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(JsonResponse.builder()
                        .code(config.CODE_OK)
                        .message("ok")
                        .data(data)
                        .build());
    }

    public ResponseEntity<JsonResponse> created(Object data) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(JsonResponse.builder()
                        .code(config.CODE_OK)
                        .message("created")
                        .data(data)
                        .build());
    }

    public ResponseEntity<JsonResponse> updated(Object data) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(JsonResponse.builder()
                        .code(config.CODE_OK)
                        .message("updated")
                        .data(null)
                        .build());
    }


    public ResponseEntity<JsonResponse> updated() {
        return this.updated(null);
    }

    

    public ResponseEntity<JsonResponse> deleted() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(JsonResponse.builder()
                        .code(config.CODE_OK)
                        .message("deleted")
                        .data(null)
                        .build());
    }


    public ResponseEntity<JsonResponse> badRequest(String message) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(JsonResponse.builder()
                        .code(config.CODE_NOT_OK)
                        .message(message)
                        .data(null)
                        .build());
    }

    public ResponseEntity<JsonResponse> notFound(String message) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(JsonResponse.builder()
                        .code(config.CODE_NOT_OK)
                        .message(message)
                        .data(null)
                        .build());
    }

    public ResponseEntity<JsonResponse> unauthorized(String message) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(JsonResponse.builder()
                        .code(config.CODE_NOT_OK)
                        .message(message)
                        .data(null)
                        .build());
    }

    public ResponseEntity<JsonResponse> internalServerError(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(JsonResponse.builder()
                        .code(config.CODE_NOT_OK)
                        .message(exception.getMessage())
                        .data(null)
                        .build());
    }
}
