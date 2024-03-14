package ua.edu.lntu.cw_4

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw_4.ui.theme.IPZ_CW_4_Zhuk_IlliaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_4_Zhuk_IlliaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskApp()
                }
            }
        }
    }
}

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val status: TaskStatus
)

enum class TaskStatus {
    ACTIVE,
    DONE
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskListScreen(tasks: List<Task>, onTaskClick: (Task) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Task List") }
            )
        }
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(60.dp))
            }

            items(tasks) { task ->
                TaskListItem(task = task, onTaskClick = onTaskClick)
            }
        }
    }
}

@Composable
fun TaskApp() {
    val tasks = remember { mutableStateListOf(
        Task(1, "Task 1", "Description 1", "2024-03-15", TaskStatus.DONE),
        Task(2, "Task 2", "Description 2", "2024-03-16", TaskStatus.DONE),
        Task(3, "Task 3", "Description 3", "2024-03-17", TaskStatus.ACTIVE),
        Task(4, "Task 4", "Description 4", "2024-03-18", TaskStatus.ACTIVE),
        Task(5, "Task 5", "Description 5", "2024-03-19", TaskStatus.ACTIVE)
    ) }

    var currentScreen by remember { mutableStateOf("TaskList") }
    var selectedTask by remember { mutableStateOf<Task?>(null) }

}