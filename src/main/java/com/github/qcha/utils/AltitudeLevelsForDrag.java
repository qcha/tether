package com.github.qcha.utils;

enum AltitudeLevelsForDrag {

    altitudeLevel0(0, 25000, 1.225E+00, 7.249),
    altitudeLevel1(25000, 30000, 3.899E-02, 6.349),
    altitudeLevel2(30000, 40000, 1.774E-02, 6.682),
    altitudeLevel3(40000, 50000, 3.972E-03, 7.554),
    altitudeLevel4(50000, 60000, 1.057E-03, 8.382),
    altitudeLevel5(60000, 70000, 3.206E-04, 7.714),
    altitudeLevel6(70000, 80000, 8.770E-05, 6.549),
    altitudeLevel7(80000, 90000, 1.905E-05, 5.799),
    altitudeLevel8(90000, 100000, 3.396E-06, 5.382),
    altitudeLevel9(100000, 110000, 5.297E-07, 5.877),
    altitudeLevel10(110000, 120000, 9.661E-08, 7.263),
    altitudeLevel11(120000, 130000, 2.438E-08, 9.473),
    altitudeLevel12(130000, 140000, 8.484E-09, 12.636),
    altitudeLevel13(140000, 150000, 3.845E-09, 16.149),
    altitudeLevel14(150000, 180000, 2.070E-09, 22.523),
    altitudeLevel15(180000, 200000, 5.464E-10, 29.740),
    altitudeLevel16(200000, 250000, 2.789E-10, 37.105),
    altitudeLevel17(250000, 300000, 7.248E-11, 45.546),
    altitudeLevel18(300000, 350000, 2.418E-11, 53.628),
    altitudeLevel19(350000, 400000, 9.518E-12, 53.298),
    altitudeLevel20(400000, 450000, 3.725E-12, 58.515),
    altitudeLevel21(450000, 500000, 1.585E-12, 60.828),
    altitudeLevel22(500000, 600000, 6.967E-13, 63.822),
    altitudeLevel23(600000, 700000, 1.454E-13, 71.835),
    altitudeLevel24(700000, 800000, 3.614E-14, 88.667),
    altitudeLevel25(800000, 900000, 1.170E-14, 124.640),
    altitudeLevel26(900000, 1000000, 5.245E-15, 181.050),
    altitudeLevel27(1000000, Double.MAX_VALUE, 3.019E-15, 268.000),
    altitudeLevelWarning(0, 0, 0, 0);

    private double bottomHeight;
    private double topHeight;
    private double initialDensity;
    private double heightScale;

    AltitudeLevelsForDrag(double bottomHeight, double topHeight, double initialDensity, double heightScale) {
        this.bottomHeight = bottomHeight;
        this.topHeight = topHeight;
        this.initialDensity = initialDensity;
        this.heightScale = heightScale;
    }

    //todo rename h
    public static AltitudeLevelsForDrag inInterval(double h) {
        //todo i think that it should be AltitudeLevelsForDrag.values().length - 1
        for (int i = 0; i < AltitudeLevelsForDrag.values().length; i++) {
            if (h >= AltitudeLevelsForDrag.values()[i].bottomHeight && h <= AltitudeLevelsForDrag.values()[i].topHeight) {
                return AltitudeLevelsForDrag.values()[i];
            }
        }
        return altitudeLevelWarning;
    }

    public double getBottomHeight() {
        return bottomHeight;
    }

    public double getInitialDensity() {
        return initialDensity;
    }

    public double getHeightScale() {
        return heightScale;
    }
}
