package com.mentormate.tcos.domain.interactors.impl;

import com.mentormate.tcos.threading.base.MainThread;
import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.domain.interactors.WelcomingInteractor;
import com.mentormate.tcos.domain.interactors.base.AbstractInteractor;
import com.mentormate.tcos.domain.model.impl.MessageModel;
import com.mentormate.tcos.domain.repository.impl.MessageRepository;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public class WelcomingInteractorImpl extends AbstractInteractor<String> implements WelcomingInteractor{

    private WelcomingInteractor.CallBack mCallBack;
    private MessageRepository mRepository;
    private long mMessageId;

    public WelcomingInteractorImpl(Executor threadExecutor, MainThread mainThread, WelcomingInteractor.CallBack callBack, MessageRepository repository, long messageId) {
        super(threadExecutor, mainThread);
        mCallBack = callBack;
        mRepository = repository;
        mMessageId = messageId;
    }

    @Override
    public void run() {
        final MessageModel message = mRepository.get(mMessageId);
        if(message == null) {
            notifyError();
            return;
        }

        postResult(message.getMessage());
    }

    @Override
    protected void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallBack.onMessageRetrievalFailed("No results found!");
            }
        });
    }

    @Override
    protected void postResult(final String result) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallBack.onMessageRetrieved(result);
            }
        });
    }

}
