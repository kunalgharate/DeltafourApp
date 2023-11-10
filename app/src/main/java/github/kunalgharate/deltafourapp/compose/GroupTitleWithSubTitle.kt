package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import github.kunalgharate.deltafourapp.ui.theme.topBackground


@Composable
fun groupTitleWithSubTitle(title:String,subTitleString:String,fontSize: TextUnit, onIconClick: () -> Unit) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .shadow(10.dp, shape = RectangleShape),
            color = Color.White
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {


                subTitle(
                    title = title,
                    subTitle = subTitleString,
                    fontSize = fontSize,
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxWidth()
                )

                // Icon takes 20% of the width
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Icon",
                    tint = topBackground,
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxWidth()
                        .clickable{
                            onIconClick()
                        }
                )


            }

//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(4.dp)
//                .background(color = Color.Gray.copy(alpha = 0.1f))
//        )
        }
    }

@Preview
@Composable
fun previewGroupTitleWithSubTitle() {
    groupTitleWithSubTitle(title = "Hello", subTitleString = "test", fontSize = 10.sp,{})
}