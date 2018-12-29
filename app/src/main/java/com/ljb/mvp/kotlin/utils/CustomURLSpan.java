package com.ljb.mvp.kotlin.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.provider.Browser;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.ljb.mvp.kotlin.KotlinMVPApplication;
import com.ljb.mvp.kotlin.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xuedakun on 2018/1/6 17:26
 * TextView使用的网址高亮可点击的StringSpan
 * {@link #setURLContent(StringBuilder)}
 * {@link #setURLSpan(int, TextView)}
 * @version : v3.0
 * @project : FamilyShare
 * @Email : dakun611@Gmail.com
 */

public class CustomURLSpan extends ClickableSpan {

    private static final String LOG_TAG = "URLSpan";

    private static final String[] schemes = new String[] {
            "http://", "https://", "rtsp://"
    };

    private String mURL;

    public CustomURLSpan(String url) {
        mURL = url;
    }

    public CustomURLSpan(Parcel src) {
        mURL = src.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        writeToParcelInternal(dest, flags);
    }

    /** @hide */
    public void writeToParcelInternal(Parcel dest, int flags) {
        dest.writeString(mURL);
    }

    public String getURL() {
        return mURL;
    }

    @Override
    public void onClick(View widget) {
        if((getURL().length() < 7 || !(getURL().substring(0, 7).equals("http://") || getURL().substring(0, 8).equals("https://")))) {
            mURL = "http://" + mURL;
        }
        Uri uri = Uri.parse(getURL());
        Context context = widget.getContext();
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Log.e("URLSpan", "Actvity was not found for intent, " + intent.toString());
        }
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(KotlinMVPApplication.Companion.getMContext().getResources().getColor(R.color.colorBlue));
        ds.setUnderlineText(false);
    }

    public static void setURLSpan(int startIndex, TextView textView) {
        textView.setMovementMethod(CustomLinkMovementMethod.getInstance());
        SpannableString spannable = new SpannableString(textView.getText());
        Matcher m = Pattern.compile("(((http[s]{0,1}|ftp)://)?[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\\\=.\\-~!@#$%^&*+?:_/=<>]*)?)").matcher(spannable);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            if(start < startIndex) {
                continue;
            }
            String url = textView.getText().toString().substring(start, end);
            if(!TextUtils.isEmpty(url)) {
//                if(!Pattern.matches("^[a-zA-Z0-9]", url.substring(0,1))) {
//                    //第一位不是字母和数字的，则去掉
//                    url = url.substring(1, url.length());
//                    start += 1;
//                }
//                String lastChar = url.substring(url.length() - 1,url.length());
//                if(!Pattern.matches("^[a-zA-Z0-9]", lastChar) && !lastChar.equals("/")) {
//                    //最后一位不是字母、数字和/的，则去掉
//                    url = url.substring(0, url.length() - 1);
//                    end -= 1;
//                }
                spannable.setSpan(new CustomURLSpan(url), start
                        , end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            }
        }
        textView.setText(spannable);
    }

    public static void setURLContent(StringBuilder stringBuilder) {
        if(!TextUtils.isEmpty(stringBuilder)) {
            Matcher m = Pattern.compile("(((http[s]{0,1}|ftp)://)?[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\\\=.\\-~!@#$%^&*+?:_/=<>]*)?)").matcher(stringBuilder);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                String url = stringBuilder.substring(start, end);

                if((url.length() < 8 || (!url.substring(0, 7).equals("http://") && !url.substring(0, 8).equals("https://")))) {
                    stringBuilder.insert(start, "http://" );
                    setURLContent(stringBuilder);
                    return;
                }
            }
        }
    }


    private static final String makeUrl(@NonNull String url, @NonNull String[] prefixes,
                                        Matcher matcher, @Nullable Linkify.TransformFilter filter) {
        if (filter != null) {
            url = filter.transformUrl(matcher, url);
        }

        boolean hasPrefix = false;

        for (int i = 0; i < prefixes.length; i++) {
            if (url.regionMatches(true, 0, prefixes[i], 0, prefixes[i].length())) {
                hasPrefix = true;

                // Fix capitalization if necessary
                if (!url.regionMatches(false, 0, prefixes[i], 0, prefixes[i].length())) {
                    url = prefixes[i] + url.substring(prefixes[i].length());
                }

                break;
            }
        }

        if (!hasPrefix && prefixes.length > 0) {
            url = prefixes[0] + url;
        }

        return url;
    }

    static class LinkSpec {
        String url;
        int start;
        int end;
    }
}
