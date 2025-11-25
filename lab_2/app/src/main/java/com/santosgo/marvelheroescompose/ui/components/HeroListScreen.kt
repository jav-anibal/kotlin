import android.graphics.Paint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santosgo.marvelheroescompose.model.Hero
import com.santosgo.marvelheroescompose.ui.components.ImageComp
import com.santosgo.marvelheroescompose.ui.components.StandardTextComp
import com.santosgo.mavelheroes.data.Datasource

@Composable
fun HeroListScreen(heroes: MutableList<Hero>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            shadowElevation = 2.dp,
            shape = MaterialTheme.shapes.medium,
            color = Color.Red
        ) {
            StandardTextComp(
//                text = stringResource(R.string.marvel_hero_list),
                text = "Lista de superheroes",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }

        LazyColumn(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            items(heroes) { hero ->
                Card(
                    modifier= Modifier
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                        .fillMaxSize()
                        .height(100.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    HeroCard(hero)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HeroListScreenPreview() {
    HeroListScreen(Datasource.heroList())
}

@Composable
fun HeroCard(hero: Hero){
    Card(
        modifier= Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .fillMaxSize()
            .height(100.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row {
            Column {
                ImageComp(
                    modifier = Modifier,
                    drawable = Datasource.getDrawableIdByName(hero.photo),
                    height = 100,
                    width = 100
                );
            }
            Column(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),) {
                StandardTextComp(
                    text = hero.name,

                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                StandardTextComp(
                    text = "Poder: "+hero.power,
                )
                StandardTextComp(
                    text = "Inteligencia: "+hero.intelligence,
                )
            }
            IconButton(
                onClick = { /* Acción futura, como mostrar más información del héroe */ },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.TwoTone.KeyboardArrowDown,
                    //painter = painterResource(R.drawable.remove_24px), //Icono descargado de Icons de Material.
                    modifier = Modifier.size(48.dp),
                    contentDescription = Text("asd").toString(),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}