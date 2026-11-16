# Android Studio-da açmaq və önbaxış (addım-addım)

## 1) Layihəni açmaq
1. Repo-nu klonlayın və ya ZIP kimi endirin:
   - `git clone https://github.com/rzayevnicat00-sys/BestGroupaz.git`
   - Branch: `kilo/woodsy-harbor-558` (Phase 1 scaffold)
2. **Android Studio** → `File > Open` → kök qovluğu seçin (`settings.gradle.kts` olan qovluq).
3. "Trust Project" seçin.

## 2) Tələb olunan mühit
- Android Studio (son stabil)
- **JDK 17**
- Android SDK: **API 35** (compile/target) + uyğun Build-Tools
- İnternet (Gradle/AGP/Compose/Firebase asılılıqları üçün)

## 3) Gradle Sync / Wrapper
- Layihədə `gradlew`, `gradlew.bat`, `gradle/wrapper/gradle-wrapper.properties` və `gradle-wrapper.jar` mövcuddur (Gradle 8.9).
- Açdıqdan sonra `File > Sync Project with Gradle Files` edin.
- Problem olarsa: `Settings > Build > Build Tools > Gradle` bölməsində JDK 17 və Gradle wrapper seçildiyini yoxlayın.

## 4) Firebase (real işləmə üçün, manual)
- `app/google-services.json` yoxdur (gitignored). Firebase Console-da `az.bestgroup.app` üçün yaradıb `app/` qovluğuna yerləşdirin.
- `app/build.gradle.kts` daxilində bu sətri aktiv edin:
  - `alias(libs.plugins.google.services)`
- Auth (Email/Password, Phone), Firestore, Storage, FCM, App Check aktivləşdirin; `firebase/firestore.rules`, `firebase/storage.rules`, `firebase/firestore.indexes.json` deploy edin.
- Push bildirişləri, admin rol təyini və audit üçün Cloud Functions/Admin SDK (trusted backend) tələb olunur.
- 5 GB yükləmə hədəfi billing/kvota və infrastrukturla ayrıca doğrulanmalıdır.

## 5) UI önizləmə (Compose Preview)
1. Sync tamamlandıqdan sonra `app/src/main/kotlin/az/bestgroup/app/core/designsystem/component/PhasePreview.kt` faylını açın.
2. Sağ yuxarıdan **Split** və ya **Design** seçin.
3. `BestGroup.az - Phase 1` preview görünəcək (placeholder naviqasiya axını, Material 3 tema).
4. İstəyə görə digər Compose fayllarında `@Preview` əlavə edib önbaxış edə bilərsiniz.

## 6) Emulatorda/cihazda işlətmək
1. `Tools > Device Manager` → API 34/35 emulator yaradın (FCM/App Check üçün Play Store image tövsiyə).
2. Run konfiqurasiyası: `app` → `Run > Run 'app'` (▶).
3. **Phase 1 placeholder axını:**
   - Xoş gəlmisiniz (`Akademik və Peşəkar Dəstəyin Etibarlı Ünvanı.`) → `Davam et`
   - Auth gate scaffold (Daxil ol/Qeydiyyat, Faza 2 qeyd) → `Ana səhifə`
   - Customer scaffold (Faza 3 qeyd) → `Admin scaffold`
   - Admin scaffold (Faza 4 qeyd, qaydalarla icazə)
4. Fiziki cihaz: USB debugging aktiv edib cihazı seçin və Run edin.

## 7) APK yaratmaq (SDK quraşdırılmış mühitdə)
- UI: `Build > Build Bundle(s) / APK(s) > Build APK(s)`
- CLI: `./gradlew :app:assembleDebug`
- Çıxış: `app/build/outputs/apk/debug/app-debug.apk`

## 8) Cari məhdudiyyətlər
- Bu repo Phase 1 scaffold-dır: real Firebase inteqrasiyası, auth/OTP, Firestore məlumatları, sifariş/mesaj/yükləmə/bildiriş/admin funksiyaları tamamlanmayıb.
- Real telefon OTP, push fanout, admin rol təyini, 5 GB yükləmə və istehsal təhlükəsizliyi xarici konfiqurasiya/backend/billing tələb edir.
- Rəsmi BestGroup.az loqosu daxil edilməyib; placeholder launcher ikonası orijinal loqo ilə əvəz olunmalıdır.
