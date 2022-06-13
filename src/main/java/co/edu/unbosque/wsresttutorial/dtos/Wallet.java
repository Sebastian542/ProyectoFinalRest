package co.edu.unbosque.wsresttutorial.dtos;


public class Wallet {

    private int id;
    private String userapp;
    private String type;
    private float fcoins;
    private String registeredat;

    public Wallet() {

    }


    public Wallet(int id, String userapp, String type, float fcoins, String registeredat) {

        this.id = id;
        this.userapp = userapp;
        this.type = type;
        this.fcoins = fcoins;
        this.registeredat = registeredat;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getUserapp() {
        return userapp;
    }


    public void setUserapp(String userapp) {
        this.userapp = userapp;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public float getFcoins() {
        return fcoins;
    }


    public void setFcoins(float fcoins) {
        this.fcoins = fcoins;
    }


    public String getRegisteredat() {
        return registeredat;
    }


    public void setRegisteredat(String registeredat) {
        this.registeredat = registeredat;
    }


    @Override
    public String toString() {
        return "Wallet [id=" + id + ", userapp=" + userapp + ", type=" + type + ", fcoins=" + fcoins + ", registeredat="
                + registeredat + "]";
    }


}