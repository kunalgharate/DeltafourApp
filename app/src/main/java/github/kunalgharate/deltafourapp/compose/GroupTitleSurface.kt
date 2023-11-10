package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import github.kunalgharate.deltafourapp.ui.theme.lightGreyTitle
import github.kunalgharate.deltafourapp.ui.theme.topBackground


@Composable
fun parentTitle(title:String) {
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
            titleTextView(title = title)
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Icon",
                tint = topBackground
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