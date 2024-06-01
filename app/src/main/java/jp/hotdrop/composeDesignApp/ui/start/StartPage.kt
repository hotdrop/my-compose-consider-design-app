package jp.hotdrop.composeDesignApp.ui.start

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import jp.hotdrop.composeDesignApp.R
import jp.hotdrop.composeDesignApp.ui.components.CustomTextField
import jp.hotdrop.composeDesignApp.ui.theme.ComposedesignappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartPage(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(stringResource(id = R.string.start_title), color = Color.White)
                        }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(stringResource(id = R.string.start_overview))
                Spacer(modifier = Modifier.height(16.dp))
                NickNameTextField()
                Spacer(modifier = Modifier.height(16.dp))
                EmailTextField()
                Spacer(modifier = Modifier.height(32.dp))
                RegisterButton()
            }
        }
    )
}

@Composable
private fun NickNameTextField(
    viewModel: StartViewModel = hiltViewModel()
) {
    val inputNickName = viewModel.inputNickNameState.collectAsState().value
    CustomTextField(
        value = inputNickName,
        onValueChange = {
            viewModel.inputNickName(it)
        },
        hintLabel = stringResource(id = R.string.start_nickname_field_label)
    )
}

@Composable
private fun EmailTextField(
    viewModel: StartViewModel = hiltViewModel()
) {
    val inputEmail = viewModel.inputEmailState.collectAsState().value
    CustomTextField(
        value = inputEmail,
        onValueChange = {
            viewModel.inputEmail(it)
        },
        hintLabel = stringResource(id = R.string.start_email_field_label)
    )
}

@Composable
private fun RegisterButton(modifier: Modifier = Modifier) {
    Button(onClick = { /*TODO*/ }) {
        Text(
            text = stringResource(id = R.string.start_Register_button),
            modifier = modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PagePreview() {
    ComposedesignappTheme {
        val navController = rememberNavController()
        StartPage(navController = navController)
    }
}