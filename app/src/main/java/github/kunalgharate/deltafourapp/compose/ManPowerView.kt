package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun ManPowerView()
{
    Column {
        subTitle(title = "Technicians Involved", subTitle = "(Add more than one if needed)", fontSize = 10.sp, modifier = Modifier.padding(vertical = 10.dp))
        dropDownMenu("Select Permit Issuing Authority")
        Spacer(modifier = Modifier.height(10.dp))
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewManPowerView()
{
    ManPowerView()
}