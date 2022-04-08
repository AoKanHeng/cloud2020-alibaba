package cn.aokan.common;

public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }


    /**
     * 状态信息,错误描述.
     */
    private String message;

    /**
     * 获取消息内容。
     *
     * @return 消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 数据.
     */
    private T data;

    /**
     * 获取数据内容。
     *
     * @return 数据
     */
    public T getData() {
        return data;
    }

    public Result(){}

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static <T> Result<T> buildResult(Integer code, String message, T data) {
        return new Result<T>(code, message, data);
    }


    public static <T> Result<T> buildResult(Integer code, String message) {
        return new Result<T>(code, message);

    }

}
