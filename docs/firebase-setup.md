# Firebase Setup (Manual)

## Required
1. Create Firebase project(s) and register Android app `az.bestgroup.app`.
2. Add SHA-1/SHA-256 as needed (Auth/App Check/Phone).
3. Download `google-services.json` into `app/` (gitignored, no secrets committed).
4. Enable **Authentication**: Email/Password, Phone (real provider/config required; no simulated OTP).
5. Create **Cloud Firestore** and deploy `firebase/firestore.rules`, `firebase/firestore.indexes.json`.
6. Enable **Cloud Storage** and deploy `firebase/storage.rules`; review quotas/billing for large files (5 GB target requires validation).
7. Enable **Firebase Cloud Messaging**; configure trusted backend/Cloud Functions for cross-user push delivery.
8. Enable **Firebase App Check** (Play Integrity prod, debug provider for dev) and enforce on supported services.
9. Implement trusted backend (Cloud Functions/Admin SDK) for: admin role assignment, notification fanout, audit logging, and privileged validations.

## Build note
`com.google.gms.google-services` plugin is prepared in version catalog but not applied in `app/build.gradle.kts` until `google-services.json` is present.
