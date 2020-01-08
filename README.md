# Java GUI Demos - SWT

## Configuring SWT for Java Projects on Eclipse

---

The Standard Widget Toolkit (SWT) is a library that allows you to incorporate basic GUI elements and widgets into your programs.  Once you configure your IDE with the SWT files, you can incorporate these widgets into your programs.

Below you'll find a walk-through on how to configure SWT in Eclipse,  as well as a few very simple example projects to highlight some of the fundamental components.  The project files can be found here: [https://github.com/robbgatica/comp170-GUI/tree/master/src/com/swt/comp170](https://github.com/robbgatica/comp170-GUI/tree/master/src/com/swt/comp170)

---

**1**. Go to [https://download.eclipse.org/eclipse/downloads/](https://download.eclipse.org/eclipse/downloads/) and navigate to the **Latest Release heading**.  You’ll see a column titled **Build Name**.  Click on the build number that corresponds to the version of Eclipse you downloaded for class.  It will likely be version 4.14 (or higher), but if you’re unsure, just open Eclipse and click on the “About Eclipse” tab in the top menu bar.  

<p align="center">
<img src="./images/figure1.png" alt="figure1" />
  </p>

**2**.  After clicking on the build number, you’ll be taken to the downloads page.  Scroll down toward the bottom of the page, where you’ll find a heading called **SWT Binary and Source**.  There, you will select the appropriate download link for the operating system you’re using (Windows/Mac/Linux).

<p align="center">
<img src="./images/figure2.png" alt="figure2" />
  </p>

**3**.  Once the zip file is downloaded, ***don’t unzip the file***.  Just take note of where it was downloaded on your computer (Desktop, Downloads folder, etc.).

**4**.  Now that the SWT files are downloaded, we can add them to a project/workspace.  We’ll create a small project just to see a simple example of SWT widgets being used.  Go back to Eclipse and create a new project: `File -> New -> Java Project`.  You can name it whatever you’d like.  I called this example `GUIDemo`.  *Leave everything else at default and click Finish.  Note: you don’t need to create module-info.java for this example.  When prompted, just press the ‘don’t create’ button*. 

<p align="center">
<img src="./images/figure3.png" alt="figure3" />
  </p>

**5**.  Inside Eclipse, go to `File -> Import`.  The Import dialog screen will open, and from there you will select Existing **Projects into Workspace** and press the `Next` button.

<p align="center">
<img src="./images/figure4.png" alt="figure4" />
  </p>

**6**.  Now you’ll see the **Import Projects** screen.  Choose the **Select Archive File** option and browse to the zip file you downloaded earlier.  You should now see a project called `org.eclipse.swt appear` in the Projects list.  Make sure the box next to org.eclipse.swt is checked (as shown below) and click `Finish`.  

<p align="center">
<img src="./images/figure5.png" alt="figure5" />
  </p>

**7**.  At this point, the SWT project files are loaded into your workspace.  Now we can add them to the build path of our newly created `GUIDemo` project.   Select or highlight the GUIDemo project in the Package Explorer (the column on the left side of your screen) to make sure we are inside our project.  Go to `Project -> Properties` and select **Java Build Path** on the left column and then select the **Projects** tab (shown below).  Highlight **Classpath** and click `Add`.

<p align="center">
<img src="./images/figure6.png" alt="figure6" />
  </p>

**8**.  The `org.eclipse.swt` project will appear in the **Required Project Selection** box.  Select this project by checking the box and press OK.  You can ignore the other projects in the figure below, they just happen to be in my current workspace.

<p align="center">
<img src="./images/figure7.png" alt="figure7" />
  </p>

**9**.  You will now be returned to the **Projects** tab of the **Java Build Path** dialog.  The `org.eclipse.swt` project should be shown in the box titled ‘Required projects on the build path’.  Our newly created project – GUIDemo – now has access to all the SWT packages and source code.  Press **Apply and Close**. 

<p align="center">
<img src="./images/figure8.png" alt="figure8" />
  </p>

## Example 1 - Hello World

We can now try out some sample code to get a feel for SWT and work with a few of its fundamental components: The `Display` class, `Shell` class, `Label` class, and the event loop.   We’ll be creating a simple window that displays the text ‘Hello World!’, as shown below: 

<p align="center">
<img src="./images/demo1.png" alt="demo1" />
  </p>
  

1.  To get started, we'll go back to the GUIDemo project and create a new class.  You can name it whatever you’d like (‘Hello’ is the name in my example).  Now that SWT has been configured, we can import the packages we'll need into our program: `org.eclipse.swt`, `org.eclipse.swt.widgets`, and `org.eclipse.swt.layout`.  You can use the wildcard '`*`' operator to include all the files in each package.  

```
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Hello {

	public static void main(String[] args) {
  
  }
 
 }
```
2.  We will now create instances of the `Display` and `Shell` classes.  `Display` is essentially the base class for SWT and the `Shell` class is the GUI window.  For the sake of simplicity, we'll name the instances 'display' and 'shell', respectively.  As you'll see below, the 'shell' instance takes the 'display' object we created as an argument.  

```
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Hello {

	public static void main(String[] args) {
  
  Display display = new Display();
  Shell shell = new Shell(display);
  
  }
 
 }
```

3.  We can now give the shell (the actual GUI window) a title and configure the type of layout we want to use inside.  We'll use the `setText()` and `setLayout` methods of the Shell class to do this.  Layouts determine how the components are arranged inside the window.  However, since we are only using one component in this example, any layout will suffice... I chose `RowLayout`, but there are a number of others to choose from.  You can read more about them [here](https://www.eclipse.org/articles/Article-Understanding-Layouts/Understanding-Layouts.htm).

The last component we'll be adding is a `Label`, which will contain the actual 'Hello World' string.  The process is pretty straight-forward for instantiating a Label object.  You just need to specify a parent component (our shell object) and a style value (none in our case) as arguments upon creation.  The `setText` method is used by the `Label` class as well, and this is where we are placing the 'Hello World' text.  Finally, we need to explicitly call the `open()` method on the shell in order to finish creating the window.  


```
public class Hello {

	public static void main(String[] args) {
  
  Display display = new Display();
  
  Shell shell = new Shell(display);
  shell.setText("Demo");
	shell.setLayout(new RowLayout());

	Label helloLabel = new Label(shell, SWT.NONE);
	helloLabel.setText("Hello, World!");

	shell.open();
  
  }
 
 }
```

4.  We've finished setting up the window, but we are still missing one vital component in our program: an event loop.  This loop keeps the window visible (and running) until the user quits the program/terminates the shell.  Without this block of code, the window would only display for a fraction of second. 

```
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
```


5. Make sure the event loop is added inside your `main()` method in your class and run the program (click [here](https://github.com/robbgatica/comp170-GUI/blob/master/src/com/swt/comp170/Hello.java) to refer the project file).  You should see a window pop up with the text inside.  Feel free to experiment with it.  Change the text inside the window, set different size parameters for the frame, etc.  

## Example 2 - Button Demo

This is another simple example that demonstrates button functionality and the processing of user input:
<p align="center">
<img src="./images/demo2.png" alt="demo2" />
<img src="./images/demo3.png" alt="demo3" />
  </p>

[Click here](https://github.com/robbgatica/comp170-GUI/blob/master/src/com/swt/comp170/ButtonDemo.java) to go to the source code.  Tinker with the code to get a feel for how the components interact... and definitely refer to the resources and documentation below!

### Additional Reading
**SWT Tutoria**l: [https://www.vogella.com/tutorials/SWT/article.html](https://www.vogella.com/tutorials/SWT/article.html)<br> 
**Example Code Snippets**: [https://www.eclipse.org/swt/snippets/](https://www.eclipse.org/swt/snippets/)<br> 
**Documentation**: [https://www.eclipse.org/swt/docs.php](https://www.eclipse.org/swt/docs.php)<br>  
