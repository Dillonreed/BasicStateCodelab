package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private var _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks


    fun changeTaskChecked(taskId: Int, checked: Boolean) =
        _tasks.find { it.id == taskId }?.let { task -> task.checked = checked }

    fun removeTask(task: WellnessTask) = _tasks.remove(task)

    private fun getWellnessTasks() = List(30) { ndx ->
        WellnessTask(
            id = ndx,
            label = "Task # $ndx"
        )
    }
}