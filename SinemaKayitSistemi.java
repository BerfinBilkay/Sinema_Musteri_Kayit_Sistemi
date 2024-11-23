import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Temel sınıf
abstract class BaseEntity {
    protected int id; // Ortak ID alanı
    protected String ad; // Ortak ad alanı

    public BaseEntity(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    // Tüm alt sınıflar için özelleştirilecek bir metod
    public abstract void bilgiGoster();
}

// Kayıt işlemleri için bir interface
interface IKayit {
    void kaydet(); // Kayıt işlemini zorunlu hale getirir
}

// Musteri sınıfı: BaseEntity sınıfından türetilmiştir
class Musteri extends BaseEntity implements IKayit {
    public Musteri(int id, String ad) {
        super(id, ad);
    }

    // Müşteri bilgilerini gösterir
    @Override
    public void bilgiGoster() {
        System.out.println("Müşteri ID: " + id + ", Ad: " + ad);
    }

    // Müşteri kayıt işlemi
    @Override
    public void kaydet() {
        System.out.println("Müşteri kaydedildi: " + ad);
    }
}

// Film sınıfı: Filmlere özel bilgiler içerir
class Film {
    private String ad; // Film adı
    private int sure;  // Film süresi (dakika)
    private String tur; // Film türü

    public Film(String ad, int sure, String tur) {
        this.ad = ad;
        this.sure = sure;
        this.tur = tur;
    }

    // Getter metodları
    public String getAd() {
        return ad;
    }

    public int getSure() {
        return sure;
    }

    public String getTur() {
        return tur;
    }

    // Film bilgilerini gösterir
    public void bilgiGoster() {
        System.out.println("Film Adı: " + ad + ", Süre: " + sure + " dk, Tür: " + tur);
    }
}

// Salon sınıfı: BaseEntity'den türetilmiş ve IKayit interface'ini uygular
class Salon extends BaseEntity implements IKayit {
    private List<Film> filmler; // Salonda oynatılan filmlerin listesi
    private List<Musteri> musteriler; // Salona kayıtlı müşterilerin listesi

    public Salon(int id, String ad) {
        super(id, ad);
        this.filmler = new ArrayList<>();
        this.musteriler = new ArrayList<>();
    }

    // Filme ekleme işlemi
    public void filmEkle(Film film) {
        filmler.add(film);
        System.out.println("Film eklendi: " + film.getAd());
    }

    // Müşteri ekleme işlemi
    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
        System.out.println("Müşteri salona eklendi: " + musteri.ad);
    }

    // Salondaki filmleri listeler
    public void listeleFilmler() {
        System.out.println("Salon: " + ad + " için filmler:");
        for (Film film : filmler) {
            film.bilgiGoster();
        }
    }

    // Salondaki müşterileri listeler
    public void listeleMusteriler() {
        System.out.println("Salon: " + ad + " için müşteriler:");
        for (Musteri musteri : musteriler) {
            musteri.bilgiGoster();
        }
    }

    // Salon bilgilerini gösterir
    @Override
    public void bilgiGoster() {
        System.out.println("Salon ID: " + id + ", Ad: " + ad);
    }

    // Salon kayıt işlemi
    @Override
    public void kaydet() {
        System.out.println("Salon kaydedildi: " + ad);
    }
}

// Ana uygulama
public class SinemaKayitSistemi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Veri listeleri
        List<Musteri> musteriler = new ArrayList<>(); // Müşteri listesi
        List<Film> filmler = new ArrayList<>(); // Film listesi
        List<Salon> salonlar = new ArrayList<>(); // Salon listesi

        // Ana menü döngüsü
        while (true) {
            System.out.println("\n--- Sinema Kayıt Sistemi ---");
            System.out.println("1. Yeni Müşteri Ekle");
            System.out.println("2. Yeni Film Ekle");
            System.out.println("3. Yeni Salon Ekle");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Salonlara Kayıtlı Müşterileri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Boşluğu temizle

            switch (secim) {
                case 1: // Yeni müşteri ekleme
                    System.out.print("Müşteri Adı: ");
                    String musteriAd = scanner.nextLine();
                    Musteri musteri = new Musteri(musteriler.size() + 1, musteriAd);
                    musteriler.add(musteri);
                    musteri.kaydet();
                    break;

                case 2: // Yeni film ekleme
                    System.out.print("Film Adı: ");
                    String filmAd = scanner.nextLine();
                    System.out.print("Film Süresi (dk): ");
                    int sure = scanner.nextInt();
                    scanner.nextLine(); // Boşluğu temizle
                    System.out.print("Film Türü: ");
                    String tur = scanner.nextLine();
                    Film film = new Film(filmAd, sure, tur);
                    filmler.add(film);
                    System.out.println("Film eklendi: " + filmAd);
                    break;

                case 3: // Yeni salon ekleme
                    System.out.print("Salon Adı: ");
                    String salonAd = scanner.nextLine();
                    Salon salon = new Salon(salonlar.size() + 1, salonAd);
                    salonlar.add(salon);
                    salon.kaydet();

                    // Filmleri salona bağlama
                    System.out.println("Film Eklemek İçin Film ID Giriniz (-1 Çıkış):");
                    for (int i = 0; i < filmler.size(); i++) {
                        System.out.println((i + 1) + ". " + filmler.get(i).getAd());
                    }
                    while (true) {
                        int filmId = scanner.nextInt();
                        if (filmId == -1) break; // Çıkış için -1
                        salon.filmEkle(filmler.get(filmId - 1)); // ID'ye göre film ekle
                        break;
                    }
                    break;

                case 4: // Filmleri listele
                    for (Film f : filmler) {
                        f.bilgiGoster();
                    }
                    break;

                case 5: // Salonlara kayıtlı müşterileri listele
                    System.out.println("Salonları Listele:");
                    for (int i = 0; i < salonlar.size(); i++) {
                        System.out.println((i + 1) + ". " + salonlar.get(i).ad);
                    }
                    System.out.print("Salon ID: ");
                    int salonId = scanner.nextInt();
                    salonlar.get(salonId - 1).listeleMusteriler();
                    break;

                case 0: // Çıkış
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    return;

                default: // Hatalı giriş
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}
