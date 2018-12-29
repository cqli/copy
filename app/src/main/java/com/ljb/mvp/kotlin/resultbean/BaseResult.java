package com.ljb.mvp.kotlin.resultbean;

import java.io.Serializable;

//数据解析基类
public abstract class BaseResult implements Serializable {
    private Object arg1;
    private Object arg2;
    private int requestCode;

    public Object getArg1() {
        return arg1;
    }

    public void setArg1(Object arg1) {
        this.arg1 = arg1;
    }

    public Object getArg2() {
        return arg2;
    }

    public void setArg2(Object arg2) {
        this.arg2 = arg2;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public abstract boolean hasMoreData();
}