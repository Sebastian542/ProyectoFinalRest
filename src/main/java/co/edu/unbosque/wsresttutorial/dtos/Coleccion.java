package co.edu.unbosque.wsresttutorial.dtos;

public class Coleccion {

    private String name;
    private String descripcion;
    private String category;


    public Coleccion() {


    }

    public Coleccion(String name, String descripcion, String category) {

        this.name = name;
        this.descripcion = descripcion;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Coleccion [name=" + name + ", descripcion=" + descripcion + ", category=" + category + "]";
    }
}
