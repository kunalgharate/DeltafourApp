package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import github.kunalgharate.deltafourapp.ui.theme.lightGreyTitle


@Composable
fun subTitle(title:String,subTitle:String,fontSize:TextUnit,modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title, color = lightGreyTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = subTitle, color = lightGreyTitle,
            fontWeight = FontWeight.Normal,
            maxLines = 1,
            fontSize = fontSize
        )
    }
}