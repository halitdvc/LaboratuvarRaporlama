
# Laboratory Reporting Application

## Türkçe Açıklama

### Proje Adı: Laboratuvar Raporlama Uygulaması
Laboratuvar çalışanlarının hasta raporlarını yönetebileceği ve arama yapabileceği bir backend uygulaması.

### Özellikler
- Laborant ve raporlar için CRUD işlemleri.
- Hasta adı, kimlik numarası veya laborant adına göre arama.
- DTO kullanımı ve Hibernate ile dinamik sorgular.

### Kullanılan Teknolojiler
- Java 17
- Spring Boot (Data JPA, Web)
- PostgreSQL
- Lombok, MapStruct, Maven

### Başlangıç Adımları
1. Projeyi klonlayın:
   ```bash
   git clone <repository-url>
   ```
2. `application.properties` dosyasını PostgreSQL bilgileriyle güncelleyin.
3. Projeyi çalıştırın:
   ```bash
   mvn spring-boot:run
   ```

4. API Örnekleri:
   - Laborant Listeleme: `GET /api/laborants`
   - Rapor Arama: `GET /api/reports/search?patientName=Ahmet`

---

## English Description

### Project Name: Laboratory Reporting Application
A backend application to manage and search patient reports.

### Features
- CRUD operations for laboratory staff and patient reports.
- Search by patient name, identity number, or staff name.
- Uses DTOs and dynamic queries with Hibernate.

### Technologies Used
- Java 17
- Spring Boot (Data JPA, Web)
- PostgreSQL
- Lombok, MapStruct, Maven

### Getting Started
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Update the `application.properties` file with PostgreSQL details.
3. Run the project:
   ```bash
   mvn spring-boot:run
   ```

4. Example API Requests:
   - List Laboratory Staff: `GET /api/laborants`
   - Search Reports: `GET /api/reports/search?patientName=Ahmet`
