# Security Architecture Notes (Phase 1)

- Deny-by-default Firestore/Storage rules; refine before production deployment.
- Client UI is not an authorization boundary. Enforce access in Firebase Auth + rules + trusted backend.
- **Admin roles:** never client-assignable. Use custom claims/Admin SDK/Cloud Functions or controlled console process.
- Customers may access only their own user profile, orders, conversations, and notifications.
- Do not store passwords manually; use Firebase Auth only.
- Store files in Cloud Storage with metadata in Firestore; never Base64 for primary file/image storage.
- App Check required to reduce abuse; rate limiting/throttling via backend where appropriate.
- Sensitive actions (role/status/price/notifications/audit) should be validated or emitted by trusted backend.
- Templates in `firebase/` are initial scaffolds and must be hardened and tested with emulator/rules tests.
