package com.github.qcha.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Maxim Tarasov on 14.08.2016.
 */
public class Drag {

    final static double H0 = 0, H1 = 25000, H2 = 30000, H3 = 40000, H4 = 50000, H5 = 60000, H6 = 70000, H7 = 80000, H8 = 90000,
            H9 = 100000, H10 = 110000, H11 = 120000, H12 = 130000, H13 = 140000, H14 = 150000, H15 = 180000,
            H16 = 200000, H17 = 250000, H18 = 300000, H19 = 350000, H20 = 400000, H21 = 450000, H22 = 500000,
            H23 = 600000, H24 = 700000, H25 = 800000, H26 = 900000, H27 = 1000000;
    final static double P0 = 1.225E+00, P1 = 3.899E-02, P2 = 1.774E-02, P3 = 3.972E-03, P4 = 1.057E-03, P5 = 3.206E-04,
            P6 = 8.770E-05, P7 = 1.905E-05, P8 = 3.396E-06, P9 = 5.297E-07, P10 = 9.661E-08, P11 = 2.438E-08,
            P12 = 8.484E-09, P13 = 3.845E-09, P14 = 2.070E-09, P15 = 5.464E-10, P16 = 2.789E-10, P17 = 7.248E-11,
            P18 = 2.418E-11, P19 = 9.518E-12, P20 = 3.725E-12, P21 = 1.585E-12, P22 = 6.967E-13, P23 = 1.454E-13,
            P24 = 3.614E-14, P25 = 1.170E-14, P26 = 5.245E-15, P27 = 3.019E-15;
    final static double HS0 = 7.249, HS1 = 6.349, HS2 = 6.682, HS3 = 7.554, HS4 = 8.382, HS5 = 7.714, HS6 = 6.549, HS7 = 5.799,
            HS8 = 5.382, HS9 = 5.877, HS10 = 7.263, HS11 = 9.473, HS12 = 12.636, HS13 = 16.149, HS14 = 22.523,
            HS15 = 29.740, HS16 = 37.105, HS17 = 45.546, HS18 = 53.628, HS19 = 53.298, HS20 = 58.515, HS21 = 60.828,
            HS22 = 63.822, HS23 = 71.835, HS24 = 88.667, HS25 = 124.640, HS26 = 181.050, HS27 = 268.000;


    public static double force(double c, double ro, double v, double s) {
        return (c * ro * v * v * s) / 2;
    }

    public static double force(double c, double ro, List<Double> v, double s) {
        double a = VectorsAlgebra.absoluteValue(v);
        return (c * ro * a * a * s) / 2;
    }

    public static double exponentialModelDensity(double h) {
        double p0 = 0, h1 = 0, H = 0;
//        Path currentDir = Paths.get(".");
//        Path pathA1 = Paths.get(currentDir.toAbsolutePath().toString(), "src", "main", "java", "com/github/qcha/resources", "ExpModelDens");
//
//        List<String> listDens = null;
//        try {
//            listDens = Files.readAllLines(pathA1);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        // h in km, p0 in kg/m^3
//        assert listDens != null;
//        for (int j = 0; j <= listDens.size() - 1; j++) {
//            String[] parts = listDens.get(j).split("\\t");
//            h1 = Double.parseDouble(parts[0]);
//            h2 = Double.parseDouble(parts[1]);
//            if ((h >= h1 && h <= h2) || (h >= h1 && j == listDens.size() - 1)) {
//                p0 = Double.parseDouble(parts[2]);
//                H = Double.parseDouble(parts[3]);
//                break;
//            }
//        }

        // Да здравствует индусский код!
        // Вероятно тут следует сделать через массив, но что-то мне подсказывает, что опять время утечет
        if (h >= H0 && h <= H1) {
            p0 = P0;
            H = HS0;
            h1 = H0;
        } else if (h >= H1 && h <= H2) {
            p0 = P1;
            H = HS1;
            h1 = H1;
        } else if (h >= H2 && h <= H3) {
            p0 = P2;
            H = HS2;
            h1 = H2;
        } else if (h >= H3 && h <= H4) {
            p0 = P3;
            H = HS3;
            h1 = H3;
        } else if (h >= H4 && h <= H5) {
            p0 = P4;
            H = HS4;
            h1 = H4;
        } else if (h >= H5 && h <= H6) {
            p0 = P5;
            H = HS5;
            h1 = H5;
        } else if (h >= H6 && h <= H7) {
            p0 = P6;
            H = HS6;
            h1 = H6;
        } else if (h >= H7 && h <= H8) {
            p0 = P7;
            H = HS7;
            h1 = H7;
        } else if (h >= H8 && h <= H9) {
            p0 = P8;
            H = HS8;
            h1 = H8;
        } else if (h >= H9 && h <= H10) {
            p0 = P9;
            H = HS9;
            h1 = H9;
        } else if (h >= H10 && h <= H11) {
            p0 = P10;
            H = HS10;
            h1 = H10;
        } else if (h >= H11 && h <= H12) {
            p0 = P11;
            H = HS11;
            h1 = H11;
        } else if (h >= H12 && h <= H13) {
            p0 = P12;
            H = HS12;
            h1 = H12;
        } else if (h >= H13 && h <= H14) {
            p0 = P13;
            H = HS13;
            h1 = H13;
        } else if (h >= H14 && h <= H15) {
            p0 = P14;
            H = HS14;
            h1 = H14;
        } else if (h >= H15 && h <= H16) {
            p0 = P15;
            H = HS15;
            h1 = H15;
        } else if (h >= H16 && h <= H17) {
            p0 = P16;
            H = HS16;
            h1 = H16;
        } else if (h >= H17 && h <= H18) {
            p0 = P17;
            H = HS17;
            h1 = H17;
        } else if (h >= H18 && h <= H19) {
            p0 = P18;
            H = HS18;
            h1 = H18;
        } else if (h >= H19 && h <= H20) {
            p0 = P19;
            H = HS19;
            h1 = H19;
        } else if (h >= H20 && h <= H21) {
            p0 = P20;
            H = HS20;
            h1 = H20;
        } else if (h >= H21 && h <= H22) {
            p0 = P21;
            H = HS21;
            h1 = H21;
        } else if (h >= H22 && h <= H23) {
            p0 = P22;
            H = HS22;
            h1 = H22;
        } else if (h >= H23 && h <= H24) {
            p0 = P23;
            H = HS23;
            h1 = H23;
        } else if (h >= H24 && h <= H25) {
            p0 = P24;
            H = HS24;
            h1 = H24;
        } else if (h >= H25 && h <= H26) {
            p0 = P25;
            H = HS25;
            h1 = H25;
        } else if (h >= H26 && h <= H27) {
            p0 = P26;
            H = HS26;
            h1 = H26;
        } else if (h >= H27) {
            p0 = P27;
            H = HS27;
            h1 = H27;
        }

        return p0 * Math.exp(((h1 / 1000) - (h / 1000)) / H);
    }

    public static double earthsRotation(double phi, double h) {
        double Re = 6378100.0;
        double Rp = 6356800.0;
        double w = 7.2921158553E-5;

        return ((Re * Rp) / (Math.sqrt(Rp * Rp + Re * Re * Math.tan(phi) * Math.tan(phi))) +
                (Rp * Rp * h) / (Math.sqrt(Rp * Rp + Re * Re * Math.tan(phi) * Math.tan(phi)))) * w;
    }
}
