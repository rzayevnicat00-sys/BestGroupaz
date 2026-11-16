# Android Studio-da açmaq və önbaxış

## 1) Layihəni açmaq
1. Bu qovluğu kompüterinizə köçürün/yükləyin (məs: `BestGroupAz`).
2. **Android Studio** → `File > Open` → `/workspace/app` kök qovluğunu seçin (`settings.gradle.kts` olan qovluq).
3. "Trust Project" seçin.
4. Android Studio Gradle sync tələb edəcək.

## 2) Tələb olunan mühit
- Android Studio (son stabil, Ladybug/Koala+ uyumlu tövsiyə olunur)
- **JDK 17** (Android Studio bundled JBR/JDK 17 uyğun ola bilər)
- Android SDK: **API 35** (compile/target), Build-Tools uyğun versiya
- İnternet (Gradle, AGP, Compose, Firebase asılılıqlarını yükləmək üçün)

## 3) Gradle Wrapper
- Bu scaffold-da `gradle/wrapper/gradle-wrapper.properties`, `gradlew`, `gradlew.bat` var.
- `gradle/wrapper/gradle-wrapper.jar` **daxil edilməyib** (bu mühitdə avtomatik yaradıla bilmədi).
- Android Studio açanda sync zamanı wrapper-i bərpa/generate edə bilər; əgər tələb olunarsa:
  - Android Studio terminalında (Gradle quraşdırılıbsa): `gradle wrapper`
  - və ya `File > Sync Project with Gradle Files` / "Use local gradle distribution" ilə müvəqqəti sync edib sonra wrapper yaradın.
- Gradle versiyası: **8.9** (AGP 8.7.x ilə uyğun).

## 4) Firebase (build/runtime üçün)
- `app/google-services.json` **yoxdur** və repoya əlavə edilməməlidir (gitignored).
- Firebase Console-da `az.bestgroup.app` üçün konfiqurasiya yaradıb `google-services.json` faylını `app/` qovluğuna yerləşdirin.
- Bundan sonra `app/build.gradle.kts` daxilində Google Services plugin sətrini aktiv edin:
  - `alias(libs.plugins.google.services)` (hazırda kommentdədir)
- Firebase aktivləşdirmədən auth/firestore/storage/messaging real işləməyəcək; bu Phase 1 scaffold-dir.

## 5) Önbaxış (Preview) necə görmək
**A. Compose Preview (kod dizaynı):**
1. Sync uğurlu olduqdan sonra: `app/src/main/kotlin/az/bestgroup/app/core/navigation/AppNavHost.kt` və ya UI fayllarını açın.
2. Faylın yuxarısına/səviyyəsinə `@Preview` anotasiya funksiyası əlavə edib (məs. `@Preview(showBackground = true)` + `BestGroupTheme { ... }`) sağ paneldə **Split/Design** seçin.
3. Hazırda əsas ekranlar placeholder-dir; real dizayn Faza 2+ mərhələlərində tamamlanacaq.

**B. Emulatorda/cihazda işlətmək:**
1. `Tools > Device Manager` → API 34/35 emulator yaradın (Play Store image tövsiyə olunur, FCM/App Check üçün).
2. Run konfiqurasiyası: `app`.
3. `Run > Run 'app'` (və ya ▶).
4. Build uğurlu olarsa, Phase 1 placeholder naviqasiya ekranları görünəcək: Xoş gəlmisiniz → Auth gate scaffold → Customer/Admin scaffold.
5. Fiziki cihaz: USB debugging aktiv edin, cihazı seçib Run edin.

**C. APK çıxarmaq (mühit hazır olduqda):**
- Debug: `Build > Build Bundle(s) / APK(s) > Build APK(s)`
- CLI: `./gradlew :app:assembleDebug` (`gradle-wrapper.jar` mövcud olmalıdır)

## 6) Gözlənilən məhdudiyyətlər
- Firebase konfiqurasiyası olmadan real giriş, OTP, baza, yükləmə, bildirişlər işləməyəcək.
- Telefon OTP, push fanout, admin rol təyini və 5 GB yükləmə hədəfi xarici konfiqurasiya/backend/billing tələb edir və hazırda tamamlanmış funksiya kimi təqdim edilmir.
- Rəsmi BestGroup.az loqosu repoda yoxdur; placeholder launcher ikonası müvəqqətidir (orijinal loqo ilə əvəz edilməlidir, yenidən çəkilməməlidir).
