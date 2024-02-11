package hr.ferit.filipfiljevic.guitarlibrary.ui.theme


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hr.ferit.filipfiljevic.guitarlibrary.GenreCard
import hr.ferit.filipfiljevic.guitarlibrary.R
import hr.ferit.filipfiljevic.guitarlibrary.Routes
import hr.ferit.filipfiljevic.guitarlibrary.ScreenTitle

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navigation: NavController) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
             },
        bottomBar = {
        })
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ScreenTitle(
                title = "What genre will you play?",
                subtitle = "Perfect day for some music!"
            )
        val scrollState = rememberLazyListState()
        LazyColumn(
            state = scrollState,
            modifier = Modifier
        ) {
            item {
                GenreCard(R.drawable.rock, "Rock music") {
                        navigation.navigate(Routes.SCREEN_ROCK_BANDS)
                }
                GenreCard(R.drawable.metal, "Metal music", )
                {
                    navigation.navigate(Routes.SCREEN_METAL_BANDS)
                }
                GenreCard(R.drawable.hiphop, "Hip Hop music",)
                {
                   navigation.navigate(Routes.SCREEN_HIPHOP_BANDS)
                }
                GenreCard(R.drawable.punk, "Punk music",)
                {
                   navigation.navigate(Routes.SCREEN_PUNK_BANDS)
                }
                GenreCard(R.drawable.pop2, "Pop music")
                {
                    navigation.navigate(Routes.SCREEN_POP_BANDS)
                }
                GenreCard(R.drawable.country, "Country music")
                {
                    navigation.navigate(Routes.SCREEN_COUNTRY_BANDS)
                }
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White),
                    modifier = Modifier
                        .padding(bottom = 80.dp)
                        .height(175.dp)
                        .fillMaxWidth()
                ){
                GenreCard(
                    R.drawable.other,
                    "Other music"
                )
                {
                   navigation.navigate(Routes.SCREEN_OTHER_BANDS)
            }}
            }
    }
}}}




sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var route: String
) {
    object Home :
        BottomNavItem(
            "Home",
            R.drawable.homeicon,
            "home"
        )

    object Chords :
        BottomNavItem(
            "Chords",
            R.drawable.guitaricon,
            "chords"
        )

    object Personal :
        BottomNavItem(
            "Personal",
            R.drawable.personicon,
            "personal"
        )
}

@Composable
fun BottomNavigation(navController: NavHostController) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Chords,
        BottomNavItem.Personal,
    )

    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item,
                navController = navController
            )
        }
    }
}



@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },

        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title,
                modifier = Modifier.size(18.dp),
            )
        },

        selected = true,

        alwaysShowLabel = true,

        onClick = {
            navController.navigate(screen.route)
        },

        colors = NavigationBarItemDefaults.colors()
    )
}

val items = listOf(
    BottomNavItem.Home,
    BottomNavItem.Chords,
    BottomNavItem.Personal
)