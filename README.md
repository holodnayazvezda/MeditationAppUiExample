# MeditationAppUiExample

Пример интерфейса приложения для медитации на Kotlin и Jetpack Compose. Содержит приветственный экран, разделы сна и медитации, карточки и элементы управления музыкой.

## Сборка и запуск

Откройте корень проекта в Android Studio, установите Android SDK 36 и выполните синхронизацию Gradle. Используйте JDK, совместимый с версией Android Gradle Plugin проекта; настройки Java указаны в `app/build.gradle.kts`. Минимальная версия устройства — Android API 27.

Для сборки отладочного APK:

```sh
sh gradlew :app:assembleDebug
```

В Windows: `gradlew.bat :app:assembleDebug`. APK появится в `app/build/outputs/apk/debug/`. Для запуска выберите модуль `app` и устройство или эмулятор в Android Studio.

## Устройство проекта

Компоненты и экраны находятся в `app/src/main/java/com/example/meditattionappuiexample/ui/`, навигация — в `domain/navigation/`. Это демонстрация интерфейса; подключение внешней библиотеки аудиоконтента не входит в описанный сценарий.
