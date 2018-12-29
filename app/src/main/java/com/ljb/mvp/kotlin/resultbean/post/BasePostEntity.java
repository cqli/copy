package com.ljb.mvp.kotlin.resultbean.post;

public class BasePostEntity {
    private String appChannel;
    private String app_role;
    private String clientType;
    private String device_type;
    private String imei;
    private String net;
    protected String user_id;
    private String versionName;

    public String getAppChannel()
    {
        return this.appChannel;
    }

    public String getApp_role()
    {
        return this.app_role;
    }

    public String getClientType()
    {
        return this.clientType;
    }

    public String getDevice_type()
    {
        return this.device_type;
    }

    public String getImei()
    {
        return this.imei;
    }

    public String getNet()
    {
        return this.net;
    }

    public String getUser_id()
    {
        return this.user_id;
    }

    public String getVersionName()
    {
        return this.versionName;
    }

    public void setAppChannel(String paramString)
    {
        this.appChannel = paramString;
    }

    public void setApp_role(String paramString)
    {
        this.app_role = paramString;
    }

    public void setClientType(String paramString)
    {
        this.clientType = paramString;
    }

    public void setDevice_type(String paramString)
    {
        this.device_type = paramString;
    }

    public void setImei(String paramString)
    {
        this.imei = paramString;
    }

    public void setNet(String paramString)
    {
        this.net = paramString;
    }

    public void setUser_id(String paramString)
    {
        this.user_id = paramString;
    }

    public void setVersionName(String paramString)
    {
        this.versionName = paramString;
    }
}
