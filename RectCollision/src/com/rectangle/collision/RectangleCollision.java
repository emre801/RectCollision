package com.rectangle.collision;

import java.util.ArrayList;
import java.util.List;

import com.geometry.impl.Line;
import com.geometry.impl.Point;
import com.geometry.impl.Rectangle;

public class RectangleCollision {
	
	public static boolean containedRectanlges(Rectangle rect1, Rectangle rect2){
		double x1 = rect1.topLeft.x;
		double y1 = rect1.topLeft.y;
		double w1 = rect1.getWidth();
		double h1 = rect1.getHeight();
		
		double x2 = rect2.topLeft.x;
		double y2 = rect2.topLeft.y;
		double w2 = rect2.getWidth();
		double h2 = rect2.getHeight();
		
        if ((w2< 0 || h2< 0 || w1< 0 || w1< 0)) {
            return false;
        }
        if (x2 < x1 || y2 < y1) {
            return false;
        }
        w1 += x1;
        w2 += x2;
        if (w2 <= x2) {
            if (w1 >= x1 || w2 > w1) return false;
        } else {
            if (w1 >= x1 && w2 > w1) return false;
        }
        h1 += y1;
        h2 += y2;
        if (h2 <= y2) {
            if (h1 >= y1 || h2 > h1) return false;
       } else {
            if (h1 >= y1 && h2 > h1) return false;
        }
        return true;
	}
	
	public static List<Point> intersectRectangles(Rectangle rect1, Rectangle rect2){
		List<Point> results = new ArrayList<Point>();
		for(Line a : rect1.lines){
			for(Line b: rect2.lines){
				Point intersect = a.intersect(b);
				if(intersect!=null)
					results.add(intersect);
			}
		}
		return results;
	}
	
	public static boolean adjacentRectangles(Rectangle rect1, Rectangle rect2){
		if(rect1.topLeft.x == rect2.topLeft.x + rect2.getWidth() ||
				rect1.topLeft.x + rect1.getWidth()  == rect2.topLeft.x ||
				rect1.topLeft.y == rect2.topLeft.y + rect2.getHeight() ||
				rect1.topLeft.y + rect1.getHeight()  == rect2.topLeft.y)
			return true;
		return false;
	}

}
