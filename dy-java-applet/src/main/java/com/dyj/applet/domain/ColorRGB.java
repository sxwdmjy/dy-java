package com.dyj.applet.domain;

/**
 * @author danmo
 * @date 2024-04-17 14:22
 **/
public class ColorRGB {

    private Integer r;

    private Integer g;

    private Integer b;

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public static ColorRGBBuilder builder() {
        return new ColorRGBBuilder();
    }

    public static class ColorRGBBuilder {
        private Integer r;
        private Integer g;
        private Integer b;

        public ColorRGBBuilder r
                (Integer r) {
            this.r = r;
            return this;
        }

        public ColorRGBBuilder g
                (Integer g) {
            this.g = g;
            return this;
        }

        public ColorRGBBuilder b
                (Integer b) {
            this.b = b;
            return this;
        }

        public ColorRGB build() {
            ColorRGB colorRGB = new ColorRGB();
            colorRGB.setR(r);
            colorRGB.setG(g);
            colorRGB.setB(b);
            return colorRGB;
        }
    }
}
