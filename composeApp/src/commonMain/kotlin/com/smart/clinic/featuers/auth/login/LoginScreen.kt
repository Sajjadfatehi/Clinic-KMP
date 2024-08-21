package com.smart.clinic.featuers.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import clinic.composeapp.generated.resources.Res
import clinic.composeapp.generated.resources.ic_phone
import clinic.composeapp.generated.resources.label_enter_by_phone_number
import clinic.composeapp.generated.resources.label_send_confirmation_code
import clinic.composeapp.generated.resources.label_welcome
import clinic.composeapp.generated.resources.login_image
import com.smart.clinic.core.designsystem.component.ClinicOutlineTextFieldWithOuterBorder
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import com.smart.clinic.featuers.auth.otp.navigation.OTP_ROUTE
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(navController: NavController) {

    val viewModel = viewModel { LoginViewModel() }
    LoginScreen(viewModel) { action ->
        if (action is LoginAction.OnSendOtpClicked) {
            navController.navigate(OTP_ROUTE)
        } else {
            viewModel.submitAction(action)
        }
    }
}

@Composable
fun LoginScreen(viewModel: LoginViewModel, onAction: (LoginAction) -> Unit) {
    val viewState by viewModel.state.collectAsState()
    LoginScreen(viewState = viewState, onAction = onAction)

    LaunchedEffect(viewModel) {
        viewModel.effect.onEach {

        }.launchIn(this)
    }
}


@Composable
fun LoginScreen(viewState: LoginState, onAction: (LoginAction) -> Unit) {

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(resource = Res.drawable.login_image),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(Res.string.label_welcome),
            style = ClinicTheme.typography.headingH6,
            color = ClinicTheme.colorScheme.foregroundStrong
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(Res.string.label_enter_by_phone_number),
            style = ClinicTheme.typography.paragraphMedium,
            color = ClinicTheme.colorScheme.foregroundBase
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(thickness = ClinicTheme.strokes.base)
        Spacer(modifier = Modifier.height(16.dp))
        ClinicOutlineTextFieldWithOuterBorder(
            modifier = Modifier.fillMaxWidth(),
            borderModifier = Modifier.fillMaxWidth(),
            value = viewState.phoneNumber,
            placeholder = "0912000000",
            trailingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.ic_phone),
                    contentDescription = "Search icon"
                )
            }
        ) {
            onAction(LoginAction.OnPhoneNumberChanges(it))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier,
            shape = RoundedCornerShape(ClinicTheme.shapes.medium),
            colors = ButtonDefaults.buttonColors(
                containerColor = ClinicTheme.colorScheme.primaryPatientBase,
            ),
            onClick = {
                onAction(LoginAction.OnSendOtpClicked)
            }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(4.dp),
                text = stringResource(Res.string.label_send_confirmation_code),
                style = ClinicTheme.typography.subHeadingMedium,
                textAlign = TextAlign.Center,
                color = ClinicTheme.colorScheme.textWhite
            )
        }
    }
}

