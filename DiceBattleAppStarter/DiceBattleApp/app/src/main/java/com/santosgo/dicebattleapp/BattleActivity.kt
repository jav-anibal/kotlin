package com.santosgo.dicebattleapp

import android.content.Intent
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
import com.santosgo.dicebattleapp.ui.components.BattleScreen
import com.santosgo.dicebattleapp.ui.theme.DiceBattleAppTheme

class MainActivity : ComponentActivity() {
  companion object {
    const val WINNER_KEY = "winner"
    const val LOSER_KEY = "loser"  // Cambiado: ahora enviamos perdedor en vez de score
  }

  // Cambiado: ahora recibe ganador y perdedor
  private val goToFinalScreen: (String, String) -> Unit = { winner, loser ->
    val intent = Intent(this, FinalActivity::class.java)
    intent.putExtra(WINNER_KEY, winner)
    intent.putExtra(LOSER_KEY, loser)  // Enviamos el perdedor
    startActivity(intent)
  }

  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DiceBattleAppTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          topBar = { CenterAlignedTopAppBar(title = { Text(text = stringResource(R.string.app_name)) }) }
        ) { innerPadding ->
          BattleScreen(
            Modifier.padding(innerPadding),
            onClickEndGame = goToFinalScreen
          )
        }
      }
    }
  }
}