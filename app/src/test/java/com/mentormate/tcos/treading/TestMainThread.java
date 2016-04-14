package com.mentormate.tcos.treading;

import com.mentormate.tcos.threading.base.MainThread;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public class TestMainThread implements MainThread {

    @Override
    public void post(Runnable runnable) {
        // tests can run on this thread, no need to invoke other threads
        runnable.run();
    }
}
