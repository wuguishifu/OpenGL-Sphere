package com.bramerlabs.sphere;

public class Triangle {

    // the color of this triangle
    private Vector3f color;

    // the vertices of this triangle
    private Vector3f v1, v2, v3;

    /**
     * default constructor
     * @param color - the color of this triangle
     * @param v1 - the first vertex
     * @param v2 - the second vertex
     * @param v3 - the third vertex
     */
    public Triangle(Vector3f v1, Vector3f v2, Vector3f v3, Vector3f color) {
        this.color = color;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    /**
     * @return - the color of this triangle
     */
    public Vector3f getColor() {
        return color;
    }

    /**
     * @return - the first vertex of this triangle
     */
    public Vector3f getV1() {
        return v1;
    }

    /**
     * @return - the second vertex of this triangle
     */
    public Vector3f getV2() {
        return v2;
    }

    /**
     * @return - the third vertex of this triangle
     */
    public Vector3f getV3() {
        return v3;
    }
}
