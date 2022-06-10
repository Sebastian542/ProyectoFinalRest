package co.edu.unbosque.wsresttutorial.dtos;

public class Persona {


    private String nombre;
    private int telefono;
    private int idusuario;
    private int fcoins;

    public Persona() {
    }

    public Persona(String nombre, int telefono, int idusuario, int fcoins) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.idusuario = idusuario;
        this.fcoins = fcoins;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }



    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public int getIdusuario() {
        return idusuario;
    }

    public int getfcoins() {
        return fcoins;
    }

    public void setfcoins(int nfcoins) {
        this.fcoins = fcoins;
    }

    @Override
    public String toString() {
        return "Obra [nombre=" + nombre + ", telefono=" + telefono + ", idusuario=" + idusuario + ", fcoins=" + fcoins
                + "]";
    }



}
