package net.fitken.sunflowercompose.compose.garden

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.composethemeadapter.MdcTheme
import net.fitken.sunflowercompose.R
import net.fitken.sunflowercompose.compose.StaggeredVerticalGrid
import net.fitken.sunflowercompose.data.PlantAndGardenPlantings

@Composable
fun GardenEmpty(onAddPlant: () -> Unit) {
    Column(
            Modifier
                    .padding(dimensionResource(id = R.dimen.margin_normal))
                    .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(id = R.string.garden_empty),
                style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(10.dp))
        Button(onClick = onAddPlant,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onPrimary),
                shape = RoundedCornerShape(0.dp,
                        dimensionResource(id = R.dimen.button_corner_radius),
                        0.dp,
                        dimensionResource(id = R.dimen.button_corner_radius))) {
            Text(text = stringResource(id = R.string.add_plant),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.button)
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GardenEmptyPreview() {
    MdcTheme {
        Surface {
            GardenEmpty {}
        }
    }
}

@Composable
fun ListGardenPlanting(items: List<PlantAndGardenPlantings>?) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        StaggeredVerticalGrid(maxColumnWidth = 220.dp,
                modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.card_side_margin))) {
            items?.let { list ->
                list.forEach { item ->
                    ItemGardenPlanting(item)
                }
            }
        }
    }
}

@Preview
@Composable
fun ListGardenPlantingPreview() {
//    ListGardenPlanting()
}