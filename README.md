# SwipeSnack 🍫

**SwipeSnack** — это лёгкая Jetpack Compose библиотека для кастомных Snackbar с поддержкой:
- свайпа для скрытия,
- кастомизации иконки, текста и экшенов,
- автоматического исчезновения по таймеру,
- удобного API через `SnackSwipeBox`.
  
[![](https://jitpack.io/v/senseiiii12/CustomSnackBarLibrary.svg)](https://jitpack.io/#senseiiii12/CustomSnackBarLibrary)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.24-blue.svg)
![Compose](https://img.shields.io/badge/Compose-1.5.3-blue.svg)

## 1. Подключение репозитория

Библиотека доступна через JitPack.
Добавьте репозиторий JitPack в ваш settings.gradle.kts:
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```
 Add the dependency in `build.gradle.kts`
```kotlin
dependencies {
    implementation 'com.github.senseiiii12:CustomSnackBarLibrary:0.2.0'
}
```
## 2. Использование
### Оборачиваем экран в `SnackSwipeBox`

SnackSwipeBox создаёт SnackSwipeController и размещает хост для отображения snackbar.
Контроллер пробрасывается в контент, и через него можно показывать сообщения.
```kotlin
SnackSwipeBox { snackSwipeController ->
    Column( // you any content
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                snackSwipeController.showSnackSwipe(
                    messageText = {
                        Text(
                            text = "It`s custom SnackSwipe",
                            color = Color.White
                        )
                    },
                    icon = {
                        Icon(
                            Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = Color.Green
                        )
                    },
                    customAction = {
                        Text(
                            text = "Send",
                            modifier = Modifier.clickable {},
                            color = Color.White
                        )
                    },
                    dismissAction = {
                        IconButton(onClick = { snackSwipeController.close() }) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        ) {
            Text("Show SnackSwipe")
        }
    }
}
```
### `SnackSwipeController`
Методы для управления snackbar:
```kotlin
fun SnackSwipeController.showSnackSwipe(
    messageText: @Composable () -> Unit,
    icon: (@Composable () -> Unit)? = null,
    customAction: (@Composable () -> Unit)? = null,
    dismissAction: (@Composable (() -> Unit))? = null,
    backgroundColor: Color = Color.Black,
    durationMillis: Long = 3000,
    shape: Shape = RoundedCornerShape(12.dp),
    elevation: Dp = 6.dp,
    innerPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
    outerPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 12.dp)
) 

fun close()
```

