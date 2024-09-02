package com.smart.clinic.featuers.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import clinic.composeapp.generated.resources.Res
import clinic.composeapp.generated.resources.and
import clinic.composeapp.generated.resources.ic_add
import clinic.composeapp.generated.resources.ic_arrow_right
import clinic.composeapp.generated.resources.ic_check
import clinic.composeapp.generated.resources.ic_edit
import clinic.composeapp.generated.resources.ic_register_name
import clinic.composeapp.generated.resources.ic_three_stars
import clinic.composeapp.generated.resources.label_create_account
import clinic.composeapp.generated.resources.label_fill_info_desc_doctor
import clinic.composeapp.generated.resources.label_fill_info_desc_patient
import clinic.composeapp.generated.resources.label_full_name
import clinic.composeapp.generated.resources.label_medical_system
import clinic.composeapp.generated.resources.label_register_info
import clinic.composeapp.generated.resources.label_term_condition_first_part
import clinic.composeapp.generated.resources.label_term_condition_fourth_part
import clinic.composeapp.generated.resources.label_term_condition_second_part
import clinic.composeapp.generated.resources.label_term_condition_third_part
import clinic.composeapp.generated.resources.privacy_policy_label
import clinic.composeapp.generated.resources.privacy_policy_value
import clinic.composeapp.generated.resources.profile_unknown
import clinic.composeapp.generated.resources.terms_of_use_label
import clinic.composeapp.generated.resources.terms_of_use_value
import com.smart.clinic.core.ImagePicker
import com.smart.clinic.core.designsystem.component.ClinicOutlineTextFieldWithOuterBorder
import com.smart.clinic.core.designsystem.component.ClinicTopAppBar
import com.smart.clinic.core.designsystem.component.ClinicWithIconButton
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import com.smart.clinic.core.rememberBitmapFromBytes
import com.smart.clinic.featuers.auth.registerTermsAndCondition.navigation.REGISTER_TC_ROUTE
import com.smart.clinic.featuers.auth.role.RoleType
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun RegisterScreen(
    navController: NavController,
    roleType: Int,
    imagePicker: ImagePicker
) {

    val viewModel = viewModel { RegisterViewModel() }
    RegisterScreen(viewModel, roleType, imagePicker) { action ->
        when (action) {
            is RegisterAction.OnNavigateBack -> {
                navController.navigateUp()
            }

            is RegisterAction.OnTermsAndConditionClicked -> {
                navController.navigate("$REGISTER_TC_ROUTE/${action.title}/${action.text}")
            }

            else -> {
                viewModel.submitAction(action)
            }
        }
    }
    imagePicker.registerPicker {
        viewModel.submitAction(RegisterAction.OnImageSelected(it))
    }
}

@Composable
internal fun RegisterScreen(
    viewModel: RegisterViewModel,
    roleType: Int,
    imagePicker: ImagePicker,
    onAction: (RegisterAction) -> Unit
) {
    val viewState by viewModel.state.collectAsState()
    RegisterScreen(
        viewState = viewState,
        roleType = roleType,
        imagePicker = imagePicker,
        onAction = onAction
    )

    LaunchedEffect(viewModel) {
        viewModel.effect.onEach {

        }.launchIn(this)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RegisterScreen(
    viewState: RegisterState,
    roleType: Int,
    imagePicker: ImagePicker,
    onAction: (RegisterAction) -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        containerColor = ClinicTheme.colorScheme.backgroundBase,
        topBar = {
            ClinicTopAppBar(
                title = stringResource(Res.string.label_create_account),
                navigationIconId = Res.drawable.ic_arrow_right,
                onNavigationClick = {
                    onAction(RegisterAction.OnNavigateBack)
                }
            )
        }
    ) { padding ->
        val isPatient = RoleType.PATIENT.ordinal == roleType
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfilePicturePicker(
                modifier = Modifier.padding(24.dp),
                image = viewState.image
            ) {
                imagePicker.pickImage()
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(
                    if (isPatient) {
                        Res.string.label_fill_info_desc_patient
                    } else {
                        Res.string.label_fill_info_desc_doctor
                    }
                ),
                style = ClinicTheme.typography.paragraphMedium,
                color = ClinicTheme.colorScheme.foregroundSoft
            )

            Spacer(modifier = Modifier.height(16.dp))

            ClinicOutlineTextFieldWithOuterBorder(
                modifier = Modifier.fillMaxWidth(),
                borderModifier = Modifier.fillMaxWidth(),
                value = viewState.fullName,
                placeholder = stringResource(Res.string.label_full_name),
                textAlign = TextAlign.Start,
                leadingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_register_name),
                        contentDescription = "Search icon"
                    )
                }
            ) { fullName ->
                onAction(RegisterAction.OnFullNameChanged(fullName))
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isPatient.not()) {
                Spacer(modifier = Modifier.height(16.dp))
                ClinicOutlineTextFieldWithOuterBorder(
                    modifier = Modifier.fillMaxWidth(),
                    borderModifier = Modifier.fillMaxWidth(),
                    value = viewState.medicalNumber.orEmpty(),
                    placeholder = stringResource(Res.string.label_medical_system),
                    textAlign = TextAlign.Start,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(Res.drawable.ic_three_stars),
                            contentDescription = "Search icon"
                        )
                    }
                ) { medicalNumber ->
                    onAction(RegisterAction.OnMedicalNumberChanged(medicalNumber))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            RegisterButton(
                modifier = Modifier,
                isPatient = isPatient,
                isRegisterButtonEnabled = viewState.isRegisterButtonEnabled
            ) {
                onAction(RegisterAction.OnRegisterInfoButtonClicked)
            }

            Spacer(modifier = Modifier.height(32.dp))

            val termOfUseTitle = stringResource(Res.string.terms_of_use_label)
            val termOfUseText = stringResource(Res.string.terms_of_use_value)
            val privacyPolicyTitle = stringResource(Res.string.privacy_policy_label)
            val privacyPolicyText = stringResource(Res.string.privacy_policy_value)
            TermsAndConditionsText(
                modifier = Modifier,
                onTermsClicked = {
                    onAction(
                        RegisterAction.OnTermsAndConditionClicked(
                            title = termOfUseTitle,
                            text = termOfUseText
                        )
                    )
                },
                onPrivacyClicked = {
                    onAction(
                        RegisterAction.OnTermsAndConditionClicked(
                            title = privacyPolicyTitle,
                            text = privacyPolicyText
                        )
                    )
                }
            )
        }

    }

}

