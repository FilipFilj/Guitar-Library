package hr.ferit.filipfiljevic.guitarlibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun ChordView(navigation: NavController, songid: String, viewModel: SongViewModel) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item{
            for (song in viewModel.songs){
                if (song.songid == songid)
                {
                    Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp))
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFFF3EDF7))
                            )
                    {
                        CircularButton(R.drawable.ic_arrow_back) {
                            navigation.navigateUp()
                        }
                        CircularButton(
                            R.drawable.ic_favorite,
                            color = if (song.favorite) Red else DarkGray
                        ){
                          song.favorite = !song.favorite
                            viewModel.updateSong(song.songid, song.favorite)
                            }
                        }
                    Text(
                        song.artist, fontWeight = FontWeight.Medium, fontSize = 20.sp,
                        modifier = Modifier
                            .padding(
                                PaddingValues(
                                    top = 5.dp,
                                    bottom = 2.dp,
                                    start = 10.dp
                                )
                            )
                    )
                    Text(
                        song.songName, fontWeight = FontWeight.Light, fontSize = 16.sp,
                        modifier = Modifier
                            .padding(
                                PaddingValues(
                                    top = 2.dp,
                                    bottom = 2.dp,
                                    start = 10.dp))
                    )
                    Text(
                        song.chordsUsed,
                        modifier = Modifier
                            .padding( PaddingValues(
                                top = 2.dp,
                                bottom = 2.dp,
                                start = 10.dp))
                    )
                    Text(
                        "Rythm: " + song.rythm,
                        modifier = Modifier
                            .padding( PaddingValues(
                                top = 2.dp,
                                bottom = 10.dp,
                                start = 10.dp))
                    )
                    val text = song.songtext
                    val formattext = text.replace("+", "\n")
                    Text(formattext,
                        modifier = Modifier
                            .padding( PaddingValues(
                                top = 2.dp,
                                bottom = 80.dp,
                                start = 10.dp)))
                }
            }}

        }}