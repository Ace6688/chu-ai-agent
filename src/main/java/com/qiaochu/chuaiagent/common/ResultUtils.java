package com.qiaochu.chuaiagent.common;

import com.qiaochu.chuaiagent.exception.ErrorCode;

import java.io.Serializable;

/**
 * 响应工具类
 * @param <T>
 */
public class ResultUtils<T> implements Serializable {

    /**
     * 成功
     * @param data 数据
     * @return 响应
     * @param <T> 响应类型
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0,data,"ok");
    }

    /**
     * 失败
     * @param errorCode 错误码
     * @return 响应
     */
    public static BaseResponse<?> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败
     * @param code 错误码
     * @param message 错误信息
     * @return 响应
     */
    public static BaseResponse<?> error(int code, String message) {
        return new BaseResponse<>(code, null,message);
    }

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @param message 错误信息
     * @return 响应
     */
    public static BaseResponse<?> error(ErrorCode errorCode, String message) {
        return new BaseResponse<>(errorCode.getCode(),null,message);
    }
}
