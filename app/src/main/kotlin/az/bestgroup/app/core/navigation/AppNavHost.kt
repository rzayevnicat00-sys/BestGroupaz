package az.bestgroup.app.core.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import az.bestgroup.app.R

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    Scaffold { padding ->
        NavHost(
            navController = navController,
            startDestination = Routes.WELCOME,
            modifier = Modifier.padding(padding)
        ) {
            composable(Routes.WELCOME) {
                PhaseOnePlaceholder(
                    title = stringResource(R.string.welcome_title),
                    subtitle = stringResource(R.string.brand_slogan),
                    note = stringResource(R.string.phase1_foundation),
                    actionLabel = stringResource(R.string.continue_label),
                    onAction = { navController.navigate(Routes.AUTH_GATE) }
                )
            }
            composable(Routes.AUTH_GATE) {
                PhaseOnePlaceholder(
                    title = stringResource(R.string.login) + " / " + stringResource(R.string.register),
                    subtitle = stringResource(R.string.phase1_note),
                    note = "Auth, role routing, and Firebase session integration are planned in Phase 2.",
                    actionLabel = stringResource(R.string.home),
                    onAction = { navController.navigate(Routes.CUSTOMER_HOME) { popUpTo(Routes.WELCOME) { inclusive = false } } }
                )
            }
            composable(Routes.CUSTOMER_HOME) {
                PhaseOnePlaceholder(
                    title = stringResource(R.string.home),
                    subtitle = "Customer experience scaffold (catalog, orders, messages, profile).",
                    note = "No hardcoded production data. Firestore-driven implementation in Phase 3.",
                    actionLabel = "Admin scaffold",
                    onAction = { navController.navigate(Routes.ADMIN_HOME) }
                )
            }
            composable(Routes.ADMIN_HOME) {
                PhaseOnePlaceholder(
                    title = "Admin",
                    subtitle = "Administrator experience scaffold (dashboard, management, communications).",
                    note = "Role-based authorization will be enforced by Firebase Auth + Firestore/Storage rules.",
                    actionLabel = stringResource(R.string.welcome_title),
                    onAction = { navController.popBackStack(Routes.WELCOME, inclusive = false) }
                )
            }
        }
    }
}

@Composable
private fun PhaseOnePlaceholder(
    title: String,
    subtitle: String,
    note: String,
    actionLabel: String,
    onAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center)
        Spacer(Modifier.height(12.dp))
        Text(text = subtitle, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
        Spacer(Modifier.height(12.dp))
        Text(
            text = note,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(24.dp))
        Button(onClick = onAction) { Text(actionLabel) }
    }
}
