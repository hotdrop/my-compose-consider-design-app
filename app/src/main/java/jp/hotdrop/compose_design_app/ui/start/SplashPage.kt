package jp.hotdrop.compose_design_app.ui.start

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import jp.hotdrop.compose_design_app.R
import jp.hotdrop.compose_design_app.ui.components.AppDialogOnlyOk
import jp.hotdrop.compose_design_app.ui.theme.ComposedesignappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashPage(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.splash_title)) })
        },
        content = { padding ->
            val state = viewModel.state.collectAsState().value
            Box(modifier = Modifier
                .padding(padding)
                .fillMaxSize()) {
                when (state) {
                    is SplashState.Success -> ViewOnSuccess(state.uiData)
                    is SplashState.Loading -> ViewOnLoading(state.uiData.getUserId())
                    is SplashState.Error -> ViewOnError(errorMsg = state.errorMsg)
                }
            }
        }
    )
}

@Composable
private fun ViewOnSuccess(uiData: SplashUiData) {
    if (uiData.isInitialized()) {
        // TODO 非同期でHomePageに遷移する
        ViewOnLoading(userId = uiData.getUserId())
    } else {
        ViewFirstPage()
    }
}

@Composable
private fun ViewFirstPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 36.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.start),
            contentDescription = "Start Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.first_start_overview))
        Button(
            onClick = { /*TODO StartPageに遷移する */ },
            modifier = Modifier.padding(horizontal = 36.dp, vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.first_start_first_time_button))
        }
    }
}

@Composable
private fun ViewOnLoading(userId: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 36.dp),
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
        userId?.let {
            Text(stringResource(id = R.string.splash_user_id_label, it))
        }
    }
}

@Composable
private fun ViewOnError(errorMsg: String) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    // ダイアログを表示するためのLaunchedEffect
    LaunchedEffect(key1 = true) {
        showDialog = true
    }

    if (showDialog) {
        AppDialogOnlyOk(
            message = errorMsg,
            onOk = {
                (context as? Activity)?.finish()
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(stringResource(id = R.string.splash_error_label), color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
private fun ViewOnSuccessPreview() {
    ComposedesignappTheme {
        ViewFirstPage()
    }
}

@Preview(showBackground = true)
@Composable
private fun ViewLoadingWithUserIdViewPreview() {
    ComposedesignappTheme {
        ViewOnLoading(userId = "1234567890")
    }
}

@Preview(showBackground = true)
@Composable
private fun ViewLoadingNonUserIdViewPreview() {
    ComposedesignappTheme {
        ViewOnLoading(userId = null)
    }
}

@Preview(showBackground = true)
@Composable
private fun ViewOnErrorPreview() {
    ComposedesignappTheme {
        ViewOnError(errorMsg = "エラーのダイアログメッセージです。")
    }
}