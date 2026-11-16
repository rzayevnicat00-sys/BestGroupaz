#!/bin/sh

# Gradle start up script for POSIX generated for BestGroup.az scaffold.
# If gradle-wrapper.jar is missing, install Gradle 8.9+ or let Android Studio generate the wrapper.

APP_HOME=$(cd "${0%/*}" 2>/dev/null || echo .; pwd -P)
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar

if [ ! -f "$CLASSPATH" ]; then
  echo "gradle-wrapper.jar not found in gradle/wrapper/." >&2
  echo "Open the project in Android Studio to generate/sync the wrapper, or run: gradle wrapper" >&2
  exit 1
fi

DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

exec java $DEFAULT_JVM_OPTS -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
