package com.smart.clinic.featuers.auth.otp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import clinic.composeapp.generated.resources.Res
import clinic.composeapp.generated.resources.ic_arrow_right
import clinic.composeapp.generated.resources.image_otp
import clinic.composeapp.generated.resources.label_confirm_otp_code
import com.smart.clinic.core.designsystem.component.ClinicOutlineTextFieldWithOuterBorder
import com.smart.clinic.core.designsystem.component.ClinicTopAppBar
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun OtpScreen(navController: NavController) {
    val viewModel = viewModel { OtpViewModel() }
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
fun OtpScreen(viewModel: OtpViewModel, onAction: (OtpAction) -> Unit) {

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
                text = "کد فعال\u200Cسازی به شماره زیر ارسال شد:\u2028\n89***090399",
                style = ClinicTheme.typography.paragraphMedium,
                color = ClinicTheme.colorScheme.foregroundBase,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(24.dp))
            //todo: make another fuc

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val otpBoxWidth = (maxWidth - (16.dp * 2)) / 4 // 4 OTP fields with some padding
                val otpBoxHeight = otpBoxWidth * (.8f)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in 0 until 4) {
                        ClinicOutlineTextFieldWithOuterBorder(
                            modifier = Modifier.size(otpBoxWidth,otpBoxHeight),
                            borderModifier = Modifier.size(otpBoxWidth,otpBoxHeight),
                            value = "5",
                            textAlign = TextAlign.Center,
                            textStyle = ClinicTheme.typography.headingH5,
                            textColor = ClinicTheme.colorScheme.foregroundStrong,
                            maxLines = 1,
                            singleLine = true,
                            shape = RoundedCornerShape(ClinicTheme.shapes.xLarge)
                        ) {

                        }
                    }
                }
            }
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