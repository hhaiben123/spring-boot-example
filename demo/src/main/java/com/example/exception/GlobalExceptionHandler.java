package com.example.exception;

import com.example.exception.MyException;
import com.example.vo.ErrorInfo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * Created by hhb on 2017/8/5.
 * 为MyException异常创建对应的处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ErrorInfo<String>  jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ErrorInfo<String> handleMissingServletRequestParameterException(HttpServletRequest req,MissingServletRequestParameterException e) {
        logger.error("缺少请求参数", e);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("required_parameter_is_not_present");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorInfo<String> handleHttpMessageNotReadableException(HttpServletRequest req,HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("could_not_read_json");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ErrorInfo<String> handleMethodArgumentNotValidException(HttpServletRequest req,MethodArgumentNotValidException e) {
        logger.error("参数验证失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(message);
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ErrorInfo<String> handleBindException(HttpServletRequest req,BindException e) {
        logger.error("参数绑定失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(message);
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public  ErrorInfo<String> handleServiceException(HttpServletRequest req,ConstraintViolationException e) {
        logger.error("参数验证失败", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(message);
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ErrorInfo<String> handleValidationException(HttpServletRequest req,ValidationException e) {
        logger.error("参数验证失败", e);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("validation_exception");
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorInfo<String> handleHttpRequestMethodNotSupportedException(HttpServletRequest req,HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("content_type_not_supported");
        r.setCode(ErrorInfo.ERROR_405);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ErrorInfo<String> handleHttpMediaTypeNotSupportedException(HttpServletRequest req,Exception e) {
        logger.error("不支持当前媒体类型", e);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("content_type_not_supported");
        r.setCode(ErrorInfo.ERROR_415);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    public ErrorInfo<String> handleServiceException(HttpServletRequest req,ServiceException e) {
        logger.error("业务逻辑异常", e);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("业务逻辑异常：" + e.getMessage());
        r.setCode(ErrorInfo.ERROR_500);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorInfo<String> handleException(HttpServletRequest req,Exception e) {
        logger.error("通用异常", e);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("通用异常：" + e.getMessage());
        r.setCode(ErrorInfo.ERROR_500);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorInfo<String> handleException(HttpServletRequest req,DataIntegrityViolationException e) {
        logger.error("操作数据库出现异常:", e);
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("操作数据库出现异常");
        r.setCode(ErrorInfo.ERROR_500);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


}

