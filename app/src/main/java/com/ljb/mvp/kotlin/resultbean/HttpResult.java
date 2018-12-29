package com.ljb.mvp.kotlin.resultbean;

/**
 * 网络数据返回统一解析
 *
 * @param <T>
 */
public class HttpResult<T extends BaseResult> {
    public T data;
    private String error_msg;
    private int error_no;

    public T getData() {
        return this.data;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public int getError_no() {
        return this.error_no;
    }

    public void setData(T paramE) {
        this.data = paramE;
    }

    public void setError_msg(String paramString) {
        this.error_msg = paramString;
    }

    public void setError_no(int paramInt) {
        this.error_no = paramInt;
    }

    public String toString() {
        return "HttpResult{error_no=" + this.error_no + ", error_msg='" + this.error_msg + '\'' + ", data=" + 16842798 + '}';
    }
}
