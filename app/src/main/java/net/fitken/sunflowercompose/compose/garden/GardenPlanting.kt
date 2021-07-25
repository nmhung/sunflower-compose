package net.fitken.sunflowercompose.compose.garden

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.android.material.composethemeadapter.MdcTheme
import net.fitken.sunflowercompose.R
import net.fitken.sunflowercompose.data.PlantAndGardenPlantings
import net.fitken.sunflowercompose.viewmodels.PlantAndGardenPlantingsViewModel

@Composable
fun ItemGardenPlanting(item: PlantAndGardenPlantings) {
    val viewModel = PlantAndGardenPlantingsViewModel(item)
    Card(shape = RoundedCornerShape(0.dp,
            dimensionResource(id = R.dimen.button_corner_radius),
            0.dp,
            dimensionResource(id = R.dimen.button_corner_radius)),
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.card_side_margin))) {
        Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                    painter = rememberImagePainter(
                            data = item.plant.imageUrl),
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(id = R.string.a11y_plant_item_image),
                    modifier = Modifier
                            .fillMaxWidth()
                            .size(dimensionResource(id = R.dimen.plant_item_image_height)))

            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.margin_normal)))

            Text(item.plant.name,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.margin_normal)))

            Text(stringResource(id = R.string.plant_date_header),
                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colors.primaryVariant)

            Text(viewModel.plantDateString,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.primaryVariant)

            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.margin_normal)))

            Text(stringResource(id = R.string.watered_date_header),
                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colors.primaryVariant)

            Text(viewModel.waterDateString,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.primaryVariant)


            Text(
                    LocalContext
                            .current
                            .resources
                            .getQuantityString(R.plurals.watering_next,
                                    viewModel.wateringInterval, viewModel.wateringInterval),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.primaryVariant)

            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.margin_normal)))
        }
    }
}

@Preview
@Composable
fun ItemGardenPlantingPreview() {
    MdcTheme {
//        ItemGardenPlanting()
    }
}