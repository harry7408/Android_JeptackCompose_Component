# Image

> Bitmap 이미지
> 

```kotlin
@Composable
@NonRestartableComposable
fun Image(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DefaultFilterQuality
)
```

> ImageVector 이미지
> 

```kotlin
@Composable
@NonRestartableComposable
fun Image(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
)
```

> painter 이미지
> 

```kotlin
@Composable
fun Image(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
)
```

- 시각적 요소인 이미지를 앱 화면에 제공하는 역할
- Legacy의 ImageView와 같은 역할
- 앱 로고, 아이콘, 배너, 사진 등을 사용자에게 나타내며 contentDescription으로 접근성을 제공한다

</br>

### Image 구성 예시

```kotlin
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
```

- painter : 가장 범용적인 버전으로 이미지를 그릴 수 있는 객체를 추상화한 Interface
- imageVetor : 벡터 기반 이미지 (XML 벡터 Drawable이 변환된 형태)
- bitmap : Android Graphics의 Bitmap을 Compose의 ImageBitmap으로 변환해 표시 (주로 로컬에서 만든 Bitmap이나 카메라 및 갤러리에서 불러온 이미지 활용)
- contentDescription : 접근성 기능에 제공할 텍스트
- modifier : Modifier로 크기, 위치, 배경, 등 레이아웃 조절
- alignment : 이미지 정렬하는 위치
- contentScale : 이미지의 영역 비율을 다룸
- alpha : 투명도 값 (0 ~ 1)
- colorFilter : 스크린에 랜더링 할 색상
- filterQuality : 비트맵 사용 시 샘플링 알고리즘 적용하기 위한 값

<img width="316" height="735" alt="Image" src="https://github.com/user-attachments/assets/77035cf9-80cd-4728-aed0-95edf6f213a0" />

</br>

## 디자이너와 협업을 한다면?

- 이미지를 어디에 어떤 비율 | 모양 | 상태로 보여줄지 명확하게 합의가 필요
- Image Component 자체의 파라미터보다는 Modifier의 역할이 더 중요한 것 같다
- 벡터 방식 vs 비트맵 방식
    - 벡터 방식 : 아이콘 및 심볼
    - 비트맵 방식 : 사진 및 썸네일
    

⭐ 주로 네트워크 상의 이미지를 활용하는 경우가 많아 Glide, Coil 등 라이브러리와 친숙해지는 것이 중요하다

→ `AsyncImage, rememberAsynImagePainter`
