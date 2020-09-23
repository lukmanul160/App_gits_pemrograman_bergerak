package com.example.myapplication.model;

public class Batik {
    private int id;
    private String nama_batik;
    private String makna_batik;
    private String daerah_batik;
    private int harga_rendah;
    private int harga_tinggi;



    private int hitung_view;
    private String link_batik;

    public Batik(){}



    public Batik(int id, String nama_batik, String makna_batik, int harga_rendah, int harga_tinggi, int hitung_view, String link_batik) {
        this.id = id;
        this.nama_batik = nama_batik;
        this.makna_batik = makna_batik;
        this.harga_rendah = harga_rendah;
        this.harga_tinggi = harga_tinggi;
        this.hitung_view = hitung_view;
        this.link_batik = link_batik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_batik() {
        return nama_batik;
    }

    public void setNama_batik(String nama_batik) {
        this.nama_batik = nama_batik;
    }

    public String getMakna_batik() {
        return makna_batik;
    }

    public void setMakna_batik(String makna_batik) {
        this.makna_batik = makna_batik;
    }

    public int getHarga_rendah() {
        return harga_rendah;
    }

    public void setHarga_rendah(int harga_rendah) {
        this.harga_rendah = harga_rendah;
    }

    public int getHarga_tinggi() {
        return harga_tinggi;
    }

    public void setHarga_tinggi(int harga_tinggi) {
        this.harga_tinggi = harga_tinggi;
    }

    public int getHitung_view() {
        return hitung_view;
    }

    public void setHitung_view(int hitung_view) {
        this.hitung_view = hitung_view;
    }

    public String getLink_batik() {
        return link_batik;
    }

    public void setLink_batik(String link_batik) {
        this.link_batik = link_batik;
    }

    public String getDaerah_batik() {
        return daerah_batik;
    }

    public void setDaerah_batik(String daerah_batik) {
        this.daerah_batik = daerah_batik;
    }


}
