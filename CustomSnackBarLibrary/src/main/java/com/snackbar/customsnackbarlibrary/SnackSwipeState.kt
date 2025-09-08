package com.snackbar.customsnackbarlibrary

internal sealed class SnackSwipeState {
    data class Open(val data: SnackSwipeData) : SnackSwipeState()
    object Close : SnackSwipeState()
}