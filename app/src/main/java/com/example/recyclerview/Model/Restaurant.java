package com.example.recyclerview.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Restaurant {
    private int id;
    private String nombre;
    private String horarios;
    private String telefono;
    private String direccion;
    private String categoria;
    private String foto;

    public Restaurant(int id, String nombre, String horarios, String telefono, String direccion, String categoria, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.horarios = horarios;
        this.telefono = telefono;
        this.direccion = direccion;
        this.categoria = categoria;
        this.foto = foto;
    }

    public Restaurant(JSONObject jsonObject) throws JSONException {
        nombre=jsonObject.getString("nombre").toString();
        horarios="Hora: "+jsonObject.getString("horarios").toString();
        telefono="Telf: "+jsonObject.getString("telefono").toString();
        direccion="Direc: "+jsonObject.getString("direccion").toString();
        categoria=jsonObject.getString("categoria").toString();
        foto=jsonObject.getString("foto").toString();
    }

    public static ArrayList<Restaurant> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Restaurant> restaurant = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            restaurant.add(new Restaurant(datos.getJSONObject(i)));
        }
        return restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
