# Text

```kotlin
@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    style: TextStyle = LocalTextStyle.current
)
```

- Text는 고수준의 UI 요소로 단순히 글자의 표현 뿐만 아니라  의미와 접근성(accessibility) 정보도 함께 제공
- 아무런 Style을 지정하지 않으면 `MaterialTheme` 의 `LocalTextStyle` 값을 사용(기본 글꼴, 크기, 색상 등 설정을 담고 있음)
    - Custom Style을 적용하고자 할 땐 `copy()` 를 사용해서 기존 테마는 유지하고 수정이 필요한 부분만 변경하도록 할 수 있음 (다크모드 및 폰트 변경 시 유용)
- TextStyle의 주요 속성 일부를 Text의 매개변수로 직접 받을 수 있다

  > TextStyle의 생성자
  >

    ```kotlin
      constructor(
            color: Color = Color.Unspecified,
            fontSize: TextUnit = TextUnit.Unspecified,
            fontWeight: FontWeight? = null,
            fontStyle: FontStyle? = null,
            fontSynthesis: FontSynthesis? = null,
            fontFamily: FontFamily? = null,
            fontFeatureSettings: String? = null,
            letterSpacing: TextUnit = TextUnit.Unspecified,
            baselineShift: BaselineShift? = null,
            textGeometricTransform: TextGeometricTransform? = null,
            localeList: LocaleList? = null,
            background: Color = Color.Unspecified,
            textDecoration: TextDecoration? = null,
            shadow: Shadow? = null,
            textAlign: TextAlign? = null,
            textDirection: TextDirection? = null,
            lineHeight: TextUnit = TextUnit.Unspecified,
            textIndent: TextIndent? = null
        )
    ```


- 스타일 적용 우선 순위
    1. 파라미터에 직접 지정된 값
    2. 1번이 없을 시 TextStyle 객체에서 설정된 값
    3. 1,2번이 없을 시 LocalTextStyle에 설정된 값

       ex)  MaterialTheme.typegraphy.body1 등의 기본값


    ref) 색상의 같은 경우 없으면 LocalContentColor에서 가져온다


## 텍스트 구성 예시 코드

```kotlin
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
```

- text : 표시할 글자 입력
- Modifier : ⭐ 따로 정리
- color : 색상
- fontSize : 글씨 크기
- fontStyle : 폰트 스타일
- fontWeight : 굵기
- fontFamily : 글꼴
- letterSpacing : 자간
- textDecoration : 밑줄, 취소선, strikeThrough 등 장식
- textAlign : 글자 위치 배열
- lineHeight : 줄 간격
- overflow : 텍스트 잘림 (텍스트 공간이 넘어가면 어떻게 처리할지)
- softWrap : 줄 바꿈 (너비 끝에서 이어질지 줄을 바꿀지)
- maxLines : 최대 표시할 줄
- minLines: 최소 표시할 줄
- onTextLayout : 콜백
- style : 적용할 TextStyle

<img width="311" height="311" alt="Image" src="https://github.com/user-attachments/assets/0338df76-521a-43be-812d-a5b77e30438f" />

## 디자이너와 협업을 한다면?

- 디자이너가 정의한 TextStyle을 `ui/theme/Type` 하위에 TextStyle을 정의
- MaterialTheme.typography를 통해 관리 하는 방식이 보편적

> Pretendard 적용 예시
>

```kotlin
private val pretendardFontFamily = FontFamily(Font(R.font.pretendard))
private val defaultTypography = Typography()

val Typography = Typography(
    titleLarge = defaultTypography.titleLarge.copy(fontFamily = pretendardFontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = pretendardFontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = pretendardFontFamily),
    labelLarge = defaultTypography.labelLarge.copy(fontFamily = pretendardFontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = pretendardFontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = pretendardFontFamily),
    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = pretendardFontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = pretendardFontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = pretendardFontFamily),
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = pretendardFontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = pretendardFontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = pretendardFontFamily),
    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = pretendardFontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = pretendardFontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = pretendardFontFamily),
)
```

> 다른 속성도 변경
>

```kotlin
val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp
    )
)
```

- typography에 적용 후 Theme에 적용

```kotlin
MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
```

- 글자별 속성을 묶어서 관리 후 필요한 부분은 `copy()` 메서드로 변경하고자 하는 것만 인자로 전달