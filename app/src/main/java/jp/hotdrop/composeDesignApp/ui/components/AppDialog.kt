package jp.hotdrop.composeDesignApp.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.hotdrop.composeDesignApp.R

@Composable
fun AppDialogOnlyOk(
    message: String,
    onOk: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            Button(onClick = onOk) {
                Text(text = stringResource(id = R.string.dialog_ok))
            }
        },
        text = {
            Text(text = message)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ShowAppDialogOnlyOkPreview() {
    AppDialogOnlyOk(
        message = "これはサンプルコードです。エラーが発生しました。",
        onOk = {  }
    )
}