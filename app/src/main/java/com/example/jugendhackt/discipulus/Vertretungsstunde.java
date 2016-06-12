package com.example.jugendhackt.discipulus;

/**
 * Created by JugendHackt on 11.06.2016.
 */
public class Vertretungsstunde {
    private String stunde;
    private String fach;
    private String raum;

    public Vertretungsstunde(String stunde, String fach, String raum) {
        this.fach = fach;
        this.stunde = stunde;
        this.raum = raum;
    }

    public String getStunde() {
        return stunde;
    }
    public String getRaum() {
        return raum;
    }
    public void setStunde(String stunde) {
        this.stunde = stunde;
    }

    public String getFach() {
        return fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }
}
