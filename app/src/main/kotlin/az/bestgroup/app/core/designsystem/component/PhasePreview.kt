package az.bestgroup.app.core.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import az.bestgroup.app.core.designsystem.theme.BestGroupTheme
import az.bestgroup.app.core.navigation.AppNavHost

@Preview(showBackground = true, name = "BestGroup.az - Phase 1")
@Composable
fun BestGroupPhase1Preview() {
    BestGroupTheme {
        AppNavHost()
    }
}
