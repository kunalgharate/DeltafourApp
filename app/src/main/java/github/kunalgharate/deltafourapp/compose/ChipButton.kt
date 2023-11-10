package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import github.kunalgharate.deltafourapp.R
import github.kunalgharate.deltafourapp.ui.theme.lightWhite
import github.kunalgharate.deltafourapp.ui.theme.topBackground


@Composable
fun ChipButton(
    buttonText: String,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .wrapContentSize()
            .border(1.dp, lightWhite)
            .background(color = lightWhite)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(1.dp, Color.LightGray)
                .padding(8.dp)

        ) {

            Text(
                text = buttonText,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
               Icons.Default.Close,
                contentDescription = "",

            )

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewChipButton()
{
    ChipButton(buttonText = "Hot Work") {
        
    }
}