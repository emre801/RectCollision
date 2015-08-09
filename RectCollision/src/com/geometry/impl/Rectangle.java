package com.geometry.impl;

import java.util.ArrayList;

public class Rectangle {
		
	//Assume the dimensions of the world the top left is the point 0,0
	public Point topLeft, bottomRight;
	public ArrayList<Line> lines;
	
	public Rectangle(Point topLeft, Point bottomRight) throws Exception{
		handleError(topLeft.x,topLeft.y,bottomRight.x, bottomRight.y);
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
		createLinesOfRectangle();
	}
	
	public Rectangle(int x1 , int y1, int x2, int y2) throws Exception{
		handleError(x1,y1,x2,y2);
		this.topLeft = new Point(x1,y1);
		this.bottomRight = new Point(x2,y2);
		createLinesOfRectangle();
	}
	
	public void handleError(double x1 , double y1, double x2, double y2) throws Exception{
		if(x1>x2 || y1>y2){
			throw new Exception();
		}
	}
	
	
	//Create the Lines of the rectangle. This is useful for determining intersection points
	public void createLinesOfRectangle(){
		lines = new ArrayList<Line>();
		lines.add(new Line(topLeft.x, topLeft.y, bottomRight.x, topLeft.y));
		lines.add(new Line(topLeft.x, topLeft.y, topLeft.x, bottomRight.y));
		lines.add(new Line(topLeft.x, bottomRight.y, bottomRight.x, bottomRight.y));
		lines.add(new Line(bottomRight.x, topLeft.y, bottomRight.x, bottomRight.y));
	}
	
	public double getHeight(){
		return  bottomRight.y - topLeft.y;
	}
	
	public double getWidth(){
		return bottomRight.x - topLeft.x;
	}

}
