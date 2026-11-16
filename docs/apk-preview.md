# APK və UI önizləmə (Phase 1)

## APK statusu
Bu mühitdə **real APK build etmək mümkün olmadı**:
- Android SDK / Build-Tools yoxdur (`ANDROID_HOME` təyin edilməyib)
- JDK/Java toolchain mövcud deyil
- Emulator/cihaz yoxdur

Buna görə burada hazır `.apk` faylı yaradıla bilməz. APK-nı Android Studio və ya SDK quraşdırılmış mühitdə aşağıdakı kimi yaratmaq olar:
1. Layihəni Android Studio-da açın və Gradle Sync tamamlayın.
2. `Build > Build Bundle(s) / APK(s) > Build APK(s)` seçin.
3. Nəticə: `app/build/outputs/apk/debug/app-debug.apk`

## Phase 1 UI önizləmə (placeholder axın)
Cari scaffold-da funksional istehsal ekranları deyil, arxitektura/naviqasiya placeholder-ları var:

1. **Xoş gəlmisiniz**
   - Başlıq: `Xoş gəlmisiniz`
   - Mətn: `Akademik və Peşəkar Dəstəyin Etibarlı Ünvanı.`
   - Status: `Təməl arxitektura hazırlandı (Faza 1)`
   - Düymə: `Davam et` → Auth gate

2. **Auth gate scaffold (Daxil ol / Qeydiyyat)**
   - Qeyd: Firebase sessiya, email/telefon doğrulama və rol yönləndirməsi Faza 2-də.
   - Düymə: `Ana səhifə` → Customer scaffold

3. **Customer scaffold (Ana səhifə)**
   - Kataloq/sifariş/mesaj/profil üçün struktur hazırlanıb; Firestore-driven real məlumat Faza 3-də.
   - Düymə: `Admin scaffold`

4. **Admin scaffold**
   - Admin paneli, idarəetmə və qaydalar Faza 4-də; icazələr Firebase Auth + Security Rules ilə təmin ediləcək.
   - Düymə: geri `Xoş gəlmisiniz`

## Compose Preview
Android Studio-da `app/src/main/kotlin/az/bestgroup/app/core/designsystem/component/PhasePreview.kt` faylını açıb **Split/Design** rejimində `BestGroup.az - Phase 1` preview-nu görmək olar (sync/build mühiti hazır olduqda).
