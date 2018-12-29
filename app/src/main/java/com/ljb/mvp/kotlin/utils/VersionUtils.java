package com.ljb.mvp.kotlin.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class VersionUtils {
    static PackageInfo localPackageInfo1;
    public static String getChannel()
    {
        return "";
    }

    public static int getVersionCode(Context paramContext)
    {
        PackageManager localPackageManager = paramContext.getPackageManager();
        try
        {
            PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
            localPackageInfo1 = localPackageInfo2;
            int i = 0;
            if (localPackageInfo1 != null)
            {
                int j = localPackageInfo1.versionCode;
                i = 0;
                if (j != 0)
                    i = localPackageInfo1.versionCode;
            }
            return i;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
            while (true)
            {
                localNameNotFoundException.printStackTrace();
                PackageInfo localPackageInfo1 = null;
            }
        }
    }

    public static String getVersionName(Context paramContext)
    {
        PackageManager localPackageManager = paramContext.getPackageManager();
        try
        {
            PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
            localPackageInfo1 = localPackageInfo2;
            if ((localPackageInfo1 != null) && (localPackageInfo1.versionName != null))
                return localPackageInfo1.versionName;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
            while (true)
            {
                localNameNotFoundException.printStackTrace();
                PackageInfo localPackageInfo1 = null;
            }
        }
        return "NO_VERSION";
    }
}
