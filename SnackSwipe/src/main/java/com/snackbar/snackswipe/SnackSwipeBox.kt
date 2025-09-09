package com.snackbar.snackswipe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SnackSwipeBox(
    modifier: Modifier = Modifier,
    content: @Composable (SnackSwipeController) -> Unit
) {
    val snackSwipeController = remember { SnackSwipeController() }

    Box(modifier = modifier) {
        content(snackSwipeController)
        SnackSwipeHost(
            controller = snackSwipeController,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

fun SnackSwipeController.showSnackSwipe(
    messageText: @Composable () -> Unit,
    icon: (@Composable () -> Unit)? = null,
    customAction: (@Composable () -> Unit)? = null,
    dismissAction: (@Composable (() -> Unit))? = null,
    backgroundColor: Color = Color.Black,
    durationMillis: Long = 3000,
    shape: Shape = RoundedCornerShape(12.dp),
    elevation: Dp = 6.dp,
    innerPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
    outerPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 12.dp)
) {
    show(
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
}