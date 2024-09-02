package com.smart.clinic.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.smart.clinic.core.designsystem.theme.ClinicTheme

@Composable
fun ClinicOutlineTextFieldWithOuterBorder(
    modifier: Modifier = Modifier,
    borderModifier: Modifier = Modifier,
    value: String,
    placeholder: String = "",
    textAlign: TextAlign = TextAlign.End,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    textStyle: TextStyle = ClinicTheme.typography.paragraphMedium,
    textColor: Color = ClinicTheme.colorScheme.foregroundBase,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(ClinicTheme.shapes.medium),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = ClinicTheme.colorScheme.backgroundInverse,
        unfocusedBorderColor = ClinicTheme.colorScheme.backgroundInverse,
        ),
    onValueChanged: (String) -> Unit
) {
    Box(
        modifier = borderModifier.then(Modifier)
            .border(
                width = ClinicTheme.strokes.thick,
                color = ClinicTheme.colorScheme.effectNeutral,
                shape =shape
            )
            .padding(4.dp)
        ,
        contentAlignment = Alignment.Center
    ) {

        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChanged,
            placeholder = {
                Text(
                    text = placeholder,
                    textAlign = textAlign,
                    style = ClinicTheme.typography.paragraphMedium,
                    color = ClinicTheme.colorScheme.foregroundWeak,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            textStyle = textStyle.copy(
                textAlign = textAlign,
                color = textColor,
                ),
            colors = colors,
            shape = shape,
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            enabled = enabled,
            readOnly = readOnly,
            label = label,
            prefix = prefix,
            suffix = suffix,
            supportingText = supportingText,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            maxLines = maxLines,
            minLines = minLines,
            singleLine = singleLine,
            interactionSource = interactionSource

        )
    }
}