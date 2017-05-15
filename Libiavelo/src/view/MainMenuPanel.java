package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenuPanel  extends JPanel
{
	private Thread animationThread;
	
	private int animationState;
	
	public MainMenuPanel(String personnelMemberName)
	{
		super();
		
		this.add(new JLabel("Bienvenue, " + personnelMemberName + "."));
		this.setBackground(Color.WHITE);
		
		animationState = 0;
		
		animationThread = new AnimationThread();
		animationThread.start();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int xCenter = this.getWidth() / 2;
		int yCenter = this.getHeight() / 2;
		
		// ROAD - DARK LINES
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, yCenter + 45, this.getWidth(), 10);
		g.fillRect(0, yCenter + 80, this.getWidth(), 10);
		g.fillRect(0, yCenter + 115, this.getWidth(), 10);
		
		// ROAD - MIDDLE LINE BLANKS
		g.setColor(Color.WHITE);
		
		int spacing = this.getWidth() / 3;
		
		for(int i = 0; i < 3; i++)
		{
			g.fillPolygon(
					new int[] {
							15 - animationState + i * 2 * spacing, 
							15 - animationState + i * spacing + (i + 1) * spacing,
							- animationState + i * spacing + (i + 1) * spacing, 
							- animationState + i * 2 * spacing
						}, 
					new int[] {yCenter + 80, yCenter + 80, yCenter + 90, yCenter + 90}, 
					4);
		}
		
		// BIKE - WHEELS
		g.setColor(Color.BLACK);
		g.fillOval(xCenter + 40 - 25, yCenter + 20, 50, 50);
		g.fillOval(xCenter - 40 - 25, yCenter + 20, 50, 50);
		
		g.setColor(Color.WHITE);
		g.fillOval(xCenter + 42 - 25, yCenter + 22, 46, 46);
		g.fillOval(xCenter - 38 - 25, yCenter + 22, 46, 46);
		
		// BIKE - FRAME
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(xCenter - 22 - 25, yCenter + 42, 46, 5);
		g.fillRect(xCenter - 20, yCenter + 6, 48, 5);
		g.fillPolygon(
				new int[] {xCenter - 25, xCenter - 20, xCenter, xCenter - 5}, 
				new int[] {yCenter, yCenter, yCenter + 50, yCenter + 50}, 
				4);
		g.fillPolygon(
				new int[] {xCenter - 20, xCenter - 15, xCenter - 38, xCenter - 43}, 
				new int[] {yCenter + 6, yCenter + 6, yCenter + 45, yCenter + 45}, 
				4);
		g.fillPolygon(
				new int[] {xCenter + 20, xCenter + 25, xCenter + 45, xCenter + 40}, 
				new int[] {yCenter - 8, yCenter - 8, yCenter + 50, yCenter + 50}, 
				4);
		g.fillPolygon(
				new int[] {xCenter + 27, xCenter + 33, xCenter, xCenter - 7}, 
				new int[] {yCenter + 13, yCenter + 13, yCenter + 45, yCenter + 45}, 
				4);
		
		// BIKE - HUBS
		g.setColor(Color.GRAY);
		g.fillOval(xCenter + 58 - 25, yCenter + 38, 14, 14);
		g.fillOval(xCenter - 22 - 25, yCenter + 38, 14, 14);
		
		// BIKE - SADDLE
		g.fillRoundRect(xCenter - 31, yCenter - 5, 16, 5, 5, 5);
		
		// BIKE - PEDAL
		g.fillOval(xCenter - 12, yCenter + 38, 14, 14);
		
		// BIKE - HANDLEBAR
		g.fillRoundRect(xCenter + 9, yCenter - 12, 16, 5, 5, 5);
	}
	
	private class AnimationThread extends Thread
	{
		@Override
		public void run() 
		{
			this.setName("AnimationThread");
			
			int delay = 10;
			
			while(isVisible())
			{
				animationState++;
				
				if(animationState >= (2 * MainMenuPanel.this.getWidth() / 3))
					animationState = 0;
				
				repaint();
				
				try 
				{
					Thread.sleep(delay);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	};
}

