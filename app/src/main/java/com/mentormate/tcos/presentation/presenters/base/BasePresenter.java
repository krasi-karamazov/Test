package com.mentormate.tcos.presentation.presenters.base;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public interface BasePresenter {

    /**
     * Method that controls the lifecycle of the view (Activity or Fragment). It should be called in the onResume() method
     */
    void resume();

    /**
     * Method that controls the lifecycle of the view (Activity or Fragment). It should be called in the onPause() method
     */
    void pause();

    /**
     * Method that controls the lifecycle of the view (Activity or Fragment). It should be called in the onStop() method
     */
    void stop();

    /**
     * Method that controls the lifecycle of the view (Activity or Fragment). It should be called in the onDestroy() method
     */
    void destroy();

    /**
     * Method that signals to the view (Activity or Fragment) to show an error with the message supplied in the arguments
     * @param message The error message to display
     */
    void onError(String message);
}
