package com.mentormate.tcos.presentation.presenters;

import com.mentormate.tcos.presentation.presenters.base.BasePresenter;
import com.mentormate.tcos.presentation.ui.BaseView;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public interface MainPresenter extends BasePresenter {
    interface View extends BaseView{
        void displayMessage(String msg);
    }

    //TODO add presenter specific methods
}
