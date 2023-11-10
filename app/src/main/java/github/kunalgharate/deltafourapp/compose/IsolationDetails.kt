package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import github.kunalgharate.deltafourapp.ui.theme.lightGreyTitle


@Composable
fun IsolationDetailPage()
{
   Column {
       dropDownMenu("Select Isolation Point(s)")
       Text(
           modifier = Modifier.padding(10.dp),
           text = "Add ISolation Issuer(S)", color = lightGreyTitle,
           fontWeight = FontWeight.Bold,
           fontSize = 15.sp
       )
       dropDownWithImageView("Isolation officer")
   }



}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewIsolationDetailPage()
{
    IsolationDetailPage()

}