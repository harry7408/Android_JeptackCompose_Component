package com.harry.myapp.jetpackcompose.ui.components.textfield

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harry.myapp.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun TextFieldSample() {

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("이메일") },
        placeholder = { Text("example@domain.com") },
        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
        trailingIcon = { Icon(Icons.Default.Clear, contentDescription = null) },
        prefix = { Text("✉ ") },
        suffix = { Text("@gmail.com") },
        supportingText = { Text("올바른 이메일을 입력하세요") },
        isError = text.isNotEmpty() && !text.contains("@"),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { /* 완료 버튼 클릭 시 동작 */ }
        ),
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Blue,
            unfocusedIndicatorColor = Color.Gray
        )
    )

}

@Preview
@Composable
private fun TextFieldSamplePreview() {
    JetpackComposeTheme {
        TextFieldSample()
    }
}