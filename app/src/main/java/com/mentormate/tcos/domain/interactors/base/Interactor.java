package com.mentormate.tcos.domain.interactors.base;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */

/**
 * This is the interface for interactors. Every interactor is used for a specific use case
 */

public interface Interactor {

    /**
     * Method which starts the interactor. The operation executed here will be done on a background thread
     */

    void execute();
}
