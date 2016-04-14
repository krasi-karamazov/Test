package com.mentormate.tcos.domain.executor.base;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */

import com.mentormate.tcos.domain.interactors.base.AbstractInteractor;

/**
 * This object is responsible for running interactors on a background thread
 */

public interface Executor {

    /**
     *
     * @param interactor The interactor which tasks must be run
     */

    void execute(final AbstractInteractor interactor);
}
