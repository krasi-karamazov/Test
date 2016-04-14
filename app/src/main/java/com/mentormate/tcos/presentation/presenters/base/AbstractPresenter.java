package com.mentormate.tcos.presentation.presenters.base;

import com.mentormate.tcos.threading.base.MainThread;
import com.mentormate.tcos.domain.executor.base.Executor;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */

/**
 * Base clas for all presenters that are interacting with all (hehe) interactors. This base class contains references to the Executor and MainThread objects that are needed for running interactor tasks on a background thread
 */
public abstract class AbstractPresenter implements BasePresenter{
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }

}
