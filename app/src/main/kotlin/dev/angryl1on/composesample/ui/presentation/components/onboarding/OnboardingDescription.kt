package dev.angryl1on.composesample.ui.presentation.components.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.angryl1on.composesample.ui.theme.LocalDimensions

@Composable
fun OnboardingDescription() {
    val dimensions = LocalDimensions.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimensions.verticalXSmall)
    ) {
        DescriptionItem(
            number = 1,
            text = "The image at the top shows the application logo."
        )
        DescriptionItem(
            number = 2,
            text = "The text displays the user greeting."
        )
        DescriptionItem(
            number = 3,
            text = "The \"Next\" button allows you to go to the login screen without animation."
        )
        Text(
            text = "After successful login, a screen with RecyclerView opens, where chats are displayed with information about the sender, message, and time.",
            fontSize = 16.sp
        )
    }
}

@Composable
fun DescriptionItem(number: Int, text: String) {
    val dimensions = LocalDimensions.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensions.horizontalMedium)
    ) {
        Text(
            text = "$number.",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
    }
}
