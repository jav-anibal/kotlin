package com.santosgo.dicebattleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.santosgo.dicebattleapp.ui.components.FinalScreen
import com.santosgo.dicebattleapp.ui.theme.DiceBattleAppTheme

class FinalActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    // Recibimos ganador y perdedor en vez de ganador y score
    val winner = intent.getStringExtra(MainActivity.WINNER_KEY) ?: ""
    val loser = intent.getStringExtra(MainActivity.LOSER_KEY) ?: ""

    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DiceBattleAppTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          topBar = { CenterAlignedTopAppBar(title = { Text(text = stringResource(R.string.final_result)) }) }
        ) { innerPadding ->
          FinalScreen(
            Modifier.padding(innerPadding),
            winner = winner,
            loser = loser  // Pasamos el perdedor
          )
        }
      }
    }
  }
}