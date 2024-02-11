package hr.ferit.filipfiljevic.guitarlibrary

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.filipfiljevic.guitarlibrary.ui.theme.BottomNavItem
import hr.ferit.filipfiljevic.guitarlibrary.ui.theme.BottomNavigation
import hr.ferit.filipfiljevic.guitarlibrary.ui.theme.ChordViewList
import hr.ferit.filipfiljevic.guitarlibrary.ui.theme.KeysView
import hr.ferit.filipfiljevic.guitarlibrary.ui.theme.MainScreen


object Routes {
    const val SCREEN_MAIN = "mainScreen"
    const val SCREEN_ROCK_BANDS = "RockBandList"
    const val SCREEN_METAL_BANDS = "MetalBandList"
    const val SCREEN_HIPHOP_BANDS = "HipHopBandList"
    const val SCREEN_PUNK_BANDS = "PunkBandList"
    const val SCREEN_POP_BANDS = "PopBandList"
    const val SCREEN_COUNTRY_BANDS = "CountryBandList"
    const val SCREEN_OTHER_BANDS = "OtherBandList"



    const val SONG_CHORDS = "Chords/{songid}"
    const val SCREEN_SONGS = "SongDetails/{BandId}"
    const val SCREEN_CHORDLIST = "Chordlist/{k}"

    fun getSongPath( songid: String): String {
        if(songid != null){
            return "Chords/$songid"
        }
        return "Chord/0"
    }


    fun getDetailsPath(BandId: String): String {
        if (BandId != null) {
            return "SongDetails/$BandId"
        }
        return "SongDetails/0"
    }

    fun getChordsPath(k: String): String {
        if (k != null) {
            return "Chordlist/$k"
        }
        return "chordlist/0"
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationController(
    viewModel: SongViewModel
) {
    val navController = rememberNavController()
    Scaffold(
        content = {

            NavHost(
                navController = navController,
                startDestination = Routes.SCREEN_MAIN,
            ) {
                composable(Routes.SCREEN_MAIN) {
                    MainScreen(navigation = navController)
                }

                /*Nav host*/
                composable(BottomNavItem.Chords.route) {
                    KeysView(navigation = navController)
                }
                composable(BottomNavItem.Home.route) {
                    MainScreen(navigation = navController)
                }
                composable(BottomNavItem.Personal.route) {
                    FaveSongList(navigation = navController, viewModel = viewModel)
                }

                composable(Routes.SCREEN_ROCK_BANDS) {
                    RockBandsScreen(navigation = navController)
                }
                composable(Routes.SCREEN_METAL_BANDS) {
                    MetalBandsScreen(navigation = navController)
                }
                composable(Routes.SCREEN_HIPHOP_BANDS) {
                    HipHopBandsScreen(navigation = navController)
                }
                composable(Routes.SCREEN_PUNK_BANDS) {
                    PunkBandsScreen(navigation = navController)
                }
                composable(Routes.SCREEN_POP_BANDS) {
                    PopBandsScreen(navigation = navController)
                }

                composable(Routes.SCREEN_COUNTRY_BANDS) {
                    CountryBandsScreen(navigation = navController)
                }
                composable(Routes.SCREEN_OTHER_BANDS) {
                    OtherBandsScreen(navigation = navController)
                }
                composable(
                    Routes.SCREEN_SONGS,
                    arguments = listOf(navArgument("BandId")
                    { type = NavType.StringType })
                )
                { backStackEntry ->
                    backStackEntry.arguments?.getString("BandId")?.let {
                       SongList(navigation = navController, Id = it, viewModel = viewModel)
                    }
                }
                composable(
                    Routes.SCREEN_CHORDLIST,
                    arguments = listOf(navArgument("k")
                    { type = NavType.StringType })
                )
                { backStackEntry ->
                    backStackEntry.arguments?.getString("k")?.let {
                        ChordViewList(navigation = navController, id = it)
                    }
                }
                composable(Routes.SONG_CHORDS,
                    arguments = listOf(navArgument("songid")
                    { type = NavType.StringType }
                    )) { backStackEntry ->
                    backStackEntry.arguments?.getString("songid")?.let {
                        ChordView(navigation = navController, songid = it, viewModel = viewModel)
                    }
                }

            }
        },
            bottomBar = {
                BottomNavigation(navController = navController)

            }
    )
}


