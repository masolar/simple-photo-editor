package com.masolar.gui;



import javax.swing.*;

/**
 * Created by Masolar on 5/12/2017.
 *
 * Represents the frame that will hold all elements of the program.
 */
public class ProgramFrame extends JFrame {

    /**
     * This constructor sets up the frame, giving it
     * a menu, a toolset, and a spot for images.
     */
    public ProgramFrame() {
        super();

        // Set up opening, closing, and title of frame.
        doFrameSetup();

        // Set up the menu bar and all menus.
        doMenuSetup();

        pack();
        setVisible(true);
    }

    /**
     * Sets up the basic frame properties, such as
     * title and closing operation.
     */
    private void doFrameSetup() {
        setTitle("Photo Editor");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Sets up the menu bar.
     */
    private void doMenuSetup() {
        JMenuBar menuBar = new JMenuBar();

        // Represents the file menu
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("New");
        menu.add(menuItem);
        menuBar.add(menu);

        // Represents the edit menu
        menu = new JMenu("Edit");

        menuBar.add(menu);

        // Represents the tool menu
        menu = new JMenu("Tools");

        menuBar.add(menu);

        // Represents the window menu
        menu = new JMenu("Window");

        menuBar.add(menu);

        setJMenuBar(menuBar);
    }
}
