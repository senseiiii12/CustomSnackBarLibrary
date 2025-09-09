package com.snackbar.snackswipe

internal sealed class SnackSwipeState {
    data class Open(val data: SnackSwipeData) : SnackSwipeState()
    object Close : SnackSwipeState()
}