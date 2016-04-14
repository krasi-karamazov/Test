package com.mentormate.tcos.domain.interactors.base;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */

import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.threading.base.MainThread;

/**
 * <p>An abstract interator which takes care of the boilerplate code which every interactor must have. This class contains methods to chec if the interactor is running, is canceled.
 * The fields are declared volatile because the UI layer (mostly, but can be done by other threads) is going to perform these checks.<p/>
 * <p>
 *     An example of this is when an activity gets destroyed it should cancel an interactor, which is a request from the UI thread.
 *     <p/>
 */

public abstract class AbstractInteractor<T> implements Interactor {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }

    /**
     * This method contains the actual business logic. Here we define the algorithms and specific tasks.
     * Should be called ONLY for testing. While developing, we should call the execute method instead. The Run method should be called directly only when implementing unit tests, or any kinds of tests for that matter.
     * The reason this method is public is stated above - for easier testing
     */

    public abstract void run();

    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    protected abstract void notifyError();
    protected abstract void postResult(final T result);

    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }

    public boolean isRunning() {
        return mIsRunning;
    }

    @Override
    public void execute() {
        this.mIsRunning = true;

        //start the interactor task on a background thread
        mThreadExecutor.execute(this);
    }
}
