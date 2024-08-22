class Phone extends Product{
    private final String storage;
    private final double screenSize;
    private final int battery;
    private final int ram;
    private final String color;

    public Phone(int id, String name, double price, double discount, int stock, Brand brand, String storage, double screenSize, int battery, int ram, String color) {
        super(id, name, price, discount, stock, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    // cep telefonun detaylarını formatlar
    @Override
    public String getProductDetails() {
        return String.format("%-5d %-30s %-10.2f %-10s %-10s %-10.1f %-10d %-10d %-10s",
                getId(), getName(), getPrice(), getBrand().getName(), storage, screenSize, battery, ram, color);
    }

}
