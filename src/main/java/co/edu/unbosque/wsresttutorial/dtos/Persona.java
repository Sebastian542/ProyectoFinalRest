package co.edu.unbosque.wsresttutorial.dtos;

public class Persona {


    private String nombre;
    private int telefono;
    private int idusuario;
    private int nfcoins;

    public Persona() {
    }

    public Persona(String nombre, int telefono, int idusuario, int nfcoins) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.idusuario = idusuario;
        this.nfcoins = nfcoins;
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

    public int getNfcoins() {
        return nfcoins;
    }

    public void setNfcoins(int nfcoins) {
        this.nfcoins = nfcoins;
    }

    @Override
    public String toString() {
        return "Obra [nombre=" + nombre + ", telefono=" + telefono + ", idusuario=" + idusuario + ", nfcoins=" + nfcoins
                + "]";
    }



}
