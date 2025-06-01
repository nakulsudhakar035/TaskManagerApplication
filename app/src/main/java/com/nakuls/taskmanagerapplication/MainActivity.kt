package com.nakuls.taskmanagerapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nakuls.taskmanagerapplication.ui.theme.TaskManagerApplicationTheme
import com.nakuls.taskmanagerapplication.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerApplicationTheme {
                Surface {
                    ShowTaskStatus()
                }
            }
        }
    }
}

@Composable
fun TaskCompletedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center), // Center entire column
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null,
            tint = Color.Unspecified // Use original icon colors
        )
        Text(
            text = stringResource(R.string.status),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.comment),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ShowTaskStatus(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShowStatusIcon()
        ShowStatusMessage()
    }
}

@Composable
fun ShowStatusIcon(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Icon(
        image,
        null,
        tint = Color.Unspecified
    )
}

@Composable
fun ShowStatusMessage(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(R.string.status),
            modifier = modifier
                .padding(
                    top = 16.dp,
                    bottom = 8.dp
                ),
            style = Typography.bodyLarge
        )
        Text(
            text = stringResource(R.string.comment),
            style = Typography.bodyMedium,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletedScreenPreview() {
    TaskManagerApplicationTheme {
        TaskCompletedScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ShowTaskStatusPreview() {
    TaskManagerApplicationTheme {
        ShowTaskStatus()
    }
}