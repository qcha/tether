package com.github.qcha.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        double a = VectorsAlgebra.absoluteValue(v);
        return (c * ro * a * a * s) / 2;
    }

    public static double exponentialModelDensity(double h) {
        double initialDensity = 0, ha = 0, heightScale = 0;

        // TODO Тут нужно что-то получше SOUT'а
        AltitudeLevelsForDrag resultSet = AltitudeLevelsForDrag.inInterval(h);
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
        double Re = 6378100.0;
        double Rp = 6356800.0;
        double w = 7.2921158553E-5;

        return ((Re * Rp) / (Math.sqrt(Rp * Rp + Re * Re * Math.tan(phi) * Math.tan(phi))) +
                (Rp * Rp * h) / (Math.sqrt(Rp * Rp + Re * Re * Math.tan(phi) * Math.tan(phi)))) * w;
    }
}
