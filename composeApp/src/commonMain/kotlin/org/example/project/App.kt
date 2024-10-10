package org.example.project


import androidx.compose.runtime.*

import org.jetbrains.compose.ui.tooling.preview.Preview

import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel
import org.example.project.data.ExpenseManager
import org.example.project.data.ExpenseRepoImpl
import org.example.project.presentacion.ExpenseUiState
import org.example.project.presentacion.ExpenseViewModel
import org.example.project.ui.ExpensesScreen

@Composable
@Preview
fun App() {
    PreComposeApp {
        val colors = getColorsTheme()
        val viewModel = viewModel(modelClass = ExpenseViewModel::class) {
            ExpenseViewModel(ExpenseRepoImpl(ExpenseManager))
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        AppTheme {
            ExpensesScreen(
                uiState = uiState,
                onExpenseClick = { })
            /**
            var showContent by remember { mutableStateOf(false) }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
            Text("Click me!")
            }
            }
             **/
        }
    }
}
