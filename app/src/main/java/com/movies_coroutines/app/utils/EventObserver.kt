package com.movies_coroutines.app.utils

import androidx.lifecycle.Observer

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandledOrReturnNull()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}