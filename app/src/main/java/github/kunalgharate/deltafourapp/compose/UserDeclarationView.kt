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
import github.kunalgharate.deltafourapp.constants.AppStrings
import github.kunalgharate.deltafourapp.ui.theme.lightGreyTitle


@Composable
fun UserDeclarationView()
{
    Column {
        Text(
            modifier = Modifier.padding(10.dp),
            text = AppStrings.SELECT_PERMIT_ISSUING_AUTHORITY, color = lightGreyTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        dropDownMenu(AppStrings.SELECT_PERMIT_ISSUING_AUTHORITY)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding(10.dp),
            text = AppStrings.SELECT_RECEIVER, color = lightGreyTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        dropDownMenu(AppStrings.MYSELF)
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewUserDeclarationView()
{
    UserDeclarationView()
}