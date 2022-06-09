package co.edu.unbosque.wsresttutorial.dtos;

public class Obra {

    private int idusuario;
    private String tobra;
    private Float precio;
    private int idfactura;
    private int idtipoarte;
    private String imagenurl;

    public Obra(){

    }
    public Obra(int idusuario, String tobra, Float precio, int idfactura, int idtipoarte, String imagenurl) {

        this.idusuario = idusuario;
        this.tobra = tobra;
        this.precio = precio;
        this.idfactura = idfactura;
        this.idtipoarte = idtipoarte;
        this.imagenurl = imagenurl;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getTobra() {
        return tobra;
    }

    public void setTobra(String tobra) {
        this.tobra = tobra;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getIdtipoarte() {
        return idtipoarte;
    }

    public void setIdtipoarte(int idtipoarte) {
        this.idtipoarte = idtipoarte;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }


    public String toString() {
        return "Obra [idusuario=" + idusuario + ", tobra=" + tobra + ", precio=" + precio + ", idfactura="
                + idfactura + ", idtipoarte=" + idtipoarte + ", nombreimg=" + imagenurl + "]";
    }


}