package com.mentormate.tcos.domain.executor.impl;

import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.domain.interactors.base.AbstractInteractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */

/**
 * Singleton class responsible for executing every interactor task on a background thread
 */

public class ThreadExecutor implements Executor {

    private static volatile ThreadExecutor sThreadExecutor;

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadExecutor() {
        mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    public static Executor getInstance() {
        if(sThreadExecutor == null) {
            sThreadExecutor = new ThreadExecutor();
        }

        return sThreadExecutor;
    }

    @Override
    public void execute(final AbstractInteractor interactor) {
        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                interactor.run();
            }
        });
    }
}
