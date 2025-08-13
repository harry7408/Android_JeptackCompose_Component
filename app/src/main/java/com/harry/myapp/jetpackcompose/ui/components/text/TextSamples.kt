package com.harry.myapp.jetpackcompose.ui.components.text

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.harry.myapp.jetpackcompose.ui.theme.JetpackComposeTheme

/**
 * 기본 Text
 * 다른 파라미터들은 Default 값이 선언 되어있으나 Text Field는 사용자 정의가 필요
 * 아무런 Style을 지정하지 않으면 MaterialTheme의 LocalTextStyle 값을 사용
 */
@Composable
fun Text() {
    Text(
        text = "Various Text Styles \n ABCD \n EFGH",
        modifier = Modifier,
        color = Color.Cyan,
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 2.sp,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        lineHeight = 100.sp,
        overflow = TextOverflow.Ellipsis,
        softWrap = true,
        maxLines = 2,
        minLines = 1,
        onTextLayout = {},
        style = LocalTextStyle.current
    )
}


@Preview
@Composable
private fun TextPreview() {
    JetpackComposeTheme {
        Text()
    }
}

