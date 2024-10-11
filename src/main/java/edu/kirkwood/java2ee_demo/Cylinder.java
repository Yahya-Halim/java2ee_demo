package edu.kirkwood.java2ee_demo;

import edu.kirkwood.shared.Helpers;

public class Cylinder {
    private Circle base;
    private double height;

    public Cylinder() {
        this(0, 0);
    }

    public Cylinder(double radius, double height) {
        setBase(new Circle(radius));
        setHeight(height);
    }

    public Circle getBase() {
        return base;
    }

    public void setBase(Circle base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative.");
        }
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(base.getRadius(), 2) * height;
    }

    @Override
    public String toString() {
        double volume = getVolume();
        return height + " · π · " + base.getRadius() + "^2 = " + Helpers.round(volume, 2);
    }
}
