package com.rectangle.collision.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.geometry.impl.Point;
import com.geometry.impl.Rectangle;
import com.rectangle.collision.RectangleCollision;

@SuppressWarnings("deprecation")
public class TestRectangle {

	@Test
	public void testHeightAndWidth(){
		Rectangle rect = new Rectangle(0,0,10,5);
		Assert.assertEquals("Width is not 10", 10.0,rect.getWidth());
		Assert.assertEquals("Height is not 5", 5.0,rect.getHeight());
	}
	@Test
	public void testContainsRectangle(){
		Rectangle rect1 = new Rectangle(5,5,8,8);
		Rectangle rect2 = new Rectangle(0,0,10,10);
		Rectangle rect3 = new Rectangle(12,12,20,20);
		boolean result = RectangleCollision.containedRectanlges(rect1, rect2);
		Assert.assertFalse(result);
		result = RectangleCollision.containedRectanlges(rect2, rect1);
		Assert.assertTrue(result);
		result = RectangleCollision.containedRectanlges(rect1, rect3);
		Assert.assertFalse(result);
	}
	
	@Test
	public void testAdjacent(){
		Rectangle rect1 = new Rectangle(0,0,5,5);
		Rectangle rect2 = new Rectangle(5,5,10,10);
		Rectangle rect3 = new Rectangle(12,12,20,20);
		Rectangle rect4 = new Rectangle(6,6,20,20);
		Rectangle rect5 = new Rectangle(5,1,40,40);
		
		boolean result = RectangleCollision.adjacentRectangles(rect1, rect2);
		Assert.assertTrue(result); // Test if two sqaures are adjacent to each other at a corner
		result = RectangleCollision.adjacentRectangles(rect1, rect3);
		Assert.assertFalse(result);// Verify that two squares are not adjacent
		result = RectangleCollision.adjacentRectangles(rect2, rect4);
		Assert.assertFalse(result);// Test two squares that intersect, that should not be adjacent
		result = RectangleCollision.adjacentRectangles(rect1, rect5);
		Assert.assertTrue(result);//Test sharing an edge
	}
	
	@Test
	public void testIntersect(){
/*		Rectangle rect1 = new Rectangle(1,1,3,3);
		Rectangle rect2 = new Rectangle(10,10,20,20);
		Rectangle rect3 = new Rectangle(2,2,20,20);*/
		Rectangle rect1 = new Rectangle(1,1,5,5);
		Rectangle rect2 = new Rectangle(3,3,6,6);
		List<Point> result = RectangleCollision.intersectRectangles(rect1, rect2);
		//Verify that if there is no overlap between two Rectangles than the result should be 0
		Assert.assertEquals(2, result.size());
		if(!result.contains(new Point(3,5))){
			Assert.assertTrue(false);
		}
		if(!result.contains(new Point(5,3))){
			Assert.assertTrue(false);
		}
		
		Rectangle rect3 = new Rectangle( 10,10,20,20);
		//Verify two rectangles overlap at two point and verify two points are correct
		result = RectangleCollision.intersectRectangles(rect1, rect3);
		Assert.assertEquals(0, result.size());
		
		Rectangle rect4 = new Rectangle( 2,1,5,7);
		Rectangle rect5 = new Rectangle( 1,2,6,4);
		//Verify two rectangles overlap at four points and verify the four points are correct
		result = RectangleCollision.intersectRectangles(rect4, rect5);
		Assert.assertEquals(4, result.size());
		if(!result.contains(new Point(2,2))){
			Assert.assertTrue(false);
		}
		if(!result.contains(new Point(2,4))){
			Assert.assertTrue(false);
		}
		if(!result.contains(new Point(5,2))){
			Assert.assertTrue(false);
		}
		if(!result.contains(new Point(5,4))){
			Assert.assertTrue(false);
		}
		
	}
}
