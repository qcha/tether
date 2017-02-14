package com.github.qcha.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Maxim Tarasov on 14.08.2016.
 */
public class Drag {

    private static final String EXPONENTIAL_MODEL_DESTINY = "ExpModelDens";

    public static double force(double c, double ro, double v, double s) {
        return (c * ro * v * v * s) / 2;
    }

    public static double force(double c, double ro, List<Double> v, double s) {
        double a = VectorsAlgebra.absoluteValue(v);
        return (c * ro * a * a * s) / 2;
    }

    public static double exponentialModelDensity(double h) {
        try {
            Path pathA1 = Paths.get(Drag.class.getResource(String.format("/%s", EXPONENTIAL_MODEL_DESTINY)).toURI());
            List<String> listDens = Files.readAllLines(pathA1);
            // h in km, p0 in kg/m^3
            double p0 = 0, h1 = 0, h2 = 0, H = 0;
            assert listDens != null;
            for (int j = 0; j <= listDens.size() - 1; j++) {
                String[] parts = listDens.get(j).split("\\t");
                h1 = Double.parseDouble(parts[0]);
                h2 = Double.parseDouble(parts[1]);
                if ((h >= h1 && h <= h2) || (h >= h1 && j == listDens.size() - 1)) {
                    p0 = Double.parseDouble(parts[2]);
                    H = Double.parseDouble(parts[3]);
                    break;
                }
            }

            return p0 * Math.exp(((h1 / 1000) - (h / 1000)) / H);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(String.format("Can't find resource: %s", EXPONENTIAL_MODEL_DESTINY));
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("Can't read resource: %s", EXPONENTIAL_MODEL_DESTINY));
        }
    }

    public static double earthsRotation(double phi, double h) {
        double Re = 6378100.0;
        double Rp = 6356800.0;
        double w = 7.2921158553E-5;

        return ((Re * Rp) / (Math.sqrt(Rp * Rp + Re * Re * Math.tan(phi) * Math.tan(phi))) +
                (Rp * Rp * h) / (Math.sqrt(Rp * Rp + Re * Re * Math.tan(phi) * Math.tan(phi)))) * w;
    }
}
