package utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by Maxim Tarasov on 14.08.2016.
 */
public class SunRadiationPressure {

    // TODO Check P
    public static List<Double> force(double A, double C, double P, double as, Calendar c) {

        List<Double> sunVector = SunPosition.sunPosition(c);
        List<Double> r = new ArrayList<>();
        Collections.addAll(r, sunVector.get(0), sunVector.get(1), sunVector.get(2));

        return VectorsAlgebra.constMult(-C * P * A * Math.pow(as / VectorsAlgebra.absoluteValue(r), 2), VectorsAlgebra.normalize(r));
    }

    public static List<Double> force(double A, double C, Calendar c) {

        double as = 149597870660.0; //in meters
        double P = 4.56E-6; //in Pa (N/m^2)

        List<Double> sunVector = SunPosition.sunPosition(c);
        List<Double> r = new ArrayList<>();
        Collections.addAll(r, sunVector.get(0), sunVector.get(1), sunVector.get(2));

        return VectorsAlgebra.constMult(-C * P * A * Math.pow(as / VectorsAlgebra.absoluteValue(r), 2), VectorsAlgebra.normalize(r));
    }

    public static boolean sunShadowSign(Calendar c, CalculationUtils U, double earthR) {
        return earthBetween(c, U) && satelliteBehind(c, U, earthR);
    }

    public static boolean earthBetween(Calendar c, CalculationUtils U) {

        List<Double> sunVector = SunPosition.sunPosition(c);
        List<Double> rsun = new ArrayList<>();
        Collections.addAll(rsun, sunVector.get(0), sunVector.get(1), sunVector.get(2));

        List<Double> rsat = new ArrayList<>();
        Collections.addAll(rsat, U.x, U.y, U.z);

        double cos = VectorsAlgebra.multS(rsun, rsat) / (VectorsAlgebra.absoluteValue(rsun) * VectorsAlgebra.absoluteValue(rsat));

        return cos < 0;
    }

    public static boolean satelliteBehind(Calendar c, CalculationUtils U, double earthR) {

        List<Double> sunVector = SunPosition.sunPosition(c);
        List<Double> rsun = new ArrayList<>();
        Collections.addAll(rsun, sunVector.get(0), sunVector.get(1), sunVector.get(2));

        List<Double> rsat = new ArrayList<>();
        Collections.addAll(rsat, U.x, U.y, U.z);

        double distance = VectorsAlgebra.absoluteValue(VectorsAlgebra.multV(rsat, rsun)) / VectorsAlgebra.absoluteValue(rsun);

        return distance < earthR;
    }
}
