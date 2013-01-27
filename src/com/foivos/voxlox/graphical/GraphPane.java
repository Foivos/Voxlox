package com.foivos.voxlox.graphical;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class GraphPane extends Component{

	private static final long serialVersionUID = 1L;
	
	private boolean isConnected;
	private double[] data;
	
	public GraphPane(double[] data, boolean isConnected) { 
		this.data = data;
		this.isConnected = isConnected;
	}
	public GraphPane(double[] data) {
		this(data, false);
	}
	
	
	public void paint(Graphics g) {
		if(isConnected) {
			paintConnected(g);
			return;
		}
		paintUnconnected(g);
	}
	
	private void paintUnconnected(Graphics g) {
		Rectangle rect = getGraphArea();
		double min=data[0],max=data[0];
		for(double d : data) {
			if(d>max) {
				max = d;
			}
			if(d<min) {
				min = d;
			}
		}
		double vScaling = (double) rect.height / (max-min);
		double hScaling = (double) rect.width / data.length;
		for(int i=0;i<data.length;i++){
			g.drawRect((int) (i*hScaling), (int) ((data[i]-min)*vScaling), 1, 1);
		}
		
	}
	private void paintConnected(Graphics g) {
		Rectangle rect = getGraphArea();
		double min=data[0],max=data[0];
		for(double d : data) {
			if(d>max) {
				max = d;
			}
			if(d<min) {
				min = d;
			}
		}
		double vScaling = (double) rect.height / (max-min);
		double hScaling = (double) rect.width / data.length;
		Point previusPoint = new Point(0,(int) ((data[0]-min)*hScaling));
		for(int i=0;i<data.length;i++){
			Point nextPoint = new Point((int) (i*hScaling), (int) ((data[i]-min)*vScaling));
			g.drawLine(previusPoint.x, previusPoint.y, nextPoint.x, nextPoint.y);
			previusPoint = nextPoint;
		}
		
	}
	private Rectangle getGraphArea() {
		Rectangle totalArea = getBounds();
		return totalArea;
	}
	public boolean isConnected() {
		return isConnected;
	}
	public double[] getData() {
		return data;
	}
	
}
