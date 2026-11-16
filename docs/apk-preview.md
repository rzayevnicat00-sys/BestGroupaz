# APK və UI önizləmə (Phase 1)

## APK statusu (bu mühit)
**Hazır, quraşdırıla bilən `.apk` faylı bu Cloud mühitində yaradılmadı.**

Səbəblər:
- Android SDK/Build-Tools-in tam (compileSdk 35 üçün uyğun) quraşdırılması bu mühitdə mümkün olmadı (şəbəkə/mənbə məhdudiyyətləri səbəbindən `platforms;android-35` və `build-tools;35.0.0` tam endirilmədi).
- Gradle asılılıqları (AGP 8.7.3, Kotlin, Compose, Firebase, Hilt və s.) Maven/Google repozitoriyalarından endirilməli olduğu üçün offline/build bu mühitdə tamamlanmadı.
- Emulator/cihaz və imzalama/işlətmə yoxlaması yoxdur.

**Bu, məhdudiyyətdir; saxta və ya işləməyən APK təqdim edilmir.**

## APK-nı necə hazırlamaq (Android Studio / lokal SDK mühitində)
1. Reponu klonlayın: `git clone https://github.com/rzayevnicat00-sys/BestGroupaz.git` və `kilo/woodsy-harbor-558` branch-nı açın.
2. Android Studio → `File > Open` → kök qovluq.
3. JDK 17, Android SDK **API 35** və uyğun Build-Tools quraşdırın; `local.properties` daxilində `sdk.dir` yolunu təyin edin (nümunə: `local.properties.example`).
4. İnternet ilə `File > Sync Project with Gradle Files`.
5. Debug APK:
   - UI: `Build > Build Bundle(s) / APK(s) > Build APK(s)`
   - CLI: `./gradlew :app:assembleDebug`
6. Çıxış faylı: `app/build/outputs/apk/debug/app-debug.apk`
7. Qeyd: `app/google-services.json` olmadıqda Firebase inteqrasiyası işləməyəcək; Google Services plugin `app/build.gradle.kts`-də hazırda şərhdir (konfiqurasiya əlavə edildikdən sonra aktiv edin).

## Phase 1 UI önizləmə (placeholder axın)
Cari scaffold-da funksional istehsal ekranları deyil, arxitektura/naviqasiya placeholder-ları var:

1. **Xoş gəlmisiniz** — `Akademik və Peşəkar Dəstəyin Etibarlı Ünvanı.`; status `Təməl arxitektura hazırlandı (Faza 1)`; `[Davam et]`
2. **Auth gate scaffold** — `Daxil ol / Qeydiyyat`; Firebase sessiya/email/telefon doğrulama və rol yönləndirməsi Faza 2-də; `[Ana səhifə]`
3. **Customer scaffold** — `Ana səhifə`; kataloq/sifariş/mesaj/profil strukturu, Firestore-driven real məlumat Faza 3-də; `[Admin scaffold]`
4. **Admin scaffold** — admin paneli Faza 4-də; icazələr Firebase Auth + Security Rules ilə; `[Xoş gəlmisiniz]`

Lokalizasiya: az (default), en, ru. Tema: Material 3 light/dark skeleton.

## Compose Preview
Android Studio-da sync/build mühiti hazır olduqda: `app/src/main/kotlin/az/bestgroup/app/core/designsystem/component/PhasePreview.kt` → **Split/Design** → `BestGroup.az - Phase 1`.
