abstract class Product {
    private final int id;
    private double price;
    private double discount;
    private int stock;
    private final String name;
    private final Brand brand;

    public Product(int id, String name, double price, double discount, int stock, Brand brand){
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.brand = brand;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount(){
        return discount;
    }

    public int getStock(){
        return stock;
    }

    public Brand getBrand(){
        return brand;
    }

    // ürün detaylarının alt sınıflarına nasıl gösterilerceğini tanımlar
    public abstract String getProductDetails();

    @Override
    public String toString(){
        return String.format("%-5 %-30s %-10.2f %-10s",id,name,price,brand);
    }

}
