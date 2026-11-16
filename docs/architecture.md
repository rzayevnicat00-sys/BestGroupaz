# Architecture (Phase 1)

## Overview
- Native Android: Kotlin, Jetpack Compose, Material 3.
- Pattern: Clean Architecture + MVVM, unidirectional data flow.
- Async: Kotlin Coroutines + Flow/StateFlow.
- DI: Hilt.
- Navigation: Navigation Compose with role-aware graphs (root/onboarding/auth/customer/admin).
- Backend: Firebase Auth, Cloud Firestore, Cloud Storage, Cloud Messaging, App Check.

## Layers
- **UI/Presentation:** Compose screens/components, ViewModels, UI state/events. No direct Firebase business logic in Composables.
- **Domain:** Models, repository interfaces, use cases, validation/policy logic.
- **Data:** Repository implementations, Firebase data sources, DTO/mappers, local persistence (DataStore/Room only when justified).

## Module/feature boundaries (current single app module, package-by-feature)
- `core`: common, design system, navigation, utils, localization.
- `di`: Hilt modules/providers.
- `domain`: models, repositories, use cases (auth/services/orders/messaging/admin).
- `data`: remote firebase sources, dto/mappers, repositories, local.
- `ui`: onboarding, auth, customer, admin.

## Role separation
- Customer and Admin are separate UX flows; authorization enforced server-side via Auth + Security Rules + trusted backend for privileged actions.
