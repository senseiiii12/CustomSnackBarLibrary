package com.snackbar.customsnackbarlibrary

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


/**
 * Публичная функция библиотеки: стилизованная кнопка.
 */

@Composable
fun FancyButton(
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(onClick = onClick, modifier = modifier.padding(8.dp)) {
        Text(text = label)
    }
}
