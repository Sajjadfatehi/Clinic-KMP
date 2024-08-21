package com.smart.clinic.featuers.auth.registerTermsAndCondition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import clinic.composeapp.generated.resources.Res
import clinic.composeapp.generated.resources.ic_close
import com.smart.clinic.core.designsystem.component.ClinicTopAppBar
import com.smart.clinic.core.designsystem.theme.ClinicTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreenTermsAndConditionScreen(
    navController: NavController,
    termsAndConditionTitle: String,
    termsAndConditionText: String
) {

    Scaffold(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        containerColor = ClinicTheme.colorScheme.backgroundBase,
        topBar = {
            ClinicTopAppBar(
                title = termsAndConditionTitle,
                navigationIconId = Res.drawable.ic_close,
                onNavigationClick = {
                    navController.navigateUp()
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                text = termsAndConditionText,
                style = ClinicTheme.typography.paragraphMedium,
                color = ClinicTheme.colorScheme.foregroundBase
            )
        }

    }

}