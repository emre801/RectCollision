package com.geometry.impl;

public class Point {
	public double x,  y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "("+ x + " , " + y + ")";
	}
	@Override 
	public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Point) {
            Point that = (Point) other;
            result = (this.x == that.x && this.y== that.y);
        }
        return result;
    }
}
