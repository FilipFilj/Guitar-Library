package hr.ferit.filipfiljevic.guitarlibrary

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.filipfiljevic.guitarlibrary.ui.theme.Transparent



@Composable
fun CircularButton(
    @DrawableRes iconResource: Int,
    color: Color = Black,
    onClick: () -> Unit = {

    }
)
{
    Button (
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor= color,
            containerColor = Transparent),
        contentPadding = PaddingValues(),
        modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .width(38.dp)
            .height(38.dp)
            )
    {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
            modifier = Modifier.size(25.dp),
        )
    }
}


@Composable
fun ScreenTitle(
    title: String,
    subtitle: String
) {
    Box(
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(
            text = subtitle,
            style = TextStyle
                (
                color = Color.Magenta,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Text(
            text = title,
            style = TextStyle
                (
                color = Color.Black,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
        )
    }
}


@Composable
fun GenreCard(
    @DrawableRes image: Int,
    title: String,
    onClick: () -> Unit
)
{
    Card(
        modifier = Modifier
            .padding(
                horizontal = 10.dp
            )
            .padding(
                vertical = 5.dp
            )
            .height(175.dp)
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    ) {
        Box(  modifier = Modifier
            .fillMaxSize()
        )
        {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(12.dp)
                    ),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .offset(0.dp, 130.dp)
                    .height(200.dp)
                    .width(205.dp)
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.BottomCenter)
                ) {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = White,
                            fontSize = 18.sp),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                    )
                }
            }}}}


@Composable
fun BandDetail(
    @DrawableRes image: Int,
    title: String,
    bandId: String,
    detailmember: String,
    detailSongs: List<String>,
    detailAlbum: List<Album>,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(370.dp)
    ){
        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onClick()
                    }
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Gray,
                                    Color.White
                                ),
                                startY = 200f
                            )
                        )
                )
            }
            Text(
                title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 36.sp
                ),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .wrapContentSize(align = Alignment.Center)
                    .offset(0.dp, 240.dp)//, 240.dp)
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .offset(0.dp, 300.dp)
            )
            {
                Text(
                    detailmember,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 8.sp
                    ),
                    modifier = Modifier
                        .padding(horizontal = 14.dp)
                        .offset(0.dp, 80.dp)
                )
                var y = 120.dp
                var br = 1
                for(item in detailSongs) {
                    Text(
                        "${br.toString()}. $item",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .offset(0.dp, y)
                    )
                    y += 25.dp
                    br += 1
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    for(item in detailAlbum)
                        (
                                Image(
                                    painter = painterResource(id = item.wallpaper),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                        .padding(5.dp)
                                        .offset(0.dp, 240.dp)
                                )
                                )
                }

            }}}}


