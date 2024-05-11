package jp.hotdrop.compose_design_app.ui.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import jp.hotdrop.compose_design_app.R
import jp.hotdrop.compose_design_app.ui.theme.ComposedesignappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashPage(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Splash Title") })
        },
        content = { padding ->
            val state = viewModel.state.collectAsState().value
            Box(modifier = Modifier
                .padding(padding)
                .fillMaxSize()) {
                when (state) {
                    is SplashState.Success -> ViewOnSuccess()
                    is SplashState.Loading -> ViewOnLoading()
                    is SplashState.Error -> ViewOnError(errorMsg = state.errorMsg)
                }
            }
        }
    )
}

@Composable
private fun ViewOnSuccess() {
    // TODO
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Success")
    }
}

@Composable
private fun ViewOnError(errorMsg: String) {
    // TODO
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Error: $errorMsg")
    }
}

@Composable
private fun ViewOnLoading() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.start),
            contentDescription = "Start Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(24.dp))
        Text("Loading...", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
private fun ViewLoadingViewPreview() {
    ComposedesignappTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            ViewOnLoading()
        }
    }
}
