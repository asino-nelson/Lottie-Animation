package com.example.lottieanimations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.lottieanimations.ui.theme.LottieAnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottieAnimationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Lottie()
                }
            }
        }
    }
}

@Composable
fun Lottie() {
    val isPlaying by remember{
        mutableStateOf(true)
    }
    val speed by remember{
        mutableStateOf(1f)
    }
    val composition by rememberLottieComposition(

        spec = LottieCompositionSpec.RawRes(R.raw.basketball)

    )
    val animation by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying,
        restartOnPlay = false,
        speed = speed,
        iterations = LottieConstants.IterateForever
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LottieAnimation(
            composition,
            progress = animation,
            modifier = Modifier.size(200.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LottieAnimationsTheme {
        Lottie()
    }
}