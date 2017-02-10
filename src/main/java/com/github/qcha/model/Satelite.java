package com.github.qcha.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Satelite {
    //coordinates
    private double x;
    private double y;
    private double z;
    // velocity proections
    private double vx;
    private double vy;
    private double vz;

    private double mass;

    public Satelite(double x, double y, double z, double vx, double vy, double vz, double mass) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.mass = mass;
    }
}
