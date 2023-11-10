package github.kunalgharate.deltafourapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import github.kunalgharate.deltafourapp.R
import github.kunalgharate.deltafourapp.ui.theme.buttonBg
import github.kunalgharate.deltafourapp.ui.theme.topBackground


@Composable
fun topBar() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(color = topBackground)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "bg",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = topBackground.copy(alpha = 0.7f))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(2f).padding(8.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                            .background(buttonBg)
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }

                    Text(
                        text = "Create Safety Work Permit",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(5.dp)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(60.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                            .background(buttonBg)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.form_icon),
                            contentDescription = null,
                            contentScale = ContentScale.Inside
                        )
                    }
                    Text(
                        text = "Magic Auto-Fill",
                        color = Color.White,
                        fontSize = 12.sp,
                        maxLines = 1,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun previewTopBar() {
    topBar()
}
