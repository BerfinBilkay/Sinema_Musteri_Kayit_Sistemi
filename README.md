# Sinema Müşteri Kayıt Sistemi

## Proje Açıklaması
Bu proje, bir sinema sistemi için müşteri, film ve salon yönetimini sağlayan konsol tabanlı bir uygulamadır. Java programlama dili kullanılarak geliştirilmiş olan bu uygulama, kullanıcıların yeni müşteri, film ve salon tanımlamaları yapmasına, filmleri ve salonlardaki müşteri listesini görüntülemesine olanak tanır.

### Genel Özellikler:
- *Müşteri, Film ve Salon Yönetimi:* Yeni müşteriler, filmler ve salonlar kolayca sisteme eklenebilir.
- *Film Detayları:* Filmlerin adı, süresi ve türü görüntülenebilir. Ayrıca, hangi salonlarda gösterildiği listelenir.
- *Salon ve Müşteri İlişkisi:* Belirli bir salondaki filme kayıtlı müşterilerin listesi görüntülenebilir.
- *OOP Kullanımı:* Temel sınıflar, miras ve çok biçimlilik gibi nesne yönelimli programlama prensiplerini kullanır.
- *Interface Kullanımı:* Projede bir interface kullanılarak esnek bir tasarım sağlanmıştır.

---

## Teknik Detaylar
### Kullanılan Sınıflar:
1. *BaseEntity:* Ortak özellikler (örneğin, id, ad) ve metotları içerir.
2. *Musteri:* Müşteri bilgilerini tutar. BaseEntity sınıfını miras alır.
3. *Salon:* Salon bilgilerini tutar. BaseEntity sınıfını miras alır.
4. *Film:* Film bilgilerini (ad, süre, tür) tutar.

### Kullanılan Interface:
- *IKayit:* Yeni müşteri veya film kaydı için kullanılacak metotları tanımlar.

### Polymorphism:
- BilgiGoster() metodu BaseEntity sınıfında tanımlanmış olup, türetilmiş sınıflarda (Musteri ve Salon) kendi özelliklerine göre özelleştirilmiştir.

---

## Kullanım
### Uygulama Başlatıldığında:
1. Yeni müşteri ekleyebilirsiniz.
2. Yeni film ekleyebilirsiniz.
3. Yeni salon tanımlayabilirsiniz.
4. Filmlerin detaylarını ve hangi salonlarda gösterildiğini listeleyebilirsiniz.
5. Belirli bir salon için kayıtlı müşteri listesini görüntüleyebilirsiniz.
