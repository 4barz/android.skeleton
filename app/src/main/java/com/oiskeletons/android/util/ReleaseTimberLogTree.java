package com.oiskeletons.android.util;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by rubin.apore on 10/28/17.
 */


 /** A {@link Timber.DebugTree DebugTree} for debug builds.
  * Automatically infers the tag from the calling class.
  * Log to your favourite logging service/tool
  * */
public class ReleaseTimberLogTree extends Timber.DebugTree {
     /**
      * Decide if a potential log item should be logged
      *
      * @param tag The tag generated for this log item
      * @param priority The priority of the log item
      * @return <code>true</code> if the the item meets the criteria to be logged
      */
    @Override
    protected boolean isLoggable(String tag, int priority) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return false;
        }
        return true;
    }

     /**
      * This method is an does the actual logging, in this case the intention is to eventually
      * log to crashlytics
      *
      * @param priority The priority of the log item
      * @param tag The tag generated for this log item
      * @param message The message accompanying this log item
      * @param t A throwable that was generated from the calling method
      */
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        // super.log(priority, tag, message, t);
        // log to crashlytics or some other fancy tool
    }
}
