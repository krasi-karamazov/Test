package com.mentormate.tcos.domain.interactors.impl;

import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.threading.base.MainThread;
import com.mentormate.tcos.domain.interactors.SampleInteractor;
import com.mentormate.tcos.domain.interactors.base.AbstractInteractor;
import com.mentormate.tcos.domain.repository.Repository;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public class SampleInteractorImpl extends AbstractInteractor{

    private SampleInteractor.Callback mCallback;
    private Repository mRepository;

    public SampleInteractorImpl(Executor threadExecutor, MainThread mainThread, SampleInteractor.Callback callback, Repository repository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mRepository = repository;
    }

    @Override
    public void run() {
        //TODO this is the place for the business logic
    }

    @Override
    protected void notifyError() {

    }

    @Override
    protected void postResult(Object result) {

    }
}
