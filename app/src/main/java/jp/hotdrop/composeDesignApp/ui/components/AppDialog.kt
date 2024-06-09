package jp.hotdrop.composeDesignApp.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.hotdrop.composeDesignApp.R

@Composable
fun AppDialogOnlyOk(
    message: String,
    dismissOnOutsideTap: Boolean,
    onOk: () -> Unit
) {
    var showDialog by remember { mutableStateOf(true) }
    if (!showDialog) {
        return
    }

    AlertDialog(
        onDismissRequest = {
            if (dismissOnOutsideTap) {
                showDialog = false
           }
        },
        confirmButton = {
            Button(onClick = {
                onOk()
                showDialog = false
            }) {
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
        dismissOnOutsideTap = true,
        onOk = {  }
    )
}