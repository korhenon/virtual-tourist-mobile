package com.example.virtualtourist.ui.utils

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.runtime.snapshotFlow

@Composable
fun LazyListState.isScrollingUp(): State<Boolean> {
    return produceState(initialValue = true) {
        var lastIndex = 0
        var lastScroll = Int.MAX_VALUE
        var isScrollingUp = false
        var scrollUpStart = 0
        snapshotFlow {
            firstVisibleItemIndex to firstVisibleItemScrollOffset
        }.collect { (currentIndex, currentScroll) ->
            if (currentIndex != lastIndex || currentScroll != lastScroll) {
                val pastIsScrollUp = isScrollingUp
                isScrollingUp =
                    currentIndex < lastIndex || (currentIndex == lastIndex && currentScroll < lastScroll)
                lastIndex = currentIndex
                lastScroll = currentScroll
                if (!pastIsScrollUp && isScrollingUp) scrollUpStart = currentScroll
                if (!isScrollingUp) value = false
                if (lastScroll == 0) value = true
                if (isScrollingUp && scrollUpStart - 150 > lastScroll) value = true
            }
        }
    }
}