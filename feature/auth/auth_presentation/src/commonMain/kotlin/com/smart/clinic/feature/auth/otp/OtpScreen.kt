package com.smart.clinic.feature.auth.otp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import clinic.feature.auth.auth_presentation.generated.resources.Res
import clinic.feature.auth.auth_presentation.generated.resources.ic_arrow_right
import clinic.feature.auth.auth_presentation.generated.resources.image_otp
import clinic.feature.auth.auth_presentation.generated.resources.label_confirm_otp_code
import com.smart.clinic.core.designsystem.component.ClinicOutlineTextFieldWithOuterBorder
import com.smart.clinic.core.designsystem.component.ClinicTopAppBar
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

const val OTP_TEXT_FIELD_MAX_LENGTH = 1
const val OTP_LENGTH = 4

@Composable
fun OtpScreen(navController: NavController) {
//    val viewModel = viewModel { OtpViewModel() }
    val viewModel: OtpViewModel = koinViewModel()
    OtpScreen(viewModel) { action ->
        when (action) {
            OtpAction.OnNavigateBack -> {
                navController.navigateUp()
            }

            else -> {
                viewModel.submitAction(action)
            }
        }
    }
}

@Composable
fun OtpScreen(viewModel: OtpViewModel = koinViewModel(), onAction: (OtpAction) -> Unit) {

    val viewState by viewModel.state.collectAsState()
    OtpScreen(viewState, onAction)


    LaunchedEffect(viewModel) {
        viewModel.effect.onEach {

        }.launchIn(this)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(viewState: OtpState, onAction: (OtpAction) -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        containerColor = ClinicTheme.colorScheme.backgroundBase,
        topBar = {
            ClinicTopAppBar(
                title = stringResource(Res.string.label_confirm_otp_code),
                navigationIconId = Res.drawable.ic_arrow_right,
                onNavigationClick = {
                    onAction(OtpAction.OnNavigateBack)
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(resource = Res.drawable.image_otp),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
//                text = "کد فعال\u200Cسازی به شماره زیر ارسال شد:\u2028\n89***090399",
                text = viewState.desc,
                style = ClinicTheme.typography.paragraphMedium,
                color = ClinicTheme.colorScheme.foregroundBase,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(24.dp))

            OtpFields(
                modifier = Modifier,
                otp = viewState.otp,
                onAction = onAction
            )

            Spacer(modifier = Modifier.height(24.dp))

            val enable = false
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                },
                shape = RoundedCornerShape(ClinicTheme.shapes.medium),
                enabled = enable,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ClinicTheme.colorScheme.backgroundBase,
                    contentColor = ClinicTheme.colorScheme.foregroundStrong,
                    disabledContainerColor = ClinicTheme.colorScheme.backgroundDisabled,
                    disabledContentColor = ClinicTheme.colorScheme.foregroundDisable
                ),
                border = BorderStroke(
                    color = if (enable) ClinicTheme.colorScheme.divider
                    else ClinicTheme.colorScheme.backgroundDisabled,
                    width = ClinicTheme.strokes.base
                ),

                ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "ارسال مجدد",
                    textAlign = TextAlign.Center,
                    style = ClinicTheme.typography.labelMedium,
                )
            }
        }


    }
}

@Composable
fun OtpFields(
    modifier: Modifier = Modifier,
    otp: List<String>,
    onAction: (OtpAction) -> Unit
) {
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Ltr
    ) {
        BoxWithConstraints(
            modifier = modifier
                .fillMaxWidth()
        ) {
            val otpBoxWidth = (maxWidth - (16.dp * 2)) / OTP_LENGTH
            val otpBoxHeight = otpBoxWidth * (.8f)
            val focusRequesters = remember { List(OTP_LENGTH) { FocusRequester() } }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (index in 0 until OTP_LENGTH) {
                    ClinicOutlineTextFieldWithOuterBorder(
                        modifier = Modifier
                            .size(otpBoxWidth, otpBoxHeight)
                            .focusRequester(focusRequesters[index]),
                        borderModifier = Modifier.size(otpBoxWidth, otpBoxHeight),
                        value = otp[index],
                        textAlign = TextAlign.Center,
                        textStyle = ClinicTheme.typography.headingH5,
                        textColor = ClinicTheme.colorScheme.foregroundStrong,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        shape = RoundedCornerShape(ClinicTheme.shapes.xLarge)
                    ) { newValue ->
                        if (newValue.length <= OTP_TEXT_FIELD_MAX_LENGTH && newValue.all { it.isDigit() }) {
                            val updatedOtpValues = otp.toMutableList()
                            updatedOtpValues[index] = newValue
                            onAction(OtpAction.OnOtpChanged(updatedOtpValues))

                            // Move focus to next TextField when a digit is entered
                            if (newValue.isNotEmpty() && index < OTP_LENGTH - 1) {
                                focusRequesters[index + 1].requestFocus()
                            }

                            // Call the callback when OTP is complete
                            if (updatedOtpValues.all { it.isNotEmpty() }) {
                                onAction(
                                    OtpAction.OnOtpCompleted(
                                        updatedOtpValues.joinToString("")
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}