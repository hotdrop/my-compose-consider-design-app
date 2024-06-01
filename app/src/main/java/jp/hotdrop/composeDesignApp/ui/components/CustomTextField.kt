package jp.hotdrop.composeDesignApp.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import jp.hotdrop.composeDesignApp.R

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hintLabel: String,
    modifier: Modifier = Modifier,
) {
    // TODO 複数行入力できてしまうので1行にする
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = hintLabel) },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray
        )
    )
}