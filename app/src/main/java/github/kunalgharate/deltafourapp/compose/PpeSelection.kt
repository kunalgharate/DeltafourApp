package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PpeSelectionView()
{
   Column {
       Row (horizontalArrangement = Arrangement.SpaceBetween){
           checkBoxComposeView(title = "Sefety Glasses", textColor = Color.Black,15.sp)
           checkBoxComposeView(title = "Barricades", textColor = Color.Black,15.sp)
       }
       checkBoxComposeView(title = "Isolation Required", textColor = Color.Red,20.sp)
       subTitle(title = "Location of Isolation", subTitle = "(Tick all applicable fields)", fontSize = 10.sp, modifier = Modifier.padding(all = 10.dp))
       dropDownMenu("Equipment")
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewPpeSelectionView()
{
    PpeSelectionView()

}