package com.santosgo.dicebattleapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.santosgo.dicebattleapp.R

@Composable
fun BattleScreen(modifier: Modifier = Modifier, onClickEndGame: (String, String) -> Unit) {

  // EJERCICIO 2: Variables de estado para jugador 1
  var player1 by rememberSaveable { mutableStateOf("") }
  var num1 by rememberSaveable { mutableIntStateOf(0) }
  var wins1 by rememberSaveable { mutableIntStateOf(0) }
  var player1HasThrown by rememberSaveable { mutableStateOf(false) }

  // EJERCICIO 2: Variables de estado para jugador 2
  var player2 by rememberSaveable { mutableStateOf("") }
  var num2 by rememberSaveable { mutableIntStateOf(0) }
  var wins2 by rememberSaveable { mutableIntStateOf(0) }
  var player2HasThrown by rememberSaveable { mutableStateOf(false) }

  // EJERCICIO 5: Función que gestiona el cambio de ronda
  val onNextRound: () -> Unit = {
    // Comparar resultados y asignar victoria
    if (num1 > num2) {
      wins1++  // Gana jugador 1
    } else if (num2 > num1) {
      wins2++  // Gana jugador 2
    }
    // Si empatan no suma nadie

    // Reset para nueva ronda
    player1HasThrown = false
    player2HasThrown = false

    // EJERCICIO 6: Comprobar si alguien ganó 3 rondas
    if (wins1 == 3) {
      onClickEndGame(player1, player2)  // player1 gana, player2 pierde
    } else if (wins2 == 3) {
      onClickEndGame(player2, player1)  // player2 gana, player1 pierde
    }
  }

  // EJERCICIO 3: Función para cambiar nombre del jugador
  val onPlayerNameChange: (Int, String) -> Unit = { playerIndex, name ->
    if (playerIndex == 1) {
      player1 = name
    } else {
      player2 = name
    }
  }

  // EJERCICIO 4: Función para lanzar dado
  val onThrowDice: (Int) -> Unit = { playerIndex ->
    // Generar número aleatorio del 1 al 6
    val randomNum = (1..6).random()

    // Asignar resultado según jugador
    if (playerIndex == 1) {
      num1 = randomNum
      player1HasThrown = true
    } else {
      num2 = randomNum
      player2HasThrown = true
    }

    // Si ambos han lanzado, pasar a siguiente ronda
    if (player1HasThrown && player2HasThrown) {
      onNextRound()
    }
  }

  // EJERCICIO 2: UI principal - Fila con dos jugadores y divisor
  Row(
    modifier = modifier.fillMaxSize(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
  ) {
    // Jugador 1
    PlayerDisplay(
      playerIndex = 1,
      label = stringResource(R.string.player_1),
      playerName = player1,
      onPlayerNameChange = onPlayerNameChange,
      diceNum = num1,
      onThrowDice = onThrowDice,
      wins = wins1,
      enabled = !player1HasThrown && player1.isNotEmpty()
    )

    // Divisor vertical entre jugadores
    VerticalDivider(
      modifier = Modifier.fillMaxHeight(),
      thickness = 2.dp
    )

    // Jugador 2
    PlayerDisplay(
      playerIndex = 2,
      label = "Jugador 2",
      playerName = player2,
      onPlayerNameChange = onPlayerNameChange,
      diceNum = num2,
      onThrowDice = onThrowDice,
      wins = wins2,
      enabled = !player2HasThrown && player2.isNotEmpty()
    )
  }
}

// EJERCICIO 1: Nueva función que representa la UI de un jugador
@Composable
fun PlayerDisplay(
  playerIndex: Int,
  label: String,
  playerName: String,
  onPlayerNameChange: (Int, String) -> Unit,
  diceNum: Int,
  onThrowDice: (Int) -> Unit,
  wins: Int,
  enabled: Boolean
) {
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Campo de texto para el nombre
    Row(
      Modifier.weight(2f),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      StandardInputTextComp(
        label = label,
        value = playerName,
        onValueChange = { onPlayerNameChange(playerIndex, it) }
      )
    }

    // Dado
    Row(
      Modifier.weight(4f),
      verticalAlignment = Alignment.CenterVertically
    ) {
      DiceComp(num = diceNum)
    }

    // Botón lanzar
    Row(
      Modifier.weight(2f),
      verticalAlignment = Alignment.CenterVertically
    ) {
      StandardButtonComp(
        label = stringResource(R.string.throw_dice),
        enabled = enabled,
        onClick = { onThrowDice(playerIndex) }
      )
    }

    // Resultados (resultado y rondas ganadas)
    Row(
      Modifier.weight(2f),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center
    ) {
      if (diceNum != 0) {
        Column {
          LabelAndValueComp(
            label = stringResource(R.string.result),
            value = diceNum.toString()
          )
          // EJERCICIO 1: Cambiado de "Total" a "Rondas ganadas"
          LabelAndValueComp(
            label = "Rondas ganadas:",
            value = wins.toString()
          )
        }
      }
    }
  }
}
