package com.mentormate.tcos.domain.interactors;

import com.mentormate.tcos.domain.interactors.base.Interactor;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public interface WelcomingInteractor {
    interface CallBack{
        void onMessageRetrieved(String message);
        void onMessageRetrievalFailed(String error);
    }
}
