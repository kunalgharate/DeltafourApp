package github.kunalgharate.deltafourapp.compose

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import github.kunalgharate.deltafourapp.DeltaFourUI
import github.kunalgharate.deltafourapp.R
import github.kunalgharate.deltafourapp.ui.theme.greyBorder
import github.kunalgharate.deltafourapp.ui.theme.lightGreyTitle
import github.kunalgharate.deltafourapp.ui.theme.topBackground


val workItems = listOf(
    WorkItem("Hot Work"),
    WorkItem("Work at Height"),
    WorkItem("Cold Work"),
    WorkItem("Breaking of pipeline"),
    WorkItem("Confined space entry"),
    WorkItem("Heavy equipment lifting/shifting"),
)

@Composable
fun WorkSummaryTab() {
    Column {
        OutlinedTextFieldIcon()
        subTitle("Type of work","(Add more than one if needed)",12.sp, modifier = Modifier)
        HorizontalList()
        dropDownMenu("Select type of work")
        dateSelectionUI("Start Date")
        dateSelectionUI("End Date")

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dateSelectionUI(title :String )
{
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    Column(Modifier.padding(10.dp)){
        titleTextView(title)
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            readOnly = true, // Make the text field read-only
            //  onClick = { expanded = true }, // Open the dropdown on click
            value = selectedText.takeIf { it.isNotEmpty() } ?: "Select",
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
                    Icon(painterResource(id = R.drawable.calendar_clock), "contentDescription")
                }
            },

            )
    }



}



@Composable
fun HorizontalList() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
    ) {
        items(workItems) { item ->
            Box(modifier = Modifier.padding(10.dp)) {
                ChipButton(buttonText = item.name) {

                }
            }
        }
    }
}

data class WorkItem(val name: String)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldIcon() {
    var textInput by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textInput,
        onValueChange = { textInput = it },
        label = { Text("Email") },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.edit_icon),
                contentDescription = null
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = topBackground,
            unfocusedBorderColor = greyBorder
        )

    )

}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun previewDeltaFourUI() {
    WorkSummaryTab()

}
