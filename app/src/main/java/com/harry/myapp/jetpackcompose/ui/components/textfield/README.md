# TextField

```kotlin
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource? = null,
    shape: Shape = TextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors()
)
```

- 사용자가 Text를 입력 및 수정할 수 있도록 해주는 기본 입력 Component
- xml의 EditText와 같은 역할을 하며 Compose 방식에 맞춰 State 기반으로 동작
- 보통 Form이나 Dialog에 나타난다
- Filled, Outlined TextField 중 활용에 따라 시각적 강조 효과가 다르다

## TextField 구성 예시

```kotlin
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
```

- value : 현재 입력 Field의 Text 값
- onValueChange : 값이 변경될 때 호출되는 Callback (새로운 입력 값이 파라미터로 전달)
- modifier : Modifier
- enabled : 입력이 가능한 여부 (false일 경우 입력이 불가능
- readOnly : 읽기 전용 모드로 값 변경 불가능
- textStyle : Text 스타일 적용 (Text Component 참고)
- label : TextField 영역에 보일 화면
- placeHolder : Focus를 갖고 값이 비어있을 때 표시할 화면 (XML의 Hint와 비슷한 역할을 하는 느낌)
- leadingIcon : Textfield 앞 쪽에 표시 할 아이콘
- trailingIcon : Textfield 뒤 쪽에 표시 할 아이콘
- prefix : 입력된 텍스트 앞에 항상 표시되는 내용 (국가 코드, 이메일 아이콘 등)
- suffix : 입력된 텍스트 뒤에 항상 표시되는 내용 (도메인, 단위 등)
- supportingText : Textfield 하단에 표시될 내용 (부가 설명, 오류 메세지 등)
- isError : 오류 상태 스타일 적용 (비밀번호 검증이 틀렸을 때, 이메일 형식이 올바르지 않을 때 등 활용)
- visualTransformation : 입력 값을 시각적으로 변환 (PasswordVisualTransformation 적용 시 비밀번호를 감춰준다)
- keyboardOptions : 가상 키보드 형태 (숫자 패드만, 이메일 형식, Text 입력 등)
- keyboardActions : IME 액션이 눌렸을 때 실행 할 동작 (다음, 완료, 검색, 전송 등등)
- singleLine : true인 경우 한 줄 입력만 허용
- maxLines : 최대 줄 수 제한
- minLines : 최소 줄 수 제한
- interactionSource : 클릭, 포커스 등 상호작용 상태를 관찰 하고자 할 때 사용
- shape : Textfield의 모서리 모양
    - TextFieldDefaults 참고
- colors : 텍스트, 라벨, 아이콘, 테두리 등 모든 색상 정보에 대한 모음
    - TextFieldDefaults 참고

https://github.com/user-attachments/assets/65757b28-ce85-467e-bfe7-4dec795fbadb

## OutlinedTextField

```kotlin
@Composable
fun OutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource? = null,
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors()
) 
```

- Material Design의 외곽선 스타일이 적용된 TextField
- 박스의 배경을 채우지 않고 테두리 선으로 구분한다
- 화면이 조밀하거나 과도한 시각적 강조를 피하고 싶을 때 활용
- 파라미터는 TextField와 동일

## BasicTextField

```kotlin
@Composable
fun BasicTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    interactionSource: MutableInteractionSource? = null,
    cursorBrush: Brush = SolidColor(Color.Black),
    decorationBox: @Composable (@Composable innerTextField: () -> Unit) -> Unit = @Composable { innerTextField -> innerTextField() }
): Unit
```

- 스타일이 없는 순수 입력기 (Material Component가 아니다)
- TextField와 달리 Label, Icon, PlaceHolder 등이 존재하지 않음
- Material Design을 따르지 않거나 TextField 내부를 세밀하게 제어 해야 할 때 활용 (Label, Icon 등이 들어가면 내부가 복잡해진다)

## 디자이너와 협업을 한다면?

- 우선 공통의 Component를 만들어서 **재활용 하도록 하는 것이 최우선 같다**

  > UI 관련 토큰 정의
  >

    ```kotlin
    object AppTextFieldTokens {
        val shape = RoundedCornerShape(12.dp)
    
        @Composable
        fun colors(
            isOutlined: Boolean = false
        ) = if (isOutlined) {
            TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                errorBorderColor = MaterialTheme.colorScheme.error,
            )
        } else {
            TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                errorContainerColor = MaterialTheme.colorScheme.surface,
            )
        }
    
        val contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp)
    }
    ```

  > 공통의 TextField Component 화
  >

    ```kotlin
    @Composable
    fun AppTextField(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        label: String? = null,
        placeholder: String? = null,
        leading: (@Composable () -> Unit)? = null,
        trailing: (@Composable () -> Unit)? = null,
        supportingText: String? = null,
        isError: Boolean = false,
        singleLine: Boolean = true,
        outlined: Boolean = false,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        keyboardActions: KeyboardActions = KeyboardActions.Default,
    ) {
        val colors = AppTextFieldTokens.colors(isOutlined = outlined)
        val shape = AppTextFieldTokens.shape
    
        val labelSlot = label?.let { { Text(it) } }
        val placeholderSlot = placeholder?.let { { Text(it) } }
        val supportingSlot = supportingText?.let { { Text(it) } }
    
        val common = modifier
            .defaultMinSize(minHeight = 48.dp)
            .padding(0.dp) // 내부 padding은 M3가 처리
    
        if (outlined) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = common,
                label = labelSlot,
                placeholder = placeholderSlot,
                leadingIcon = leading,
                trailingIcon = trailing,
                supportingText = supportingSlot,
                isError = isError,
                singleLine = singleLine,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                shape = shape,
                colors = colors
            )
        } else {
            TextField(
                value = value,
                onValueChange = onValueChange,
                modifier = common,
                label = labelSlot,
                placeholder = placeholderSlot,
                leadingIcon = leading,
                trailingIcon = trailing,
                supportingText = supportingSlot,
                isError = isError,
                singleLine = singleLine,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                shape = shape,
                colors = colors
            )
        }
    }
    ```

- Customizing을 많이 해야한다면 BasicTextField + DecorationBox를 사용해야 한다
- TextField는 키보드 옵션, keyboardAction 등이 달려있어 UI 적인 요소 뿐만 아니라 사용자 경험을 코드로 잘 녹여 내는 것도 중요해보인다.

## 래퍼런스

- 공식문서

  📎 [텍스트 필드 구성  |  Jetpack Compose  |  Android Developers](https://developer.android.com/develop/ui/compose/text/user-input?hl=ko&textfield=state-based)