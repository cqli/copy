package com.ljb.mvp.kotlin.resultbean.course;

import java.io.Serializable;

public class ExerciseRuleItem implements Serializable {
    String content;
    String title;

    public String getContent()
    {
        if (this.content == null)
            return "";
        return this.content;
    }

    public String getTitle()
    {
        if (this.title == null)
            return "";
        return this.title;
    }

    public void setContent(String paramString)
    {
        this.content = paramString;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public String toString()
    {
        return "ExerciseRuleItem{title='" + this.title + '\'' + ", content='" + this.content + '\'' + '}';
    }
}
