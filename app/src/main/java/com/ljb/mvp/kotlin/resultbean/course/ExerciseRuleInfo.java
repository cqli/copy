package com.ljb.mvp.kotlin.resultbean.course;

import com.ljb.mvp.kotlin.resultbean.BaseResult;

import java.util.List;

public class ExerciseRuleInfo  extends BaseResult {
    boolean isReviewer;
    String is_reviewer;
    List<ExerciseRuleItem> rule_list;

    public String getIs_reviewer()
    {
        if (this.is_reviewer == null)
            return "";
        return this.is_reviewer;
    }

    public List<ExerciseRuleItem> getRule_list()
    {
        return this.rule_list;
    }

    public boolean hasMoreData()
    {
        return false;
    }

    public boolean isReviewer()
    {
        return "yes".equals(this.is_reviewer);
    }

    public void setIs_reviewer(String paramString)
    {
        this.is_reviewer = paramString;
    }

    public void setReviewer(boolean paramBoolean)
    {
        this.is_reviewer = "yes";
        this.isReviewer = paramBoolean;
    }

    public void setRule_list(List<ExerciseRuleItem> paramList)
    {
        this.rule_list = paramList;
    }

    public String toString()
    {
        return "ExerciseRuleInfo{is_reviewer='" + this.is_reviewer + '\'' + ", rule_list=" + this.rule_list + '}';
    }
}
