package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import github.kunalgharate.deltafourapp.R
import github.kunalgharate.deltafourapp.ui.theme.greyBorder
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
        subTitle("Type of work", "(Add more if needed)", 12.sp, modifier = Modifier)
        HorizontalList()
        DateSelectionUI("Start Date")
        DateSelectionUI("End Date")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateSelectionUI(title: String) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    Column(Modifier.padding(10.dp)) {
        titleTextView(title)
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            readOnly = true,
            value = selectedText.takeIf { it.isNotEmpty() } ?: "Select",
            onValueChange = { selectedText = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = topBackground,
                unfocusedBorderColor = greyBorder,
                cursorColor = topBackground
            ),
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
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
