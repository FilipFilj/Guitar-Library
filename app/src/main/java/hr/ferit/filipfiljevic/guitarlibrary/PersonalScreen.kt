package hr.ferit.filipfiljevic.guitarlibrary

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun FaveSongList(navigation: NavController, viewModel: SongViewModel) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxWidth())
    {
        item{
    ScreenTitle("Here you can find your favourite songs!", "")
            for (item in viewModel.songs){
                if(item.favorite == true){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .border(1.dp, color = Color.Black)
                .clickable {
                 navigation.navigate(
                     Routes.getSongPath(item.songid)
                  )
                }
            )
            {
                Column() {
                    Text(
                        item.songName,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = Color.Magenta,
                        modifier = Modifier

                            .padding(
                                PaddingValues(
                                    top = 5.dp,
                                    bottom = 2.dp,
                                    start = 2.dp
                                )
                            )
                    )
                    Text(
                        item.artist, fontSize = 12.sp,
                        modifier = Modifier
                            .padding(
                                PaddingValues(
                                    top = 5.dp,
                                    bottom = 2.dp,
                                    start = 2.dp
                                )
                            )
                    )
                    Text(
                        item.chordsUsed, fontSize = 10.sp,
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
        }
    }
}
}}