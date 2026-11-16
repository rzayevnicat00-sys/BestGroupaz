# Technical Limitations / Blockers (as of Phase 1 scaffold)

- **Build environment:** No Android SDK, Gradle wrapper, or verified Android toolchain in `/workspace/app`; `assembleDebug`, lint, and instrumented/UI tests cannot be executed here yet.
- **Firebase config:** Missing `app/google-services.json`; Firebase services cannot initialize or be validated at runtime.
- **Phone verification:** Real 6-digit OTP requires configured Firebase Phone Auth/provider verification; no simulation implemented.
- **Push notifications:** Real cross-user push requires FCM server-side/Cloud Functions; client-only generation is not possible.
- **Privileged admin operations:** Role assignment and some secure workflows require trusted backend (Cloud Functions/Admin SDK).
- **Large uploads (5 GB target):** Feasible only with correct Storage resumable upload implementation, Android background/upload constraints handled, and sufficient Firebase billing/quotas; must be validated in configured infrastructure.
- **Presence/read receipts:** Require realtime listeners + heartbeat/lastActive strategy; not yet implemented.
- **Logo/assets:** Official BestGroup.az logo not provided in repo; placeholder launcher foreground used (must be replaced without modifying original logo asset).

These items are reported explicitly and are not represented as completed functionality.
