import java.util.*;


public class PatikaStore {
    private final List<Brand> brands = new ArrayList<>(); // Markaları tutan liste
    private final List<Product> products = new ArrayList<>(); // Ürünleri tutan liste
    private int brandIdCounter = 1; // Marka id'si için sayaç
    private int productIdCounter = 1; // Ürün id'si için sayaç

    // PatikaStore nesnesinin oluşturulması
    public PatikaStore() {
        initializeBrands(); // Markaları başlat
    }

    // Markaları başlatır ve alfabetik sıraya göre sıralar
    private void initializeBrands() {
        String[] brandNames = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for (String name : brandNames) {
            brands.add(new Brand(brandIdCounter++, name));
        }
        Collections.sort(brands); // Alfabetik sıralama
    }

    // Ürün ekler
    public void addProduct(Product product) {
        products.add(product);
    }

    // Markaları listeler
    public void listBrands() {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (Brand brand : brands) {
            System.out.println("- " + brand);
        }
    }

    // Belirtilen ürün tipine göre ürünleri listeler
    public void listProducts(Class<? extends Product> productType) {
        System.out.println(productType.getSimpleName() + " Listesi");
        if (productType == Phone.class) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        } else if (productType == Notebook.class) {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        for (Product product : products) {
            if (productType.isInstance(product)) {
                System.out.println(product.getProductDetails());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    // Belirtilen id'ye sahip ürünü siler
    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    // Ürünleri markaya göre filtreleyip listeler
    public void filterProducts(String brandName) {
        System.out.println("Filtrelenmiş Ürünler:");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : products) {
            if (product.getBrand().getName().equalsIgnoreCase(brandName)) {
                System.out.println(product.getProductDetails());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    // Ana metod, kullanıcı etkileşimini sağlar
    public static void main(String[] args) {
        PatikaStore store = new PatikaStore();

        // Örnek markalar
        Brand apple = store.brands.stream().filter(b -> b.getName().equals("Apple")).findFirst().orElse(null);
        Brand samsung = store.brands.stream().filter(b -> b.getName().equals("Samsung")).findFirst().orElse(null);
        Brand xiaomi = store.brands.stream().filter(b -> b.getName().equals("Xiaomi")).findFirst().orElse(null);

        // Örnek ürünler ekleme
        store.addProduct(new Phone(1, "SAMSUNG GALAXY A51", 3199.0, 0.1, 20, samsung, "128", 6.5, 4000, 6, "Siyah"));
        store.addProduct(new Phone(2, "iPhone 11 64 GB", 7379.0, 0.05, 15, apple, "64", 6.1, 3046, 6, "Mavi"));
        store.addProduct(new Notebook(1, "HUAWEI Matebook 14", 7000.0, 0.1, 10, store.brands.stream().filter(b -> b.getName().equals("Huawei")).findFirst().orElse(null), "8 GB", "512 SSD", 14.0));
        store.addProduct(new Notebook(2, "LENOVO V14 IGL", 3699.0, 0.2, 25, store.brands.stream().filter(b -> b.getName().equals("Lenovo")).findFirst().orElse(null), "8 GB", "512 SSD", 14.0));

        // Menü aracılığıyla kullanıcı etkileşimi
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Markaları Listele");
            System.out.println("2. Telefonları Listele");
            System.out.println("3. Notebook'ları Listele");
            System.out.println("4. Ürün Sil");
            System.out.println("5. Ürünleri Markaya Göre Filtrele");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 1:
                    store.listBrands();
                    break;
                case 2:
                    store.listProducts(Phone.class);
                    break;
                case 3:
                    store.listProducts(Notebook.class);
                    break;
                case 4:
                    System.out.print("Silmek istediğiniz ürünün ID'sini girin: ");
                    int id = scanner.nextInt();
                    store.deleteProduct(id);
                    System.out.println("Ürün silindi.");
                    break;
                case 5:
                    System.out.print("Filtrelemek istediğiniz markanın adını girin: ");
                    String brandName = scanner.nextLine();
                    store.filterProducts(brandName);
                    break;
                case 6:
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                    break;
            }
        }
    }
}
