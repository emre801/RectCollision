package com.geometry.impl;

public class Line {
	public Point a,b;
	
	public Line(Point a, Point b){
		this.a = a;
		this.b = b;
	}
	public Line(double x, double y, double x2, double y2){
		this.a = new Point(x,y);
		this.b = new Point(x2,y2);
	}
	
	public Point intersect(Line line){
		//First determine if lines intersect at all
		//The method after the if statement determines intersection point assuming lines are infinite and not segments
		if(!doIntersect(this.a, this.b, line.a,line.b)){
			return null;
		}
		double  x1= line.a.x;
		double  x2= line.b.x;
		double  x3= this.a.x;
		double  x4= this.b.x;
		
		double  y1= line.a.y;
		double  y2= line.b.y;
		double  y3= this.a.y;
		double  y4= this.b.y;
		
		double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
		if (d == 0) return null;
		double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
		double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
		
		return new Point(xi,yi);
		
	}
	
	
	private int orientation(Point p, Point q, Point r)
	{
	    double val = (q.y - p.y) * (r.x - q.x) -
	              (q.x - p.x) * (r.y - q.y);
	 
	    if (val == 0) return 0;
	 
	    return (val > 0)? 1: 2; // clock or counterclock wise
	}
	
	private boolean onSegment(Point p, Point q, Point r)
	{
	    if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
	        q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
	       return true;
	 
	    return false;
	}
	
	private boolean doIntersect(Point p1, Point q1, Point p2, Point q2)
	{
	    int o1 = orientation(p1, q1, p2);
	    int o2 = orientation(p1, q1, q2);
	    int o3 = orientation(p2, q2, p1);
	    int o4 = orientation(p2, q2, q1);
		if (o1 != o2 && o3 != o4)
	        return true;

	    if (o1 == 0 && onSegment(p1, p2, q1)) return true;
	 
	    if (o2 == 0 && onSegment(p1, q2, q1)) return true;
	 
	    if (o3 == 0 && onSegment(p2, p1, q2)) return true;
	 
	    if (o4 == 0 && onSegment(p2, q1, q2)) return true;
	 
	    return false; 
	}
	
	public String toString() {
		return a.toString() + " " + b.toString();
	}
}
