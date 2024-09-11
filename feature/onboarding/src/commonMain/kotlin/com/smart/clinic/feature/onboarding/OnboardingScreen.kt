package com.smart.clinic.feature.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import clinic.feature.onboarding.generated.resources.Res
import clinic.feature.onboarding.generated.resources.image_onboarding
import com.smart.clinic.core.designsystem.component.ClinicButton
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

const val ONBOARDING_PAGE_COUNT = 3

@Composable
fun OnboardingScreen(navController: NavController) {
    val viewModel = viewModel { OnboardingViewModel() }

    OnboardingScreen(
        viewModel = viewModel
    ) {

    }

    LaunchedEffect(viewModel) {
        viewModel.effect.onEach {

        }.launchIn(this)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(viewModel: OnboardingViewModel, onAction: (OnboardingAction) -> Unit) {

    val viewState by viewModel.state.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    val pagerState = rememberPagerState(pageCount = {
        ONBOARDING_PAGE_COUNT
    })

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OnboardingPager(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            pagerState = pagerState
        )

        PagerIndicator(
            totalDots = ONBOARDING_PAGE_COUNT,
            currentPage = pagerState.currentPage
        )
        ClinicButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = if (pagerState.currentPage == pagerState.pageCount-1) {
                "پایان"
            } else {
                "شروع"
            },
            onClick = {
                if (pagerState.currentPage < pagerState.pageCount-1) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        pageSpacing = 0.dp,
    ) { page ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(Res.drawable.image_onboarding),
                contentDescription = "onboarding image",
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                modifier = Modifier
                    .background(
                        color = ClinicTheme.colorScheme.stateNeutralSubtle,
                        shape = RoundedCornerShape(ClinicTheme.shapes.small)
                    )
                    .padding(8.dp),
                text = "به دنبال پزشک متخصص هستی؟",
                textAlign = TextAlign.Center,
                color = ClinicTheme.colorScheme.stateNeutralBase,
                style = ClinicTheme.typography.labelSmall,

                )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "با کمک بیش از 10,000+ پزشک متخصص، درمان مخصوص خودت رو پیدا می\u200Cکنی",
                textAlign = TextAlign.Center,
                color = ClinicTheme.colorScheme.foregroundStrong,
                style = ClinicTheme.typography.headingH5
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }

}

@Composable
fun PagerIndicator(totalDots: Int, currentPage: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until totalDots) {
            val (color, size) = if (i == currentPage) {
                ClinicTheme.colorScheme.primaryPatientBase to 8.dp
            } else {
                ClinicTheme.colorScheme.foregroundDisable to 6.dp
            }
            Box(
                modifier = Modifier
                    .size(size)
                    .background(color, CircleShape)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}
