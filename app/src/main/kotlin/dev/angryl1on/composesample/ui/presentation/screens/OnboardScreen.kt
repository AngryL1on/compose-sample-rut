package dev.angryl1on.composesample.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.angryl1on.composesample.R
import dev.angryl1on.composesample.ui.presentation.components.onboarding.OnboardingDescription
import dev.angryl1on.composesample.ui.theme.LocalDimensions

@Composable
fun OnboardScreen(
    onNextClick: () -> Unit
) {
    val dimensions = LocalDimensions.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.app_logo),
            modifier = Modifier.size(dimensions.defaultLogoSize)
        )

        Spacer(modifier = Modifier.height(dimensions.verticalMedium))

        Text(
            text = stringResource(id = R.string.description_of_functionality),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(dimensions.verticalXSmall))

        OnboardingDescription()

        Spacer(modifier = Modifier.height(dimensions.verticalMedium))

        Button(
            onClick = onNextClick
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}

@Composable
@Preview
fun OnboardScreenPreview() {
    OnboardScreen(
        onNextClick = {
            // do nothing
        }
    )
}
