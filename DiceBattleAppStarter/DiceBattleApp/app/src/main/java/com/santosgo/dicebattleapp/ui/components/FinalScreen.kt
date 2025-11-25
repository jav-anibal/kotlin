package com.santosgo.dicebattleapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.santosgo.dicebattleapp.R

@Composable
fun FinalScreen(
  modifier: Modifier = Modifier,
  winner: String = "",
  loser: String = ""  // EJERCICIO 7: Cambiado de score a loser
) {
  Column(
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    // EJERCICIO 7: Mostrar mensaje con ganador y perdedor
    StandardTextComp(
      text = stringResource(R.string.winner_loser, winner, loser)
    )
  }
}