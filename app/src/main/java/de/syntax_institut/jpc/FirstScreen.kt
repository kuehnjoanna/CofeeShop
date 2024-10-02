package de.syntax_institut.jpc

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.ContentAlpha
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable
import de.syntax_institut.jpc.ui.theme.JPCTheme

@Composable
fun Homescreen() {

    val navController = rememberNavController()
    val navigationBarItems = remember { NavigationBarItems.values() }
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.padding(all = 12.dp),
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier,
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = MaterialTheme.colorScheme.primary,
                ballColor = MaterialTheme.colorScheme.primary
            ) {
                navigationBarItems.forEach { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .noRippleClickable { selectedIndex = item.ordinal },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(26.dp)
                                .clickable {
                                    //    navController.navigate(
                                    //    SecondScreen()
                                    //  )
                                },
                            imageVector = item.icon,
                            contentDescription = "Bottom Bar Icon",
                            tint = if (selectedIndex == item.ordinal) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }
            }
        }
    )
    { paddingValues ->
        // Use the padding values to avoid overlap with the bottom bar
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))

            )
            {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .height(90.dp)
                        .width(80.dp)
                        .background(
                            color = Color.Magenta,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.espresso), contentDescription = null,
                        Modifier
                            .height(70.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Coffee",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Black
                    )

                }
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .height(90.dp)
                        .width(80.dp)
                        .background(
                            color = Color.Magenta,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.espresso), contentDescription = null,
                        Modifier
                            .height(70.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Coffee",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Black
                    )

                }
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .height(90.dp)
                        .width(80.dp)
                        .background(
                            color = Color.Magenta,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.espresso), contentDescription = null,
                        Modifier
                            .height(70.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Coffee",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Black
                    )

                }


            }
            ExpandableCard()
        }


    }
}

enum class NavigationBarItems(val icon: ImageVector) {
    Person(icon = Icons.Default.Person),
    Cart(icon = Icons.Default.ShoppingCart),
    Home(icon = Icons.Default.Home)
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard() {
    var expandableState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(targetValue = if (expandableState) 180f else 0f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        onClick = {
            expandableState = !expandableState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = "Title",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .weight(1f)
                    .rotate(rotationState),
                    onClick = {
                        expandableState = !expandableState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow"
                    )

                }
            }
        }


    }
}

@Composable
@Preview()
private fun MainScreenPreview() {
    JPCTheme {
        Homescreen()
        //  ExpandableCard()
    }


}