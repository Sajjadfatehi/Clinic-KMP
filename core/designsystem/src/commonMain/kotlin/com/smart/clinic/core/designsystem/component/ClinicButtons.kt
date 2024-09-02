package com.smart.clinic.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ClinicButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = ClinicTheme.typography.subHeadingMedium,
    textAlign: TextAlign = TextAlign.Center,
    shape: Shape = RoundedCornerShape(ClinicTheme.shapes.medium),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = ClinicTheme.colorScheme.primaryPatientBase,
        contentColor = ClinicTheme.colorScheme.textWhite,
        disabledContainerColor = ClinicTheme.colorScheme.backgroundDisabled,
        disabledContentColor = ClinicTheme.colorScheme.foregroundDisable
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit = {
        Text(
            modifier = Modifier.padding(4.dp),
            text = text,
            style = textStyle,
            textAlign = textAlign,
        )
    }
) {
    Button(
        modifier = modifier,
        shape = shape,
        colors = colors,
        enabled = enabled,
        onClick = onClick,
        content = content
    )
}

@Composable
fun ClinicWithIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = ClinicTheme.typography.subHeadingMedium,
    textAlign: TextAlign = TextAlign.Center,
    iconRes: DrawableResource,
    iconDescription: String? = null,
    shape: Shape = RoundedCornerShape(ClinicTheme.shapes.medium),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = ClinicTheme.colorScheme.primaryPatientBase,
        contentColor = ClinicTheme.colorScheme.textWhite,
        disabledContainerColor = ClinicTheme.colorScheme.backgroundDisabled,
        disabledContentColor = ClinicTheme.colorScheme.foregroundDisable
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit = {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = vectorResource(resource = iconRes),
            contentDescription = iconDescription,
            modifier = Modifier.padding(4.dp)

        )
        Text(
            modifier = Modifier.padding(4.dp),
            text = text,
            style = textStyle,
            textAlign = textAlign,
        )
        Spacer(modifier = Modifier.weight(1f))
    }
) {
    Button(
        modifier = modifier,
        shape = shape,
        colors = colors,
        enabled = enabled,
        onClick = onClick,
        content = content
    )
}