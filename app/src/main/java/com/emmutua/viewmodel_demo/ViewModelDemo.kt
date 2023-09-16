package com.emmutua.viewmodel_demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ViewModel_Demo_App(
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    val uiState = viewModel.uiState.collectAsState().value
    CalculatorLayout(
        number1 = uiState.number1,
        number2 = uiState.number2,
        uiState = uiState,
        onNumberOneChange = { viewModel.updateNumOne(it) },
        onNumberTwoChange = { viewModel.updateNumTwo(it) },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorLayout(
    number1: String,
    number2: String,
    uiState: UiState,
    onNumberOneChange: (String) -> Unit,
    onNumberTwoChange: (String) -> Unit,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = number1,
            label = { Text(text = "Num 1") },
            onValueChange = onNumberOneChange,
        )
        OutlinedTextField(
            value = number2,
            label = { Text(text = "Num 2") },
            onValueChange = onNumberTwoChange,
        )
        Button(onClick = {
            viewModel.findSum()
        }) {
            Text(text = "Output")
        }
        Text(text = "${uiState.output}")
    }
}
