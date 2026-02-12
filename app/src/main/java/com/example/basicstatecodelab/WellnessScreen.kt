package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier.padding(16.dp)) {
        StatefulCounter()

        val list = wellnessViewModel.tasks
        WellnessTasksList(
            list = list,
            onCloseTask = { task -> wellnessViewModel.removeTask(task) },
            onCheckedTask = { taskId, checked ->
                wellnessViewModel.changeTaskChecked(
                    taskId = taskId,
                    checked = checked
                )
            })
    }
}

@CustomPreview
@Composable
fun WellnessScreenPreview() {
    BasicStateCodelabTheme {
        WellnessScreen()
    }
}