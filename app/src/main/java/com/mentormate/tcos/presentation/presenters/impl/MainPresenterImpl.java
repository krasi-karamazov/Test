package com.mentormate.tcos.presentation.presenters.impl;

import com.mentormate.tcos.threading.base.MainThread;
import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.domain.interactors.WelcomingInteractor;
import com.mentormate.tcos.domain.interactors.impl.WelcomingInteractorImpl;
import com.mentormate.tcos.domain.repository.impl.MessageRepository;
import com.mentormate.tcos.presentation.presenters.MainPresenter;
import com.mentormate.tcos.presentation.presenters.base.AbstractPresenter;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter, WelcomingInteractor.CallBack {

    private MainPresenter.View mView;
    private Executor mExecutor;
    private MainThread mMainThread;
    private MessageRepository mMessageRepo;
    private WelcomingInteractorImpl mWelcomingInteractor;
    public MainPresenterImpl(Executor executor, MainThread mainThread, MainPresenter.View view) {
        super(executor, mainThread);
        mView = view;
        mExecutor = executor;
        mMainThread = mainThread;
        mMessageRepo = new MessageRepository();
    }

    @Override
    public void resume() {
        mView.showProgress();
        mWelcomingInteractor = new WelcomingInteractorImpl(mExecutor, mMainThread, this, mMessageRepo, 0);
        mWelcomingInteractor.execute();
    }

    @Override
    public void pause() {
        if(mWelcomingInteractor.isRunning()) {
            mWelcomingInteractor.cancel();
        }
    }

    @Override
    public void stop() {
        if(mWelcomingInteractor.isRunning()) {
            mWelcomingInteractor.cancel();
        }
    }

    @Override
    public void destroy() {
        if(mWelcomingInteractor.isRunning()) {
            mWelcomingInteractor.cancel();
        }
    }

    @Override
    public void onError(String message) {
        mView.hideProgress();
        mView.displayError(message);
    }

    @Override
    public void onMessageRetrieved(String message) {
        mView.hideProgress();
        mView.displayError(message);
    }

    @Override
    public void onMessageRetrievalFailed(String error) {
        mView.hideProgress();
        mView.displayError(error);
    }
}
