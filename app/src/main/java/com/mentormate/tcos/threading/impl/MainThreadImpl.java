package com.mentormate.tcos.threading.impl;

import android.os.Handler;
import android.os.Looper;

import com.mentormate.tcos.threading.base.MainThread;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */

/**
 * Class that makes sure that the runnables we provide will run on the UI thread
 */

public class MainThreadImpl implements MainThread {

    private static MainThread sMainThread;
    private Handler mHandler;

    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static MainThread getInstance() {
        if(sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }

        return sMainThread;
    }
}
