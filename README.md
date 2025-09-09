# SwipeSnack 🍫

**SwipeSnack** - is a lightweight Jetpack Compose library for custom Snackbars with support for:
- Swipe to hide,
- Icon, text and actions customization,
- Auto-disappear on timer,
- Convenient API via `SnackSwipeBox`.
  
[![](https://jitpack.io/v/senseiiii12/CustomSnackBarLibrary.svg)](https://jitpack.io/#senseiiii12/CustomSnackBarLibrary)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.24-blue.svg)
![Compose](https://img.shields.io/badge/Compose-1.5.3-blue.svg)

## 1. Connecting a repository

The library is available via JitPack.
Add the JitPack repository to your `settings.gradle.kts`:
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
## 2. Usage
### Wrap the screen in `SnackSwipeBox`

SnackSwipeBox creates a SnackSwipeController and places a host to display the snackbar.
The controller is passed into the content, and messages can be displayed through it.
```kotlin
SnackSwipeBox { snackSwipeController ->
    Column( // you any content
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                snackSwipeController.showSnackSwipe(  //show SnackSwipe
                    messageText = {
                        Text(
                            text = "It`s custom SnackSwipe",
                            color = Color.White
                        )
                    },
                    dismissAction = {
                        IconButton(onClick = { snackSwipeController.close() }) {  //close action SnackSwipe
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
Methods for managing the snackbar:
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

