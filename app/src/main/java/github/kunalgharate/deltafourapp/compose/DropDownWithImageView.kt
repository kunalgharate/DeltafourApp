package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import github.kunalgharate.deltafourapp.R
import github.kunalgharate.deltafourapp.ui.theme.greyBorder
import github.kunalgharate.deltafourapp.ui.theme.topBackground


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dropDownWithImageView(title:String) {

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(10.dp)) {
        Box (modifier = Modifier
            .clickable {
                expanded = !expanded
            }
            .fillMaxWidth()){
            OutlinedTextField(
                readOnly = true, // Make the text field read-only
                //  onClick = { expanded = true }, // Open the dropdown on click
                value = selectedText.takeIf { it.isNotEmpty() } ?: title,
                onValueChange = { selectedText = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = topBackground, // Change the outline color when focused
                    unfocusedBorderColor = greyBorder, // Change the outline color when not focused
                    cursorColor = topBackground // Change the cursor color
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        //This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
                trailingIcon = {
                    IconButton(
                        onClick = { expanded = !expanded }
                    ) {
                        Icon(icon, "contentDescription", tint = topBackground)
                    }
                },

                leadingIcon = {
                    IconButton(
                        onClick = { expanded = !expanded }
                    ) {
                        Image(painter = painterResource(id = R.drawable.usericon), contentDescription = "")
                    }
                },

                )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(color = Color.White)
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                .shadow(1.dp)
        ) {
            workItems.forEachIndexed { index, label ->
                DropdownMenuItem(text = {

                    Row {
                        Image(painter = painterResource(id = R.drawable.usericon), contentDescription = "")
                        Text(
                            text = label.name, modifier =
                            Modifier.padding(10.dp)
                        )

                    }
                }, onClick = {
                    selectedText = label.name
                    expanded = false

                })
                if (index < workItems.size - 1) {
                    Divider(color = Color.LightGray, thickness = .5.dp)
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun  PreviewDropDown()
{
    dropDownWithImageView(title = "Hello");
}
