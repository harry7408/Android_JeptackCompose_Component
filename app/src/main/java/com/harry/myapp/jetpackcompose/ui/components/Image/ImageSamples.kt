package com.harry.myapp.jetpackcompose.ui.components.Image


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harry.myapp.jetpackcompose.R
import com.harry.myapp.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun ImageSample() {
    Image(
        painter = painterResource(id = R.drawable.picture),
        contentDescription = "이미지에 대한 설명",
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        alpha = 1f,
        colorFilter = null,
    )
}

@Preview
@Composable
private fun ImageSamplePreview() {
    JetpackComposeTheme {
        ImageSample()
    }
}