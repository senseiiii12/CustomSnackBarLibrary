package com.snackbar.customsnackbarlibrary

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SnackSwipeController internal constructor() {
    private val _snackBarEvents = MutableStateFlow<SnackSwipeState?>(null)
    internal val snackBarEvents: StateFlow<SnackSwipeState?> = _snackBarEvents.asStateFlow()

    fun show(
        messageText: @Composable () -> Unit,
        icon: (@Composable (() -> Unit))? = null,
        customAction: (@Composable (() -> Unit))? = null,
        dismissAction: (@Composable (() -> Unit))? = null,
        backgroundColor: Color = Color.DarkGray,
        durationMillis: Long = 3000,
        shape: Shape = RoundedCornerShape(12.dp),
        elevation: Dp = 6.dp,
        innerPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
        outerPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 12.dp)
    ) {
        if (_snackBarEvents.value != null) return
        _snackBarEvents.value = SnackSwipeState.Open(
            SnackSwipeData(
                messageText = messageText,
                icon = icon,
                customAction = customAction,
                dismissAction = dismissAction,
                backgroundColor = backgroundColor,
                durationMillis = durationMillis,
                shape = shape,
                elevation = elevation,
                innerPadding = innerPadding,
                outerPadding = outerPadding
            )
        )
    }

    fun close() {
        _snackBarEvents.value = SnackSwipeState.Close
    }

    fun notifyHidden() {
        _snackBarEvents.value = null
    }
}

@Stable
internal data class SnackSwipeData(
    val messageText: @Composable () -> Unit,
    val icon: (@Composable (() -> Unit))?,
    val customAction: (@Composable (() -> Unit))?,
    val dismissAction: (@Composable (() -> Unit))?,
    val backgroundColor: Color,
    val durationMillis: Long,
    val shape: Shape,
    val elevation: Dp,
    val innerPadding: PaddingValues,
    val outerPadding: PaddingValues
)
