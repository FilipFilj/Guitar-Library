package hr.ferit.filipfiljevic.guitarlibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SongList(navigation: NavController, Id: String, viewModel: SongViewModel) {
    LazyColumn()
    {
        item{
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
            for (song in viewModel.songs)(
                        if (song.bandId == Id)
                            (
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(80.dp)
                                            .border(0.5.dp, color = Color.Black)
                                            .clickable {
                                                navigation.navigate(Routes.getSongPath(song.songid))
                                            }
                                    ){
                                        Column(){
                                        Text( song.songName,fontWeight = FontWeight.Medium, fontSize = 20.sp, color = Color.Magenta,
                                            modifier = Modifier

                                                .padding(
                                                    PaddingValues(
                                                    top = 5.dp,
                                                    bottom = 2.dp,
                                                    start = 2.dp
                                                )
                                                )

                                        )
                                            Text(song.artist, fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(PaddingValues(
                                                        top = 5.dp,
                                                        bottom = 2.dp,
                                                        start = 2.dp
                                                    )))
                                        Text( song.chordsUsed, fontSize = 10.sp,
                                        modifier = Modifier
                                                .padding(PaddingValues(
                                            top = 5.dp,
                                            bottom = 2.dp,
                                            start = 2.dp
                                        )))
                                        }
                                    }
                                    ))

        }
    }
}