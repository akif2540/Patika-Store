public class Brand implements Comparable<Brand> {
    private final int id;
    private final String name;

    public Brand(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }


    // Marka adlarının alfabetik sırayla karşılaştırmak için
    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString(){
        return name;
    }
}
