package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import github.kunalgharate.deltafourapp.R
import github.kunalgharate.deltafourapp.ui.theme.topBackground


@Composable
fun CollapseButton(
    buttonText: String,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Transparent)
            .border(1.dp, topBackground)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(1.dp, Color.Black)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.minus_circle_outlined),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = buttonText,
                color = topBackground,
                textAlign = TextAlign.Center
            )
        }
    }
}

