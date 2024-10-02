package de.syntax_institut.jpc

import android.graphics.Color
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.jpc.ui.theme.JPCTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            JPCTheme {

            navController = rememberNavController()
            NavGraph(navController = navController)

//                val navController = rememberNavController()
//                NavHost(
//                    navController = navController,
//                    startDestination = Homescreen
//                ){
//                    composable<Homescreen>{
////                        Column(
////                            modifier = Modifier.fillMaxSize(),
////                            verticalArrangement = Arrangement.Center,
////                            horizontalAlignment = Alignment.CenterHorizontally
////                        ) {
////                            Button(onClick = { /*TODO*/ }) {
////                                Text(text = "Go to screen B")
////                            }
////                        }
//                        Homescreen()
//                    }
//                    composable<SecondScreen> {
//                        SecondScreen()
//                    }
//                }
////                Surface(
////                    modifier = Modifier.fillMaxSize(),
////                    color = MaterialTheme.colorScheme.background
////                ) {
////                    Homescreen()
////                }
            /*
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {

                Greeting("Android")
            }*/
            //
        }
    }
}

@Serializable
object Homescreen

@Serializable
data class SecondScreen(
    val name: String?,
    val total: Int
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = " $name!",
        modifier = modifier
    )
}

@Composable
fun Headline(headline: String, modifier: Modifier = Modifier) {
    Text(
        text = " $headline",
        modifier = modifier,
        fontSize = 40.sp
    )
}

@Composable
fun Headline2(headline: String, modifier: Modifier = Modifier) {
    Text(
        text = " $headline",
        modifier = modifier,
        fontSize = 30.sp
    )
}

@Composable
fun DetailCard(
    modifier: Modifier = Modifier,
    contentDescription: String,
    title: String,
) {
    Card(
        modifier = modifier
            .width(100.dp)
            .height(100.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Text(title, style = TextStyle(androidx.compose.ui.graphics.Color.Blue, fontSize = 16.sp))
        Text(
            text = "",
            modifier = modifier,
        )
    }

}

@Composable
fun ImageDisplay(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painter, contentDescription = contentDescription,
        contentScale = ContentScale.Crop, modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .offset(10.dp, 0.dp)
            .zIndex(1f)
    )
    Card(
        modifier = modifier
            .padding(0.dp, 0.dp, 0.dp, 20.dp)
            .width(120.dp)
            .height(120.dp)
            .offset(0.dp, -25.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            // Image(
            ///    painter = painter, contentDescription = contentDescription,
            //      contentScale = ContentScale.Crop,
            //    )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(androidx.compose.ui.graphics.Color.Blue)
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    title,
                    style = TextStyle(androidx.compose.ui.graphics.Color.Blue, fontSize = 16.sp)
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JPCTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(androidx.compose.ui.graphics.Color.Black),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.background(
                    color = androidx.compose.ui.graphics.Color(
                        0xFFA67B5B
                    )
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .background(androidx.compose.ui.graphics.Color.LightGray),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Headline("User", modifier = Modifier)
                    Greeting("Shopping card")
                }

                Headline("Coffee")

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 20.dp, 20.dp, 20.dp)
                        .background(androidx.compose.ui.graphics.Color.LightGray),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Headline2("Premium", Modifier.padding(5.dp))
                    Greeting("see more")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        ImageDisplay(
                            painter = painterResource(id = R.drawable.espresso),
                            contentDescription = "",
                            title = ""
                        )

                    }
                    Column {
                        ImageDisplay(
                            painter = painterResource(id = R.drawable.cappuccino),
                            contentDescription = "",
                            title = ""
                        )

                    }
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp)
                        .background(androidx.compose.ui.graphics.Color.LightGray),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Headline2("Offers", modifier = Modifier.padding(5.dp))
                    Greeting("see more")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ImageDisplay(
                        painter = painterResource(id = R.drawable.cookie),
                        contentDescription = "hoi",
                        title = "hkjk"
                    )
                    Column {
                        Greeting(name = "Title")
                        Greeting(name = "short description")
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Greeting(name = "Price")
                        Greeting(name = "Button")
                    }
                }

                Greeting(
                    "Navigation",
                    modifier = Modifier
                        .background(androidx.compose.ui.graphics.Color.LightGray)
                        .fillMaxWidth()
                        .padding(5.dp)
                )

            }


        }
    }
}