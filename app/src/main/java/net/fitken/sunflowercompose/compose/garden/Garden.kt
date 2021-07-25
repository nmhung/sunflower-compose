package net.fitken.sunflowercompose.compose.garden

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.composethemeadapter.MdcTheme
import net.fitken.sunflowercompose.R

@Composable
fun GardenEmpty(onAddPlant: () -> Unit) {
    Column(
            Modifier.padding(dimensionResource(id = R.dimen.margin_normal))
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
                    color = MaterialTheme.colors.primary)
        }
    }
}

@Preview
@Composable
fun GardenEmptyPreview() {
    MdcTheme {
        GardenEmpty {}
    }
}