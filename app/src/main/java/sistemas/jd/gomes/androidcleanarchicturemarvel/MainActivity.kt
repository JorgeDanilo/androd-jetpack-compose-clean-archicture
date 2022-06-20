package sistemas.jd.gomes.androidcleanarchicturemarvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.navigation.NavGraph
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AndroidCleanArchictureMarvelTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCleanArchictureMarvelTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}