package io.jobtools.android.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View


fun Context.getActivity(): Activity {
    var newContext = this

    while (newContext is ContextWrapper) {
        if (newContext is Activity)
            return newContext

        newContext = newContext.baseContext
    }

    throw RuntimeException("Failed to get activity from this context.($this)")
}

fun View.getActivity(): Activity = context.getActivity()
