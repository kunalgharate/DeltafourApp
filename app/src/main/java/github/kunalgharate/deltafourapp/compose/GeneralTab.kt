package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import github.kunalgharate.deltafourapp.R

@Composable
fun GeneralTab() {
    Column( modifier = Modifier.padding(10.dp)) {
        table(title = "Work area free from combustible / flammable / toxic materials? ")
        table("Manholes, catch pits / basins, sewer connections are covered? ")
    }
}


@Composable
fun table(title:String)
{
    var rightBoxHeight by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            // Left side (70% width)
            Box(
                modifier = Modifier
                    .weight(0.7f)
                    .border(1.dp, Color.Gray)
                    .height(IntrinsicSize.Min)
                    .onGloballyPositioned {
                        // Use the onGloballyPositioned callback to get the height of the left Box
                        // This callback will be called after the layout is performed
                        if (rightBoxHeight == 0) {
                            rightBoxHeight = it.size.height
                        }
                    }
            ) {
                Text(
                    text = title,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }

            Layout(
                content = {
                    SwitchWithIconExample()
                },
                modifier = Modifier
                    .weight(0.3f)
                    .border(1.dp, Color.Gray)
            ) { measurables, constraints ->
                val placeable = measurables[0].measure(constraints)
                layout(constraints.maxWidth, rightBoxHeight) {
                    // Center the Switch vertically within the Box
                    val top = (rightBoxHeight - placeable.height) / 2
                    placeable.placeRelative(0, top)
                }
            }
        }
    }
}

@Composable
fun SwitchWithIconExample() {
    var checked by remember { mutableStateOf(true) }



    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = if (checked) {
            {
                Icon(
                    painter = painterResource(id = R.drawable.y),
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        }
    )
}

//@Composable
//fun SwitchWithIconExample() {
//    var checked by remember { mutableStateOf(true) }
//
//    Box(
//        modifier = Modifier
//            .width(48.dp)
//            .height(24.dp)
//            .padding(10.dp)
//    ) {
//        Switch(
//            checked = checked,
//            onCheckedChange = {
//                checked = it
//            },
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}


/*@Composable
fun GeneralTab() {
    var leftBoxHeight by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically, // Align the row's content vertically
            modifier = Modifier
                .fillMaxSize()

        ) {
            // Left side (70% width)
            Box(
                modifier = Modifier
                    .weight(0.7f)
                    .border(1.dp, Color.Gray)
                    .height(IntrinsicSize.Min)
                    .onGloballyPositioned {
                        leftBoxHeight = it.size.height
                    }
            ) {
                Text(
                    text = "Work area free from combustible / flammable / toxic materials? ",
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(10.dp) // Adjust padding as needed
                )
            }

            // Right side (30% width)
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .border(1.dp, Color.Gray)
                    .height(leftBoxHeight.dp),
                contentAlignment = Alignment.Center// 30% width
            ) {
                SwitchWithIconExample()
            }
        }
    }
}

@Composable
fun SwitchWithIconExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        }
    )
}*/

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewGeneralTab() {
    GeneralTab()
}