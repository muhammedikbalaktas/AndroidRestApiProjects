package com.example.caloriesoffoods__okhttp;

public class Food {

    private double şeker;
    private double lif;
    private double gramaj;
    private double sodyum;
    private String isim;
    private double potasyum;
    private double doymuş_yağ;
    private double yağ;
    private double kalori;
    private double kolestrol;
    private double protein;
    private double karbonhidrat;




    public  String toString(){
        StringBuilder total = new StringBuilder();
        total.append("şeker: "+şeker+" g");
        total.append("\n");
        total.append("gramaj: "+gramaj+" g");
        total.append("\n");
        total.append("sodyum: "+sodyum+" mg");
        total.append("\n");
        total.append("potasyum: "+potasyum+" mg");
        total.append("\n");
        total.append("doymuş yağ :"+doymuş_yağ+" g");
        total.append("\n");
        total.append("yağ: "+yağ+" g");
        total.append("\n");
        total.append("kalori: "+kalori+" kcal");
        total.append("\n");
        total.append("kolestrol: "+kolestrol+" mg");
        total.append("\n");
        total.append("protein: "+protein+" g");
        total.append("\n");
        total.append("karbonhidrat: "+karbonhidrat+" g");
        total.append("\n");



        return total.toString();
    }

    public double getŞeker() {
        return şeker;
    }

    public void setŞeker(double şeker) {
        this.şeker = şeker;
    }

    public double getLif() {
        return lif;
    }

    public void setLif(double lif) {
        this.lif = lif;
    }

    public double getGramaj() {
        return gramaj;
    }

    public void setGramaj(double gramaj) {
        this.gramaj = gramaj;
    }

    public double getSodyum() {
        return sodyum;
    }

    public void setSodyum(double sodyum) {
        this.sodyum = sodyum;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public double getPotasyum() {
        return potasyum;
    }

    public void setPotasyum(double potasyum) {
        this.potasyum = potasyum;
    }

    public double getDoymuş_yağ() {
        return doymuş_yağ;
    }

    public void setDoymuş_yağ(double doymuş_yağ) {
        this.doymuş_yağ = doymuş_yağ;
    }

    public double getYağ() {
        return yağ;
    }

    public void setYağ(double yağ) {
        this.yağ = yağ;
    }

    public double getKalori() {
        return kalori;
    }

    public void setKalori(double kalori) {
        this.kalori = kalori;
    }

    public double getKolestrol() {
        return kolestrol;
    }

    public void setKolestrol(double kolestrol) {
        this.kolestrol = kolestrol;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getKarbonhidrat() {
        return karbonhidrat;
    }

    public void setKarbonhidrat(double karbonhidrat) {
        this.karbonhidrat = karbonhidrat;
    }
}
