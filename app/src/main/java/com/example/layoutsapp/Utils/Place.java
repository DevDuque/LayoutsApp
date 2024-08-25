package com.example.layoutsapp.Utils;

/**
 * Created by jemaf on 07/03/18.
 */
public class Place {

    private String name;        // nome do local
    private Integer photoId;    // id da foto do local
    private Double distance;    // distância (em km)
    private Double rate;        // nota (1 a 5)

    /**
     * Construtor
     * @param name nome do local
     * @param photoId ID da foto do local (Retirado do R.drawable)
     * @param distance Distância do local em KM
     * @param rate Nota do local (1 a 5)
     */
    public Place(String name, Integer photoId, Double distance, Double rate) {
        this.name = name;
        this.photoId = photoId;
        this.distance = distance;
        this.rate = rate;
    }

    /**
     * Construtor padrão
     */
    public Place() {
        this(null, null, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoName(Integer photoId) {
        this.photoId = photoId;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}