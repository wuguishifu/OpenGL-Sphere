package com.bramerlabs.sphere;

public class Vector3f {

    public float x;
    public float y;
    public float z;

    /**
     * default constructor
     * @param x - x value
     * @param y - y value
     * @param z - z value
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * constructor for copying a vector
     * @param v - the vector to be copied
     */
    public Vector3f(Vector3f v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    /**
     * adds a vector to this vector
     * @param v - the other vector
     * @return - this vector
     */
    public Vector3f add(Vector3f v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    /**
     * normalizes a vector to a length of 1
     */
    public void normalize() {
        float length = (float)Math.sqrt(x * x + y * y + z * z);
        this.x /= length;
        this.y /= length;
        this.z /= length;
    }

    /**
     * normalizes a vector to a specified length r
     * @param r - the new length of the vector after normalization
     */
    public void normalize(float r) {
        float length = (float)Math.sqrt(x * x + y * y + z * z);
        float v = length/r;
        this.x /= v;
        this.y /= v;
        this.z /= v;
    }
}
