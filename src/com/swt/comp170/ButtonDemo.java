package com.swt.comp170;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ButtonDemo {

	private Display display;
	private Shell shell;
	private Label label;
	private Button greetingButton, clearButton;
	private Text textBox;
	private GridLayout layout;

	public ButtonDemo() {

		display = new Display();
		shell = new Shell(display);
		shell.setText("SWT Demo");
		shell.setSize(400, 200);

		/* 
		 * LAYOUT SETTINGS 
		 */

		layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginTop = 5;
		layout.horizontalSpacing = 1;
		shell.setLayout(layout);

		/* 
		 * LABEL SETTINGS 
		 */

		label = new Label(shell, SWT.BORDER);
		label.setText("Enter your name: ");
		label.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, false, false));

		/* 
		 * TEXT BOX SETTINGS 
		 */

		textBox = new Text(shell, SWT.SHADOW_IN);
		textBox.setText("");
		textBox.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		/*
		 * BUTTON SETTINGS 
		 */

		greetingButton = new Button(shell, SWT.PUSH);
		greetingButton.setText("Say Hello!");
		greetingButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
		clearButton = new Button(shell, SWT.PUSH);
		clearButton.setText("Clear");
		clearButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

		/*
		 * EVENT LISTENERS - ACTIONS TAKEN UPON CLICKING THE GREETING OR CLEAR BUTTONS
		 */

		greetingButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				textBox.forceFocus();
				Text source = textBox;
				String name = source.getText();
				MessageBox message = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK);
				message.setMessage("Hello, " + name + "!");
				message.open();
			}
		});

		clearButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				textBox.setText("");
				textBox.forceFocus();
			}
		});

		/*
		 * GUI EVENT LOOP 
		 */

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {

				display.sleep();
			}
		}
		display.dispose();
	}

	// Create an instance of our GUI window in main()
	public static void main(String[] args) {
		new ButtonDemo();
	}
}
