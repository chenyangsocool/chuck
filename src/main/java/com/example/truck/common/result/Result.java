package com.example.truck.common.result;

import com.example.truck.common.type.ShowType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * result structure
 */
@Getter
@Setter
@Accessors(chain = true)
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * success
     */
    private Boolean success;

    /**
     * data
     */
    private T data;

    /**
     * error message
     */
    private String errorMessage;

    /**
     * show type
     */
    private String showType;

    /**
     * trace id
     */
    private String traceId;

    /**
     * generate success data
     *
     * @param data data
     * @param <T>  T
     * @return data
     */
    public static <T> Result<T> ok(T data) {
        return generateResult(true, null, null, data);
    }

    /**
     * generate error data
     *
     * @param errorMessage       error message
     * @param showType           show type
     * @param stackTraceElements stack trace elements
     * @param <T>                T
     * @return error data
     */
    public static <T> Result<T> error(String errorMessage,
                                      ShowType showType,
                                      StackTraceElement[] stackTraceElements) {
        return generateResult(false, errorMessage, showType, null);
    }

    /**
     * generate result data
     *
     * @param success      success
     * @param errorMessage error message
     * @param showType     show type
     * @param data         return data
     * @param <T>          T
     * @return data
     */
    private static <T> Result<T> generateResult(Boolean success, String errorMessage, ShowType showType, T data) {
        return new Result<T>().setSuccess(success)
                .setData(data)
                .setErrorMessage(errorMessage)
                .setShowType(showType == null ? null : showType.getValue());
    }
}