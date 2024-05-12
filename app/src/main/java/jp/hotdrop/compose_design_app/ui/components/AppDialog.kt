package jp.hotdrop.compose_design_app.ui.components

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.hotdrop.compose_design_app.R

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