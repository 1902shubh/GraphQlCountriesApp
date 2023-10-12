package com.papayacoders.graphqlcountriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.papayacoders.graphqlcountriesapp.presentation.CountriesScreen
import com.papayacoders.graphqlcountriesapp.presentation.CountriesViewModel
import com.papayacoders.graphqlcountriesapp.ui.theme.GraphQlCountriesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlCountriesAppTheme {

                val viewModel = hiltViewModel<CountriesViewModel>()
                val state by viewModel.state.collectAsState()
                CountriesScreen(state = state, onSelectCountry =viewModel::selectCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog)

            }
        }
    }
}