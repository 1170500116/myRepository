/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P2.turtle;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        turtle.color(PenColor.BLUE);
        for(int i = 0 ;i<4;i++) {
        	turtle.forward(sideLength);
        	turtle.turn(90.00);
        }
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        return (sides-2)*180.00/sides;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
       return (int)Math.round(2/(1-angle/180));
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
       for(int i=0;i<sides;i++) {
    	   turtle.forward(sideLength);
    	   turtle.turn(180-calculateRegularPolygonAngle(sides));
       }
    }

    /**
     * Given the current direction, current location, and a target location, calculate the Bearing
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentBearing. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentBearing current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to Bearing (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY,
                                                 int targetX, int targetY) {
       int y = targetY - currentY;
       int x = targetX - currentX;
       double theta;
       if(x==0) {
    	   if(y>0) {
    		   theta = 0.00;
    	   }else {
    		   theta = Math.PI;
    	   }
    	
       }else {
    	   theta = Math.atan((double)y/(double)x);
    	   if(x<0) {
    			   theta = -theta +3*Math.PI/2;
    		   if(theta == 2*Math.PI) {
    			   theta = 0;
    		   }
    	   }else {
    		   if(y<=0) {
    			   
    			   theta = Math.PI/2 - theta;
    			
    		   } 
    		  
    	   }
       }
       theta = theta*180/Math.PI;
      
       return (theta - currentBearing>=0)?(theta - currentBearing):(360.00+theta - currentBearing);
  
    }

    /**
     * Given a sequence of points, calculate the Bearing adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateBearingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of Bearing adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateBearings(List<Integer>xCoords , List<Integer> yCoords) {
    	 List<Double> d = new ArrayList<>(); 
    	if(xCoords.size()==yCoords.size()) {
    	
    	   if(xCoords.size()==0) {
    		     		 
    	
    	   }else {
    		   int i;
    		   for(i=0;i<xCoords.size()-1;i++) {	
    			   if(i==0) {
    			 double ans =calculateBearingToPoint(0.00,xCoords.get(i),yCoords.get(i),xCoords.get(i+1),yCoords.get(i+1));
    				   d.add(ans);
    				
    			   }else {
    				
    				   d.add( calculateBearingToPoint(d.get(i-1),xCoords.get(i),yCoords.get(i),xCoords.get(i+1),yCoords.get(i+1)));
    			   }  
    			  
    		   }
    	
    	   }
       }
    	
  	  return d; 
    }
    
    /**
     * Given a set of points, compute the convex hull, the smallest convex set that contains all the points 
     * in a set of input points. The gift-wrapping algorithm is one simple approach to this problem, and 
     * there are other algorithms too.
     * 
     * @param points a set of points with xCoords and yCoords. It might be empty, contain only 1 point, two points or more.
     * @return minimal subset of the input points that form the vertices of the perimeter of the convex hull
     */
    public static Set<Point> convexHull(Set<Point> points) {
    	
    	Point zuizuo ;
    	zuizuo = new Point(0.0,0.0);
    	Point last;
    	double min;
    	int i = 0;
    	for(Iterator<Point>iter = points.iterator();iter.hasNext();) {
    		Point temp = iter.next();
    		if(i==0) {
    			zuizuo = temp;
    			i++;
    		}else {
    			if(temp.x()<=zuizuo.x()) {
    				zuizuo = temp;
        		}
    			i++;
    		}
		}
    	Set<Point> ans = new HashSet<>();
    	List<Point> ls = new ArrayList<>();
    	if(i==0) {
    		
    		
    	}else {
    		min =360;
    		while(true) {
    			double last_angle = min;
    			min = 360;
    		
    		last = zuizuo;
    		if(ans.contains(zuizuo)) {
    			break;
    		}else {
    			ans.add(zuizuo);
    			ls.add(zuizuo);
    		}

    		for(Iterator<Point>iter = points.iterator();iter.hasNext();) {
    			Point temp = iter.next();
    			if(temp==last) {
    				
    			}else {
    				if(ans.size()==1) {
    					double test = calculateBearingToPoint(0.00, (int)last.x(), (int)last.y(),
          		               (int)temp.x(), (int)temp.y());
     					if(test <min) {
     						min = test;
     						zuizuo = temp;
     					}
    				}else {
    					double test = calculateBearingToPoint(last_angle, (int)last.x(), (int)last.y(),
           		               (int)temp.x(), (int)temp.y());
      					if(test <min) {
      						min = test;
      						zuizuo = temp;
      					}
    				}
    				
    			
    			}
        	}
    		}
    	}
   
    	if(ans.size()>=4){
    	 
    
    	List<Integer> x = new ArrayList<>();
    	List<Integer> y = new ArrayList<>();
    	
    	
    	for(i = 0;i<ls.size();i++) {
    		x.add((int) ls.get(i).x());
    		y.add((int) ls.get(i).y());
    	}
    
    	
    	for(i = 0;i<x.size();i++) {
    		List<Integer> xx = new ArrayList<>();
        	List<Integer> yy = new ArrayList<>();
        	xx.add(x.get(i));
        	xx.add(x.get((i+1)%x.size()));
        	xx.add(x.get((i+2)%x.size()));
        	yy.add(y.get(i));
        	yy.add(y.get((i+1)%y.size()));
        	yy.add(y.get((i+2)%y.size()));
        
        
        	List<Double> d = calculateBearings(xx , yy);
        	
        	if(d.get(0).equals(d.get(1))) {        	
        		x.remove(i+1);
        		y.remove(i+1);
        	}
        	
    	}
  
    	
    	Set<Point> ans2 = new HashSet<>();
    	for(Iterator<Point>iter = ans.iterator();iter.hasNext();) {
    	 
    		Point temp = iter.next();
    		
    		for(i=0;i<x.size();i++) {
    			if(x.get(i).equals((int)temp.x())&&y.get(i).equals((int)temp.y())) {
    				ans2.add(temp);
    				break;
    			}
    		}
    			
    	}
    
    
    	return ans2;
    	}
    	
    	return ans;
    	
    	
    	
    }
    
    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt( DrawableTurtle turtle1) {
    	 turtle1.color(PenColor.RED);
         turtle1.setCurrentPosition(new Point(-200,130));
         small_fun( turtle1,100);
         turtle1.draw();
         turtle1.setCurrentPosition(new Point(-50,170));
         small_fun( turtle1,30);
         turtle1.setCurrentPosition(new Point(-30,110));
         small_fun( turtle1,30);
         turtle1.setCurrentPosition(new Point(-65,60));
         small_fun( turtle1,30);
         turtle1.setCurrentPosition(new Point(-100,50));
         small_fun( turtle1,30);
         
       
         turtle1.color(PenColor.BLACK);
         turtle1.setCurrentPosition(new Point(-230,-200));
         turtle1.setCurrentHeading(0.0);
         turtle1.forward(370);
         turtle1.turn(80);
         turtle1.forward(220);
         turtle1.turn(100);
         turtle1.forward(180);
         turtle1.turn(80);
         turtle1.forward(220);
         
         
   
    }
    public static void small_fun( DrawableTurtle turtle,int sides_length) {
     	turtle.turn(90);
        for(int i =0;i<5;i++) {
     	   turtle.forward( sides_length);
     	   turtle.turn(144);
        }
    	
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        drawSquare(turtle, 40);

        // draw the window
        turtle.draw();
        DrawableTurtle turtle2 = new DrawableTurtle();
        drawRegularPolygon( turtle2,5, 20);
        turtle2.draw();
        DrawableTurtle turtle1 = new DrawableTurtle();
        drawPersonalArt(turtle1);
    
    }

}
