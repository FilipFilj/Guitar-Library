package hr.ferit.filipfiljevic.guitarlibrary



import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RockBandsScreen(navigation: NavController) {
    val scrollState = rememberLazyListState()
        Column(
            modifier = Modifier
                .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
        )
        {
        LazyRow(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            item {
                for(item in bands)
                (
                        if(item.genreId == 1)
                            (
                                    Box(
                                        modifier = Modifier
                                        .fillMaxSize()
                                    ) {
                                        BandDetail(
                                            item.wallpaper,
                                            item.name,
                                            item.BandId,
                                            item.members,
                                            item.bestSongs,
                                            item.album
                                        ) {
                                            navigation.navigate(Routes.getDetailsPath(item.BandId))

                                        }
                                    }
                                    ))

            }}
        }

    }





@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MetalBandsScreen(navigation: NavController) {
    val scrollState = rememberLazyListState()
    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {
        LazyRow(
            state = scrollState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                for(item in bands)
                        (
                                if(item.genreId == 2)
                                    (
                                            BandDetail(item.wallpaper, item.name, item.BandId, item.members , item.bestSongs, item.album) {
                                                navigation.navigate(Routes.getDetailsPath(item.BandId))
                }
                        ))

            }
        }
    }}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HipHopBandsScreen(navigation: NavController) {
    val scrollState = rememberLazyListState()
    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {
        LazyRow(
            state = scrollState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                for(item in bands)
                    (
                            if(item.genreId == 3)
                                (
                                        BandDetail(item.wallpaper, item.name, item.BandId, item.members , item.bestSongs, item.album) {
                                            navigation.navigate(Routes.getDetailsPath(item.BandId))
                                        }
                                        ))

            }
        }

    }}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PunkBandsScreen(navigation: NavController) {
    val scrollState = rememberLazyListState()
    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {
        LazyRow(
            state = scrollState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                for(item in bands)
                    (
                            if(item.genreId == 4)
                                (
                                        BandDetail(item.wallpaper, item.name, item.BandId, item.members , item.bestSongs, item.album) {
                                            navigation.navigate(Routes.getDetailsPath(item.BandId))
                                        }
                                        ))

            }
        }

    }}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PopBandsScreen(navigation: NavController) {
    val scrollState = rememberLazyListState()
    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {
        LazyRow(
            state = scrollState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                for(item in bands)
                    (
                            if(item.genreId == 5)
                                (
                                        BandDetail(item.wallpaper, item.name, item.BandId, item.members , item.bestSongs, item.album) {
                                            navigation.navigate(Routes.getDetailsPath(item.BandId))
                                        }
                                        ))

            }
        }

    }}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CountryBandsScreen(navigation: NavController) {
    val scrollState = rememberLazyListState()
    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {
        LazyRow(
            state = scrollState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                for(item in bands)
                    (
                            if(item.genreId == 6)
                                (
                                        BandDetail(item.wallpaper, item.name, item.BandId, item.members , item.bestSongs, item.album) {
                                            navigation.navigate(Routes.getDetailsPath(item.BandId))
                                        }
                                        ))

            }
        }

    }}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherBandsScreen(navigation: NavController) {
    val scrollState = rememberLazyListState()
    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {
        LazyRow(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                for(item in bands)
                    (
                            if(item.genreId == 7)
                                (
                                        BandDetail(item.wallpaper, item.name, item.BandId, item.members , item.bestSongs, item.album) {
                                            navigation.navigate(Routes.getDetailsPath(item.BandId))
                                        }
                                        ))

            }
        }
    }}
    




/*
Id map:
1 = rock
2 = metal
3 = hiphop
4 = Punk
5 = Pop
6 = Country
7 = Other
 */

