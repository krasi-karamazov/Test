package com.mentormate.tcos.domain.interactors;

import com.mentormate.tcos.threading.base.MainThread;
import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.domain.interactors.impl.WelcomingInteractorImpl;
import com.mentormate.tcos.domain.model.impl.MessageModel;
import com.mentormate.tcos.domain.repository.impl.MessageRepository;
import com.mentormate.tcos.treading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public class GetMessageByIdtest {

    private MainThread mMainThread;
    @Mock private Executor mExecutor;
    @Mock private MessageRepository mMessageRepo;
    @Mock private WelcomingInteractor.CallBack mMockedCallback;

    private long messageId;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
        messageId = 100;
    }

    @Test
    public void testCostNotFound() throws Exception {
        WelcomingInteractorImpl interactor = new WelcomingInteractorImpl(mExecutor, mMainThread, mMockedCallback, mMessageRepo, messageId);
        interactor.run();

        Mockito.verify(mMessageRepo).get(messageId);
        Mockito.verifyNoMoreInteractions(mMessageRepo);
        Mockito.verify(mMockedCallback).onMessageRetrievalFailed("No results found!");
    }

    @Test
    public void testCostFound() throws Exception {

        MessageModel dummymessage = new MessageModel("Welcome mother fucker");
        Mockito.when(mMessageRepo.get(messageId))
                .thenReturn(dummymessage);

        WelcomingInteractorImpl interactor = new WelcomingInteractorImpl(mExecutor, mMainThread, mMockedCallback, mMessageRepo, messageId);
        interactor.run();

        Mockito.verify(mMessageRepo).get(messageId);
        Mockito.verifyNoMoreInteractions(mMessageRepo);
        Mockito.verify(mMockedCallback).onMessageRetrieved(dummymessage.getMessage());
    }
}
