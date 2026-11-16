# Development Checklist

## Phase 1: Foundation
- [x] Proposed architecture, folder structure, dependencies, Firebase/schema/security plan, phased roadmap, and limitations documented
- [x] New Android project scaffold created (Gradle Kotlin DSL, version catalog, app module)
- [x] Kotlin + Jetpack Compose + Material 3 baseline configured (scaffold-level)
- [x] Hilt, Navigation Compose, Coroutines/Flow, Coil, DataStore, Firebase SDK dependencies declared
- [x] Clean Architecture package boundaries and core/domain/data/ui skeletons created
- [x] Design system baseline (colors, typography, theme, placeholder components direction)
- [x] Role-aware navigation shell scaffold (welcome/auth/customer/admin placeholders)
- [x] Localization baseline resources added (az default, en, ru)
- [x] Firebase rules/index templates added (`firebase/`)
- [x] Documentation added (`docs/`, README)
- [ ] Gradle wrapper generated and project compiled in Android environment (BLOCKED: no SDK/wrapper/toolchain here)
- [ ] `google-services.json` added and Google Services plugin applied (BLOCKED: external Firebase config)
- [ ] Firebase/App Check/emulators connected and validated (BLOCKED: external setup)

## Phase 2: Authentication
- [ ] Onboarding + 3-slide welcome flow
- [ ] Registration (all fields, validation, terms)
- [ ] Firebase email/password auth
- [ ] Email verification + resend
- [ ] Password recovery/reset
- [ ] Secure session persistence and sign out
- [ ] Real phone OTP verification (BLOCKED until provider configured)
- [ ] Role-based post-auth routing (verified user + trusted role)

## Phase 3: Customer Application
- [ ] Firestore-driven home dashboard (greeting, avatar, notifications, search, categories, popular, active orders, activity, support, announcements, promotions)
- [ ] Database-driven services catalog/details (10 initial categories)
- [ ] Multi-step order creation + unique order IDs + history
- [ ] Order list/detail and status tracking
- [ ] Functional profile (edit, photo upload, password, language, theme, deletion request)

## Phase 4: Admin Application
- [ ] Authorized admin access (trusted role only)
- [ ] Admin dashboard statistics
- [ ] Customer management
- [ ] Service management (CRUD/pricing/availability/images)
- [ ] Order management (status/price/notes/completed files/history)

## Phase 5: Communication
- [ ] Real-time support chat (independent of orders)
- [ ] Conversations list, unread counts, timestamps, attachments
- [ ] Read receipts and presence (heartbeat/lastActive)
- [ ] Admin messaging interface

## Phase 6: Cloud Services
- [ ] Resumable/chunked large file uploads with progress/retry/cancel (5 GB target requires infra validation)
- [ ] FCM push + in-app notification center + deep links
- [ ] Announcements and stories (admin publish, customer visibility)

## Phase 7: Finalization
- [ ] Security audit and hardened rules
- [ ] Performance optimization and pagination
- [ ] Automated tests (unit/integration/UI/rules) and build verification
- [ ] UI refinement and production readiness review

## Discovered errors / blockers
- [ ] Cannot run Gradle/AGP build in current environment (no Android SDK/Gradle wrapper/JDK toolchain evidence)
- [ ] Cannot integrate runtime Firebase without `google-services.json` and enabled services
- [ ] Phone OTP, push fanout, admin role assignment, and 5 GB upload guarantees depend on external configuration/backend/billing

## Required manual configuration
- [ ] Add official BestGroup.az logo assets (preserve original proportions/colors; do not recreate)
- [ ] Provide Firebase `google-services.json` and enable required Firebase products/App Check
- [ ] Deploy and test security rules/indexes (emulator + staging)
- [ ] Implement/configure trusted backend (Cloud Functions/Admin SDK) for privileged operations and notifications
