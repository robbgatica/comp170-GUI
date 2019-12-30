package com.swt.comp170;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Hello {

	public static void main(String[] args) {

		// Display is the base class for SWT
		Display display = new Display();

		// The shell is the GUI window
		Shell shell = new Shell(display);
		shell.setText("Demo");
		shell.setLayout(new RowLayout());

		// A simple text label placed inside the shell
		Label label = new Label(shell, SWT.NONE);
		label.setText("Hello, World!");

		shell.open();

		// GUI Event Loop
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}




