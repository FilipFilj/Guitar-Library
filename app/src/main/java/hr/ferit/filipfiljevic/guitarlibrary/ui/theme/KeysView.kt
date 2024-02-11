@file:OptIn(ExperimentalMaterial3Api::class)

package hr.ferit.filipfiljevic.guitarlibrary.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.filipfiljevic.guitarlibrary.ChordKList
import hr.ferit.filipfiljevic.guitarlibrary.CircularButton
import hr.ferit.filipfiljevic.guitarlibrary.R
import hr.ferit.filipfiljevic.guitarlibrary.Routes
import hr.ferit.filipfiljevic.guitarlibrary.ScreenTitle


@Composable
fun KeysView(navigation: NavController) {
LazyColumn()
{
    item {

        ScreenTitle("You need help finding a chord?", "They're separated by different keys!")

        for (item in ChordKList)
            (
                    Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(80.dp)
                                        .border(0.5.dp, color = Color.Black)
                                        .clickable{
                                            navigation.navigate(Routes.getChordsPath(item.k))
                                        }
                                ){
                                    Column(){
                                        Text( item.whichK,fontWeight = FontWeight.Medium, fontSize = 20.sp, color = Color.Magenta,
                                            modifier = Modifier
                                                .padding(
                                                    PaddingValues(
                                                        top = 5.dp,
                                                        bottom = 2.dp,
                                                        start = 2.dp
                                                    )
                                                )

                                        )
                                    }
                                }

                                )
    }
}
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChordViewList(navigation: NavController, id: String) {
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFFF3EDF7))

            )
            {
                CircularButton(R.drawable.ic_arrow_back)
                {
                    navigation.navigateUp()
                }
            }
        },
        bottomBar = {
        }
    )
    {
        val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
                for (item in ChordKList) {
                    if (item.k == id) {
                        for (detail in item.chordList) {
                            Box(
                                modifier = Modifier
                                    .padding(
                                        PaddingValues(
                                            top = 15.dp,
                                            bottom = 50.dp,
                                        )
                                    )
                                .fillMaxSize()
                                .wrapContentSize(align = Alignment.Center)

                            )
                            {
                                Image(
                                    painter = painterResource(id = detail.chordPhoto),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .wrapContentSize(align = Alignment.Center)
                                        .height(300.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    detail.NameOfChord,
                                    fontWeight = FontWeight.Medium, fontSize = 24.sp,
                                    modifier = Modifier
                                        .wrapContentSize(align = Alignment.Center)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}