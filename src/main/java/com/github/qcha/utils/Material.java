package com.github.qcha.utils;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

public class Material extends PhongMaterial {

    public Material(Color diffuseColor) {
        setDiffuseColor(diffuseColor);
        setSpecularColor(diffuseColor);
    }
}
