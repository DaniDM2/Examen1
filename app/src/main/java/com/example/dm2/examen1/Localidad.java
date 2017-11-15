package com.example.dm2.examen1;


public class Localidad {

    private String idLocalidad, foto, Ubicacion, provincia, web;

    public Localidad(String idLocalidad,String provincia, String foto, String Ubicacion, String web) {
        this.idLocalidad = idLocalidad;
        this.foto = foto;
        this.Ubicacion = Ubicacion;
        this.provincia = provincia;
        this.web = web;
    }
    public Localidad(){}

    public String getIdLocalidad() {

        return idLocalidad;
    }

    public void setIdLocalidad(String idLocalidad) {

        this.idLocalidad = idLocalidad;
    }

    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String foto) {

        this.foto = foto;
    }

    public String getUbicacion() {

        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion)
    {
        this.Ubicacion = Ubicacion;
    }

    public String getProvincia() {

        return provincia;
    }

    public void getProvincia(String provincia) {

        this.provincia = provincia;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web)
    {
        this.web = web;
    }
}
