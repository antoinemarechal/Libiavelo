package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CustomWindowListener extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
