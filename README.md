# Java GUI Demos - SWT

## Configuring SWT for Java Projects on Eclipse

---

The Standard Widget Toolkit (SWT) is a library that allows you to incorporate basic GUI elements and widgets into your programs.  Once you configure your IDE with the SWT files, you can incorporate these widgets into your programs.

---

**1**. Go to [](https://download.eclipse.org/eclipse/downloads/) and navigate to the **Latest Release heading**.  You’ll see a column titled **Build Name**.  Click on the build number that corresponds to the version of Eclipse you downloaded for class.  It will likely be version 4.14 (or higher), but if you’re unsure, just open Eclipse and click on the “About Eclipse” tab in the top menu bar.  

![figure1](./images/figure1.png)

**2**.  After clicking on the build number, you’ll be taken to the downloads page.  Scroll down toward the bottom of the page, where you’ll find a heading called **SWT Binary and Source**.  There, you will select the appropriate download link for the operating system you’re using (Windows/Mac/Linux).

![figure1](./images/figure2.png)

**3**.  Once the zip file is downloaded, ***don’t unzip the file***.  Just take note of where it was downloaded on your computer (Desktop, Downloads folder, etc.).

**4**.  Now that the SWT files are downloaded, we can add them to a project/workspace.  We’ll create a small project just to see a simple example of SWT widgets being used.  Go back to Eclipse and create a new project: `File -> New -> Java Project`.  You can name it whatever you’d like.  I called this example `GUIDemo`.  *Leave everything else at default and click Finish.  Note: you don’t need to create module-info.java for this example.  When prompted, just press the ‘don’t create’ button*. 

![figure1](./images/figure3.png)

**5**.  Inside Eclipse, go to `File -> Import`.  The Import dialog screen will open, and from there you will select Existing **Projects into Workspace** and press the `Next` button.

![figure1](./images/figure4.png)
