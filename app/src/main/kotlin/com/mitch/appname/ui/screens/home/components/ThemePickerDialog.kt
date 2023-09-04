package com.mitch.appname.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.mitch.appname.R
import com.mitch.appname.ui.theme.custom.padding
import com.mitch.appname.util.AppTheme

@Composable
fun ThemePickerDialog(
    selectedTheme: AppTheme,
    onDismiss: () -> Unit,
    onConfirm: (AppTheme) -> Unit
) {
    var tempTheme by remember { mutableStateOf(selectedTheme) }

    AlertDialog(
        onDismissRequest = onDismiss,
        icon = { Icon(painterResource(id = R.drawable.palette), contentDescription = null) },
        title = {
            Text(text = stringResource(id = R.string.change_theme))
        },
        text = {
            Column(Modifier.selectableGroup()) {
                AppTheme.values().forEach { theme ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (theme == tempTheme),
                                onClick = { tempTheme = theme },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = padding.medium),
                        horizontalArrangement = Arrangement.spacedBy(padding.medium),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (theme == tempTheme),
                            onClick = null // null recommended for accessibility with screenreaders
                        )
                        Text(
                            text = stringResource(id = theme.translationId),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(stringResource(R.string.cancel))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(tempTheme)
                    onDismiss()
                },
                enabled = tempTheme != selectedTheme
            ) {
                Text(stringResource(R.string.save))
            }
        }
    )
}
