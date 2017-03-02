package com.github.qcha.utils;

import java.util.List;

/**
 * Created by Maxim Tarasov on 14.08.2016.
 * This class calculates the atmospheric drag force for body given its height, cross section and velocity.
 * Function exponentialModelDensity outputs atmospheric layer density using piecewise-exponential density model.
 * Function force outputs drag force value in N.
 */
public class Drag {

    public static double force(double c, double ro, double v, double s) {
        return (c * ro * v * v * s) / 2;
    }

    public static double force(double c, double ro, List<Double> v, double s) {
        return (c * ro * s * Math.pow(VectorsAlgebra.absoluteValue(v), 2)) / 2;
    }

    public static double exponentialModelDensity(double h) {
        //todo move it to the constants
        // that's not constants, there is just initialization
        double initialDensity = 0, ha = 0, heightScale = 0;

        // TODO Тут нужно что-то получше SOUT'а
        AltitudeLevel resultSet = AltitudeLevel.inInterval(h);
        if (resultSet.getBottomHeight() == 0 && resultSet.getHeightScale() == 0 && resultSet.getInitialDensity() == 0) {
            System.out.println("ERROR!");
        } else {
            initialDensity = resultSet.getInitialDensity();
            heightScale = resultSet.getHeightScale();
            ha = resultSet.getBottomHeight();
        }

        return initialDensity * Math.exp(((ha / 1000) - (h / 1000)) / heightScale);
    }

    public static double earthsRotation(double phi, double h) {
        //todo move it to the constants class
        double Re = 6378100.0;
        double Rp = 6356800.0;
        double w = 7.2921158553E-5;

        double rp2pow = Math.pow(Rp, 2);
        double re2pow = Math.pow(Re, 2);

        return ((Re * Rp) / (Math.sqrt(rp2pow + re2pow * Math.tan(phi) * Math.tan(phi))) +
                (rp2pow * h) / (Math.sqrt(rp2pow + re2pow * Math.tan(phi) * Math.tan(phi)))) * w;
    }
}
