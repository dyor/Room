package com.example.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.launch
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.room.data.Golfer
import com.example.room.data.GolferDatabase
import com.example.room.ui.theme.RoomTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            GolferDatabase::class.java,
            "golfer",
        ).build()
        val golferDao = db.golferDao()
        var golfers: List<Golfer> = emptyList()
        lifecycleScope.launch(Dispatchers.IO) {
            golfers = golferDao.getAll()
            if (golfers.size == 0) {
                //seed the database if it is empty
                golfers = listOf(
                    Golfer(name = "Tiger Woods", bumps = 0, wins = 82),
                    Golfer(name = "Jack Nicklaus", bumps = 0, wins = 73),
                    Golfer(name = "Matt Dyor", bumps = 0, wins = 73)
                )
                golferDao.insertAll(golfers)
            }
        }
        enableEdgeToEdge()
        setContent {
            RoomTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Column(modifier = Modifier.padding(16.dp, 64.dp)) {
                        golfers.forEach { golfer ->
                            Text(text = golfer.name, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomTheme {
        Greeting("Android")
    }
}