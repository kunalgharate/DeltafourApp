package github.kunalgharate.deltafourapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import github.kunalgharate.deltafourapp.compose.parentTitle
import github.kunalgharate.deltafourapp.compose.WorkSummaryTab
import github.kunalgharate.deltafourapp.compose.CollapseButton
import github.kunalgharate.deltafourapp.compose.GeneralTab
import github.kunalgharate.deltafourapp.compose.IsolationDetailPage
import github.kunalgharate.deltafourapp.compose.ManPowerView
import github.kunalgharate.deltafourapp.compose.PpeSelectionView
import github.kunalgharate.deltafourapp.compose.UserDeclarationView
import github.kunalgharate.deltafourapp.compose.checkBoxComposeView
import github.kunalgharate.deltafourapp.compose.groupTitleWithSubTitle
import github.kunalgharate.deltafourapp.compose.previewPpeSelectionView
import github.kunalgharate.deltafourapp.compose.subTitle
import github.kunalgharate.deltafourapp.compose.topBar
import github.kunalgharate.deltafourapp.constants.AppStrings
import github.kunalgharate.deltafourapp.ui.theme.DeltafourAppTheme
import github.kunalgharate.deltafourapp.ui.theme.topBackground
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeltafourAppTheme {
                    DeltaFourUI()
                }
            }
        }
    }



@Composable
fun DeltaFourUI()
{
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.White))

    {
        var scrollState by remember { mutableStateOf(LazyListState()) }
        var isWorkSummaryTabVisible by remember { mutableStateOf(true) }
        var isGeneralGuidelinesTabVisible by remember { mutableStateOf(true) }
        var isPPEsTabVisible by remember { mutableStateOf(true) }
        var isIsolationTabVisible by remember { mutableStateOf(true) }
        var isUserDeclarationTabVisible by remember { mutableStateOf(true) }
        var isManPowerTabVisible by remember { mutableStateOf(true) }
        var isAllTabsExpanded by remember { mutableStateOf(true) }
        val coroutineScope = rememberCoroutineScope()
        val itemSize = 50.dp
        val density = LocalDensity.current.density
        val itemSizePx = with(density) { itemSize.value }
        val targetIndex = 0
        topBar()
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            CollapseButton(if (isAllTabsExpanded) AppStrings.COLLAPSE_ALL else AppStrings.EXPAND_ALL,if(isAllTabsExpanded) R.drawable.minus_circle_outlined else R.drawable.add_circle) {

                    isWorkSummaryTabVisible = !isAllTabsExpanded
                    isGeneralGuidelinesTabVisible = !isAllTabsExpanded
                    isPPEsTabVisible = !isAllTabsExpanded
                    isIsolationTabVisible = !isAllTabsExpanded
                    isUserDeclarationTabVisible = !isAllTabsExpanded
                    isManPowerTabVisible = !isAllTabsExpanded
                    isAllTabsExpanded = !isAllTabsExpanded

            }
        }

        LazyColumn(state = scrollState) {
            item {
                groupTitleWithSubTitle(title = AppStrings.WORK_SUMMARY_TITLE, subTitleString = "", fontSize = 10.sp)
                {
                    isWorkSummaryTabVisible = !isWorkSummaryTabVisible
                }

                if (isWorkSummaryTabVisible) {
                    WorkSummaryTab()
                }
            }
//

            item {
                groupTitleWithSubTitle(title = AppStrings.GENERAL_GUIDELINES_TITLE, subTitleString = AppStrings.MANDATORY_FIELDS, fontSize = 10.sp)
                {
                    isGeneralGuidelinesTabVisible = !isGeneralGuidelinesTabVisible
                }

                if (isGeneralGuidelinesTabVisible) {
                    GeneralTab()
                }
            }

            item {
                groupTitleWithSubTitle(title = AppStrings.PPE_SELECTION_TITLE, subTitleString = AppStrings.MANDATORY_FIELDS, fontSize = 10.sp)
                {
                        isPPEsTabVisible = !isPPEsTabVisible
                }
                if (isPPEsTabVisible)
                {
                    PpeSelectionView()
                }
            }



            item {
                groupTitleWithSubTitle(title = AppStrings.ISOLATION_DETAILS_TITLE, subTitleString = AppStrings.MANDATORY_FIELDS, fontSize = 10.sp)
                {
                    isIsolationTabVisible = !isIsolationTabVisible
                }
                if (isIsolationTabVisible)
                {
                    IsolationDetailPage()
                }
            }

            item {
                groupTitleWithSubTitle(title = AppStrings.USER_DECLARATION_TITLE, subTitleString = "", fontSize = 10.sp)

                {
                        isUserDeclarationTabVisible = !isUserDeclarationTabVisible
                }

                if(isUserDeclarationTabVisible)
                {
                    UserDeclarationView()
                }
            }

            item {
                groupTitleWithSubTitle(title = AppStrings.MANPOWER_DETAILS_TITLE, subTitleString = "", fontSize = 10.sp)
                {
                        isManPowerTabVisible = !isManPowerTabVisible
                }

                if(isManPowerTabVisible)
                {
                    ManPowerView()
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp, top = 20.dp)
                        .background(color = Color.White)
                        .clickable {
                            coroutineScope.launch {
                                scrollState.animateScrollToItem(index = 0)
                            }
                        }
                ) {
                    // Your existing content
                    // ...

                    // Image on the right side
                    Image(
                        painter = painterResource(id = R.drawable.uparrow),
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }
            item {
                checkBoxComposeView(title = AppStrings.SAVE_TO_AUTO_FILL, textColor = Color.Black,15.sp)
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(5.dp)) // Adjust corner radius as needed
                        .background(color = topBackground)
                ) {
                    Text(
                        "Create Permit",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.Center)
                    )
                }
            }

        }


    // squareButtonWithIconAndText(buttonText = "Collapse All") {}

    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun previewDeltaFourUI()
{
    DeltaFourUI()

}





