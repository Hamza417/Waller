package app.simple.peri.compose.screens

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import app.simple.peri.R
import app.simple.peri.models.Wallpaper
import app.simple.peri.utils.FileUtils.toUri
import app.simple.peri.viewmodels.HomeScreenViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(context: Context, navController: NavController? = null) {
    val pagerState = rememberPagerState(pageCount = {
        2
    })

    val fling = PagerDefaults.flingBehavior(
            state = pagerState,
            pagerSnapDistance = PagerSnapDistance.atMost(10)
    )

    val homeScreenViewModel: HomeScreenViewModel = viewModel()
    val systemWallpapers: ArrayList<Wallpaper>
            by homeScreenViewModel.getSystemWallpaper().observeAsState(initial = arrayListOf())

    Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Transparent
    ) {
        Column {
            Header(
                    title = context.getString(R.string.app_name),
                    modifier = Modifier.padding(24.dp),
                    navController = navController
            )

            HorizontalPager(
                    state = pagerState,
                    contentPadding = PaddingValues(horizontal = 32.dp),
                    flingBehavior = fling,
                    modifier = Modifier
                        .weight(1f)
            ) { page ->
                val wallpaper = systemWallpapers.getOrNull(page)

                CardItem(
                        title = if (page == 0) context.getString(R.string.lock_screen) else context.getString(R.string.home_screen),
                        onClick = {
                            if (page == 0) {
                                navController?.navigate("wallpaper")
                            } else {
                                navController?.navigate("settings")
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .graphicsLayer {
                                // Calculate the absolute offset for the current page from the
                                // scroll position. We use the absolute value which allows us to mirror
                                // any effects for both directions
                                val pageOffset = (
                                        (pagerState.currentPage - page) + pagerState
                                            .currentPageOffsetFraction
                                        ).absoluteValue

                                // We animate the alpha, between 50% and 100%
                                alpha = lerp(
                                        start = 0.5f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                )
                            }
                            .padding(8.dp), // Add padding to create space between the cards
                        wallpaper = wallpaper

                )
            }

            BottomMenu(
                    context = context,
                    modifier = Modifier
                        .padding(8.dp)
                        .height(120.dp)
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardItem(title: String, onClick: () -> Unit, modifier: Modifier = Modifier, wallpaper: Wallpaper?) {
    val currentScale = remember {
        mutableStateOf(ContentScale.Crop)
    }

    val hazeState = remember { HazeState() }

    ElevatedCard(
            elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
            ),
            modifier = modifier
                .fillMaxHeight()
                .padding(8.dp), // margin
            onClick = onClick,
            shape = RoundedCornerShape(32.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            GlideImage(
                    model = wallpaper?.uri?.toUri(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .haze(state = hazeState),
                    alignment = Alignment.Center,
                    contentScale = currentScale.value,
            ) {
                it.addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                            e: GlideException?, model: Any?, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                            resource: Drawable, model: Any, target: Target<Drawable>?, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                        return false
                    }
                })
                    .transition(withCrossFade())
                    .disallowHardwareConfig()
                    .fitCenter()
            }

            Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .hazeChild(
                                state = hazeState,
                                style = HazeDefaults.style(backgroundColor = Color(0x50000000), blurRadius = 15.dp))
                        .align(Alignment.BottomCenter)
            ) {
                Text(
                        text = title,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 24.sp, // Set the font size
                        fontWeight = FontWeight.Bold, // Make the text bold
                        color = Color.White, // Set the text color
                )

                Text(
                        text = wallpaper?.width.toString() + "x" + wallpaper?.height.toString(),
                        modifier = Modifier
                            .padding(start = 16.dp, top = 4.dp, bottom = 16.dp),
                        textAlign = TextAlign.End,
                        fontSize = 16.sp, // Set the font size
                        fontWeight = FontWeight.Light, // Make the text bold
                        color = Color.White, // Set the text color
                )
            }
        }
    }
}

@Composable
fun Header(title: String, modifier: Modifier = Modifier, navController: NavController? = null) {
    Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
                text = title,
                textAlign = TextAlign.Start,
                fontSize = 32.sp, // Set the font size
                modifier = Modifier.weight(1f), // Set the weight
                fontWeight = FontWeight.Bold, // Make the text bold
        )

        IconButton(
                onClick = {
                    navController?.navigate("settings")
                },
        ) {
            Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = null
            )
        }
    }
}

@Composable
fun BottomMenu(context: Context, modifier: Modifier = Modifier) {
    Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.Bottom
    ) {
        BottomMenuItem(title = context.getString(R.string.home),
                       imageVector = Icons.Filled.Home,
                       modifier = Modifier.weight(1f))

        BottomMenuItem(title = context.getString(R.string.settings),
                       imageVector = Icons.Filled.Settings,
                       modifier = Modifier.weight(1f))

        BottomMenuItem(title = context.getString(R.string.wallpapers),
                       imageVector = Icons.Filled.AddCircle,
                       modifier = Modifier.weight(1f))
    }
}

@Composable
fun BottomMenuItem(modifier: Modifier = Modifier, title: String = "", imageVector: ImageVector? = null) {
    Column(
            modifier = modifier
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
                elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.dp
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .width(64.dp)
                    .height(64.dp)
                    .weight(1f),
                shape = RoundedCornerShape(32.dp),
        ) {
            IconButton(
                    modifier = Modifier.fillMaxSize(),
                    onClick = {
                        // Navigate to the home screen
                    },
            ) {
                Icon(
                        imageVector = imageVector ?: Icons.Filled.Home,
                        contentDescription = null,
                )
            }
        }

        Text(
                text = title,
                textAlign = TextAlign.Center,
                fontSize = 16.sp, // Set the font size
                modifier = Modifier.weight(1f), // Set the weight
                fontWeight = FontWeight.Bold, // Make the text bold
        )
    }
}
