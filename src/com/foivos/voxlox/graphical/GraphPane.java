package com.foivos.voxlox.graphical;

import java.awt.Component;
import java.awt.Graphics;

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
		g.draw3DRect(10, 10, 100, 100, false);
	}
	
	public boolean isConnected() {
		return isConnected;
	}
	public double[] getData() {
		return data;
	}
	
}
