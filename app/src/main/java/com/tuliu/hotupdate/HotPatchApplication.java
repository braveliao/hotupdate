package com.tuliu.hotupdate;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import dalvik.system.DexClassLoader;

/**
 * Created by hp on 2016/4/6.
 */
public class HotPatchApplication extends Application {
    public static PatchManager mPatchManager;
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化patch管理类
        mPatchManager = new PatchManager(this);
        // 初始化patch版本
        mPatchManager.init("1.0");
        // 加载已经添加到PatchManager中的patch
        mPatchManager.loadPatch();
    }
}
