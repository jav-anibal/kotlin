package com.santosgo.marvelheroescompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.santosgo.marvelheroescompose.R
import com.santosgo.marvelheroescompose.model.Hero
import com.santosgo.marvelheroescompose.ui.components.HeroCard
import com.santosgo.marvelheroescompose.ui.components.HeroCardLand
import com.santosgo.marvelheroescompose.ui.components.MedHeaderComp

@Composable
fun HeroListCompactScreen(heroes: MutableList<Hero>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        MedHeaderComp(title = stringResource(id = R.string.marvel_hero_list))
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            items(heroes) { hero ->
                HeroCard(hero)
            }
        }
    }
}

@Composable
fun HeroListMedExpScreen(heroes: MutableList<Hero>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        MedHeaderComp(title = stringResource(id = R.string.marvel_hero_list))
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            items(heroes) { hero ->
                HeroCardLand(hero)
            }
        }
    }
}
