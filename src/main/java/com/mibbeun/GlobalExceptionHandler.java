package com.mibbeun;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.jdbc.BadSqlGrammarException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // JDBC SQLException 처리
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Map<String, Object>> handleSQLException(SQLException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("errorCode", ex.getErrorCode());   // DB 에러 코드
        error.put("sqlState", ex.getSQLState());     // SQL 상태 코드
        error.put("message", ex.getMessage());       // 상세 메시지
          //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON) // UTF-8 지정
                //.contentType(MediaType.APPLICATION_JSON_UTF8) // UTF-8 지정
                .body(error);          
    }

    // MyBatis 문법 오류 처리
    @ExceptionHandler(BadSqlGrammarException.class)
    public ResponseEntity<Map<String, Object>> handleBadSqlGrammar(BadSqlGrammarException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("errorCode", "BAD_SQL");
        error.put("message", ex.getMessage());
        System.out.println(ex.getSql());
       // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON) // UTF-8 지정
                //.contentType(MediaType.APPLICATION_JSON_UTF8) // UTF-8 지정
                .body(error);        
    }

    // 그 외 일반 Exception 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("errorCode", "GENERAL_ERROR");
        error.put("message", ex.getMessage());
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON) // UTF-8 지정
                //.contentType(MediaType.APPLICATION_JSON_UTF8) // UTF-8 지정
                .body(error);
        
    }
}
