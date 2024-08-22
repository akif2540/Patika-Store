public class Notebook extends Product{
    private final String ram;
    private final String storage;
    private final double screenSize;

    public Notebook(int id, String name, double price, double discount, int stock, Brand brand, String ram, String storage, double screenSize) {
        super(id, name, price, discount, stock, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    // Notebook'un detaylarını formatlar
    @Override
    public String getProductDetails() {
        return String.format("%-5d %-30s %-10.2f %-10s %-10s %-10s %-10.1f",
                getId(), getName(), getPrice(), getBrand().getName(), storage, ram, screenSize);
    }


}
