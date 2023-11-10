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
fun UserDeclarationView()
{
    Column {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Select Permit Issuing Authority", color = lightGreyTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        dropDownMenu("Select Permit Issuing Authority")
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Select Receiver", color = lightGreyTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        dropDownMenu("MySelf")
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewUserDeclarationView()
{
    UserDeclarationView()
}