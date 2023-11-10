package github.kunalgharate.deltafourapp.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import github.kunalgharate.deltafourapp.ui.theme.lightGreyTitle


@Composable
fun titleTextView(title:String)
{
    Text(
        text = title,
        color = lightGreyTitle,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}