@Composable
fun RegisterButton(
    modifier: Modifier = Modifier,
    isPatient: Boolean,
    isRegisterButtonEnabled: Boolean,
    onClick: () -> Unit
) {
    ClinicWithIconButton(
        modifier = modifier,
        text = stringResource(Res.string.label_register_info),
        iconRes = Res.drawable.ic_check,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPatient) {
                ClinicTheme.colorScheme.primaryPatientBase
            } else {
                ClinicTheme.colorScheme.primaryDoctorBase
            },
            contentColor = ClinicTheme.colorScheme.textWhite,
            disabledContainerColor = ClinicTheme.colorScheme.backgroundDisabled,
            disabledContentColor = ClinicTheme.colorScheme.foregroundDisable
        ),
        enabled = /*isRegisterButtonEnabled*/true,
        onClick = onClick
    )
}

@Composable
fun TermsAndConditionsText(
    modifier: Modifier = Modifier,
    onTermsClicked: () -> Unit,
    onPrivacyClicked: () -> Unit
) {
    val termConditionFirstPart =
        stringResource(Res.string.label_term_condition_first_part).plus(" ")
    val termConditionSecondPart =
        stringResource(Res.string.label_term_condition_second_part).plus(" ")
    val termConditionThirdPart =
        stringResource(Res.string.label_term_condition_third_part).plus(" ")
    val termConditionFourthPart = stringResource(Res.string.label_term_condition_fourth_part)

    val annotatedText = buildAnnotatedString {
        append(termConditionFirstPart)

        pushStringAnnotation(tag = "TERMS", annotation = "terms")
        withStyle(
            style = ClinicTheme.typography.labelSmall.toSpanStyle()
                .copy(color = ClinicTheme.colorScheme.foregroundStrong)
        ) {
            append(termConditionSecondPart)
        }
        pop()

        append(stringResource(Res.string.and).plus(" "))

        pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
        withStyle(
            style = ClinicTheme.typography.labelSmall.toSpanStyle()
                .copy(color = ClinicTheme.colorScheme.foregroundStrong)
        ) {
            append(termConditionThirdPart)
        }
        pop()

        append(termConditionFourthPart)
    }

    ClickableText(
        text = annotatedText,
        modifier = modifier,
        style = ClinicTheme.typography.paragraphSmall.copy(
            color = ClinicTheme.colorScheme.foregroundSoft,
            textAlign = TextAlign.Center
        ),
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "TERMS", start = offset, end = offset)
                .firstOrNull()?.let {
                    onTermsClicked()
                }
            annotatedText.getStringAnnotations(tag = "PRIVACY", start = offset, end = offset)
                .firstOrNull()?.let {
                    onPrivacyClicked()
                }
        }
    )
}

@Composable
fun ProfilePicturePicker(
    modifier: Modifier = Modifier,
    image: ByteArray?,
    onImageClicked: () -> Unit
) {
    val bitmap = rememberBitmapFromBytes(image)
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = modifier
            .size(80.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onImageClicked.invoke()
            }
    ) {
        if (bitmap != null) {
            Image(
                bitmap = bitmap,
                contentDescription = "Default Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        } else {
            Image(
                painter = painterResource(Res.drawable.profile_unknown),
                contentDescription = "Default Profile Picture",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }
        Icon(
            imageVector = if (bitmap == null) {
                vectorResource(Res.drawable.ic_add)
            } else {
                vectorResource(Res.drawable.ic_edit)
            },
            contentDescription = "select image icon",
            modifier = Modifier
                .size(24.dp)
                .background(
                    color = ClinicTheme.colorScheme.backgroundInverse,
                    shape = RoundedCornerShape(ClinicTheme.shapes.xSmall)
                )
                .padding(6.dp)
                .align(Alignment.BottomStart),
            tint = Color.White
        )
    }
}
