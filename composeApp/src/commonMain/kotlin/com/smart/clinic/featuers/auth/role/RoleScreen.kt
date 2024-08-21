package com.smart.clinic.featuers.auth.role

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import clinic.composeapp.generated.resources.Res
import clinic.composeapp.generated.resources.ic_arrow_left
import clinic.composeapp.generated.resources.ic_logout
import clinic.composeapp.generated.resources.ic_register_doctor
import clinic.composeapp.generated.resources.ic_register_manager
import clinic.composeapp.generated.resources.ic_register_patient
import clinic.composeapp.generated.resources.label_continue_as_doctor
import clinic.composeapp.generated.resources.label_continue_as_doctor_desc
import clinic.composeapp.generated.resources.label_continue_as_manager
import clinic.composeapp.generated.resources.label_continue_as_manager_desc
import clinic.composeapp.generated.resources.label_continue_as_patient
import clinic.composeapp.generated.resources.label_continue_as_patient_desc
import clinic.composeapp.generated.resources.label_login_to_deep_sense
import clinic.composeapp.generated.resources.label_select_role
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import com.smart.clinic.featuers.auth.register.navigation.REGISTER_ROUTE
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun RoleScreen(navController: NavController) {

    val viewModel = viewModel { RoleViewModel() }
    RoleScreen(viewModel) { action ->
        if (action is RoleAction.RoleCardClicked) {
            navController.navigate("$REGISTER_ROUTE/${action.type.ordinal}")
        } else {
            viewModel.submitAction(action)
        }
    }
}

@Composable
fun RoleScreen(viewModel: RoleViewModel, onAction: (RoleAction) -> Unit) {
    val viewState by viewModel.state.collectAsState()
    RoleScreen(viewState = viewState, onAction = onAction)

    LaunchedEffect(viewModel) {
        viewModel.effect.onEach {

        }.launchIn(this)
    }
}


@Composable
fun RoleScreen(viewState: RoleState, onAction: (RoleAction) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(resource = Res.drawable.ic_logout),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(Res.string.label_login_to_deep_sense),
            style = ClinicTheme.typography.headingH6,
            color = ClinicTheme.colorScheme.foregroundStrong,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(Res.string.label_select_role),
            style = ClinicTheme.typography.paragraphMedium,
            color = ClinicTheme.colorScheme.foregroundSoft,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        RoleCard(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(Res.string.label_continue_as_patient),
            description = stringResource(Res.string.label_continue_as_patient_desc),
            imageRes = Res.drawable.ic_register_patient
        ) {
            onAction(RoleAction.RoleCardClicked(RoleType.PATIENT))
        }
        Spacer(modifier = Modifier.height(16.dp))
        RoleCard(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(Res.string.label_continue_as_doctor),
            description = stringResource(Res.string.label_continue_as_doctor_desc),
            imageRes = Res.drawable.ic_register_doctor
        ) {
            onAction(RoleAction.RoleCardClicked(RoleType.DOCTOR))
        }
        Spacer(modifier = Modifier.height(16.dp))
        RoleCard(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(Res.string.label_continue_as_manager),
            description = stringResource(Res.string.label_continue_as_manager_desc),
            imageRes = Res.drawable.ic_register_manager
        ) {
            onAction(RoleAction.RoleCardClicked(RoleType.MANAGER))
        }
    }

}

@Composable
fun RoleCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    imageRes: DrawableResource,
    onCardClicked: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(ClinicTheme.shapes.medium),
        border = BorderStroke(
            width = ClinicTheme.strokes.base,
            color = ClinicTheme.colorScheme.divider
        ),
        colors = CardDefaults.cardColors(
            containerColor = ClinicTheme.colorScheme.backgroundBase
        ),
        onClick = {
            onCardClicked()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = ClinicTheme.typography.labelMedium,
                    color = ClinicTheme.colorScheme.foregroundStrong
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = description,
                    style = ClinicTheme.typography.paragraphSmall,
                    color = ClinicTheme.colorScheme.foregroundBase
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                modifier = Modifier.padding(8.dp),
                painter = painterResource(Res.drawable.ic_arrow_left),
                contentDescription = null
            )
        }
    }
}
