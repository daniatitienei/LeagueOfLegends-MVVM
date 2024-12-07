package com.ad_coding.mvvmcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ad_coding.mvvmcourse.ui.screen.champion_details.ChampionDetailsScreen
import com.ad_coding.mvvmcourse.ui.screen.champion_details.ChampionDetailsViewModel
import com.ad_coding.mvvmcourse.ui.screen.champion_list.ChampionListScreen
import com.ad_coding.mvvmcourse.ui.screen.champion_list.ChampionListViewModel
import com.ad_coding.mvvmcourse.ui.theme.MvvmCourseTheme
import com.ad_coding.mvvmcourse.ui.util.ChampionDetails
import com.ad_coding.mvvmcourse.ui.util.ChampionList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MvvmCourseTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = ChampionList) {

                    composable<ChampionList> {
                        val viewModel = hiltViewModel<ChampionListViewModel>()

                        val state by viewModel.state.collectAsStateWithLifecycle()

                        ChampionListScreen(
                            state = state,
                            onValueChange = viewModel::onSearchTextChange,
                            navigate = { name ->
                                navController.navigate(ChampionDetails(name))
                            }
                        )
                    }

                    composable<ChampionDetails> {
                        val viewModel = hiltViewModel<ChampionDetailsViewModel>()

                        viewModel.champion.value?.let {
                            ChampionDetailsScreen(champion = it)
                        }
                    }
                }
            }
        }
    }
}
