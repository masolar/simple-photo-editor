package com.masolar.gui;

import com.masolar.gui.menu.PhotoEditorMenuBar;

import javax.swing.*;

/**
 * Created by Masolar on 5/12/2017.
 *
 * Represents the frame that will hold all elements of the
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
    }

    /**
     * Sets up the basic frame properties, such as
     * title and closing operation.
     */
    private void doFrameSetup() {
        setTitle("Photo Editor");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        pack();
        setVisible(true);
    }

    /**
     * Sets up the menu bar.
     */
    private void doMenuSetup() {
        setJMenuBar(new PhotoEditorMenuBar());
    }
}
