package co.edu.unbosque.wsresttutorial.dtos;

public class Obra2 {

    private int id;
    private String name;
    private float price;
    private String imagepath;
    private boolean forsale;
    private int collection;


    public Obra2() {
    }
    public Obra2(int id, String name, float price, String imagepath, boolean forsale, int collection) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.imagepath = imagepath;
        this.forsale = forsale;
        this.collection = collection;

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public float getPrice() {

        return price;
    }


    public void setPrice(float price) { this.price = price;
    }


    public String getImagepath() {
        return imagepath;
    }


    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }


    public boolean getForsale() {
        return forsale;
    }


    public void setForsale(boolean forsale) {
        this.forsale = forsale;
    }


    public int getCollection() {
        return collection;
    }


    public void setCollection(int collection) {
        this.collection = collection;
    }


    @Override
    public String toString() {
        return "Obra [id=" + id + ", name=" + name + ", price=" + price + ", imagepath=" + imagepath + ", forsale="
                + forsale + ", collection=" + collection + "]";
    }


}
