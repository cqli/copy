package com.ljb.mvp.kotlin.resultbean.post;

public class Login extends BasePostEntity {
    private String auth_code;
    private String channel;
    private String passwd;
    private String phone;
    private long timestamp;

    public String getAuth_code() {
        return this.auth_code;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public String getPhone() {
        return this.phone;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setAuth_code(String paramString) {
        this.auth_code = paramString;
    }

    public void setChannel(String paramString) {
        this.channel = paramString;
    }

    public void setPasswd(String paramString) {
        this.passwd = paramString;
    }

    public void setPhone(String paramString) {
        this.phone = paramString;
    }

    public void setTimestamp(long paramLong) {
        this.timestamp = paramLong;
    }
}
