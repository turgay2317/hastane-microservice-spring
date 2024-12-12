# HastaneApp

## 0. Ön Kabuller ve Tercihler
- Projenin daha modüler çalışması ve ileride daha ayrık bir biçimde geliştirilebilmesi için **mikroservis mimarisi** kullanılmıştır.
- Nesneler arası coupling mümkün olduğunca _asgari düzeyde_ tutulmaya çalışılmıştır.
- Modellerde TC ya da hastaneNo gibi bilgiler primary key olarak seçilmemiş, **_ayrı bir ID_** sütunu oluşturulmuştur.
- Mikroservise ait request ve responselar için **özelleştirilmiş DTO'lar** kullanılmıştır.
- Declerative yapısı nedeniyle mikroservisler arası haberleşme için OpenFeign terchi edildi.
---

## 1. Mikroservisler
- **LaborantMicroservice:9090**: Laborant ile ilgili mikorservis.
- **PatientMicroservice:9091**: Hastalar ile ilgili mikroservis.
- **ReportMicroservice:9092**: Hasta-Laborant ilişkisi içeren tanı/teşhis rapor mikroservisi.
---

## 2. Uygulama Yapısı
HastaneApp aşağıdaki bileşenlerden oluşuyor:
- **config/RestApis.java**: Endpointler burada tanımlandı.
- **Controller**: HTTP istekleri ve yanıtlanması.
- **DTO (Data Transfer Object)**: Veri taşınması ve haberleşme objeleri. Request ve Response DTO olarak ikiye ayırdım. Daha modüler olması için.
- **Mapper**: DTO ile Model arasında dönüşüm.
- **Model**: Veritabanı nesneleri.
- **Repository**: Veritabanı işlemleri.
- **Service**: İş mantığı.
- **Specifications**: Sorgular için kriter (Arama sorgularında kullandım).

---

## 3. Çalıştırma

1. Uygulamayı başlatmak için proje dizinine geçiş yapalım.

```console
cd Hastane && ls
LaborantMicroservice	PatientMicroservice	README.md		ReportMicroservice
```

2. LaborantMikroservice çalıştıralım. Çalışması için gerekli environment değişikenlerini parametre olarak veriyoruz.

```console
cd LaborantMicroservice
mvn spring-boot:run -Dspring-boot.run.arguments="DATABASE_URL=jdbc:mysql://localhost:3306/LaborantDB;DATABASE_USER=root;DATABASE_PASSWORD=password"
```

3. PatientMicroservice çalıştıralım. Çalışması için gerekli environment değişikenlerini yine parametre olarak veriyoruz.

```console
cd ..
cd PatientMicroservice
mvn spring-boot:run -Dspring-boot.run.arguments="DATABASE_URL=jdbc:mysql://localhost:3306/PatientDB;DATABASE_USER=root;DATABASE_PASSWORD=password"
```

4. ReportMicroservice en son çalıştırılmalıdır, çünkü verileri diğer iki mikroservise bağımlı durumdadır.

```console
cd ..
cd ReportMicroservice
mvn spring-boot:run -Dspring-boot.run.arguments="DATABASE_URL=jdbc:mysql://localhost:3306/ReportDB;DATABASE_USER=root;DATABASE_PASSWORD=password"
```

---

## 4. Endpointler ve SwaggerUI
Mikroservislere ait tüm endpointler aşağıda listelenmiştir.
Ayrıca SwaggerUI ile aşağıdaki url'lerden kolayca istek gönderilebilir.

1. LaborantMicroservice <br>
   **localhost:9090/swagger-ui/index.html**<br>
   GET /dev/v1/laborant/<br>
   POST /dev/v1/laborant/<br>
   GET /dev/v1/laborant/{id}<br>
   GET dev/v1/laborant/?laborantName=ali<br>
   GET dev/v1/laborant/?laborantSurname=can<br>
   GET dev/v1/laborant/?laborantName=Veli&laborantSurname=Can&hospitalID=30505<br>
2. PatientMicroservice<br>
**localhost:9091/swagger-ui/index.html**<br>
GET /dev/v1/patient<br>
POST /dev/v1/patient<br>
GET /dev/v1/patient/{id}<br>
GET dev/v1/patient/?patientName=ali<br>
GET dev/v1/patient/?patientSurname=can<br>
GET dev/v1/patient/?patientName=Veli&patientSurname=Can&patientTC=10020030045<br>
3. ReportMicroservice<br>
**localhost:9092/swagger-ui/index.html**<br>
GET /dev/v1/report/<br>
PUT /dev/v1/report/<br>
POST /dev/v1/report/<br>
GET /dev/v1/report/{id}<br>
DELETE /dev/v1/report/{id}<br>