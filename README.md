# BestGroup.az Android (Phase 1 Foundation)

Native Android application scaffold for BestGroup.az using Kotlin, Jetpack Compose, Material 3, MVVM, Clean Architecture principles, Hilt, Navigation Compose, Coroutines/Flow, and Firebase SDK dependencies.

## Current status
- **Phase 1 in progress:** architecture, folder structure, Gradle/config scaffolding, design system baseline, navigation shell, localization baseline (az/en/ru), Firebase security/rules templates, and documentation started.
- **Not yet implemented:** real Firebase integration/runtime, authentication flows, Firestore-backed features, role enforcement in production rules deployment, file upload pipeline, messaging, notifications, admin/customer production screens, and automated verification in a configured Android environment.

## Environment limitations (this workspace)
- No Android SDK, Gradle wrapper, or verified JDK/AGP toolchain detected in `/workspace/app`.
- No `app/google-services.json` provided.
- Firebase-dependent behavior, phone OTP, push delivery, and 5 GB upload feasibility require external Firebase/project/billing/backend configuration and cannot be validated here.

## Manual setup required
1. Install Android Studio / Android SDK (API 35), JDK 17, and Gradle wrapper (`gradle wrapper`).
2. Create Firebase project and Android app (`az.bestgroup.app`).
3. Download `google-services.json` to `app/` (do not commit secrets).
4. Enable Auth (Email/Password, Phone), Firestore, Storage, FCM, App Check.
5. Deploy `firebase/firestore.rules`, `firebase/storage.rules`, and `firebase/firestore.indexes.json`.
6. Configure trusted backend/Cloud Functions for admin role assignment, notifications fanout, and audit-sensitive operations.

## Build
After environment and Firebase setup:
```bash
./gradlew :app:assembleDebug
./gradlew test lint
```

See `docs/` for architecture, schema, security notes, and the development checklist.
