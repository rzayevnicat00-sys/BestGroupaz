@rem Gradle startup script for Windows
@if "%DEBUG%"=="" @echo off
set APP_HOME=%~dp0
set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

if not exist "%CLASSPATH%" (
  echo gradle-wrapper.jar not found in gradle\wrapper\.
  echo Open the project in Android Studio to generate/sync the wrapper, or run: gradle wrapper
  exit /b 1
)

set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
