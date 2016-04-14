package com.mentormate.tcos.threading.base;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */

/**
 * This interface is used to define a class which enables interactors to communicate with the UI thread.
 * An interactor might need to show something in the UI (a Toast for example). This will make sure that the appropriate method is called on the UI thread
 */

public interface MainThread {

    /**
     * This method makes runnables run on the main thread
     * @param runnable The runnable to execute on the main thread
     */
    void post(Runnable runnable);
}
