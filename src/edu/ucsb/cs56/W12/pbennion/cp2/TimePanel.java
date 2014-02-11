package edu.ucsb.cs56.W12.pbennion.cp2;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.util.*;

/**
 * The main display for the Binary Clock, uses Block.
 * @@@ To Do:
 * @@@ - Additional render layouts, currently only tutorial
 * @@@ - Support for additional block styles, currently only basic
 * @@@ - Better looking text labels for tutorial mode
 * @@@ - Windowless fullscreen support?
 * @author Peter Bennion
 * @version for UCSB CS56, W12, choice points 2
 */
public class TimePanel extends JPanel
{
    protected GroupLayout layout;

    protected Block s1, s2, s4, s8, s10, s20, s40;
    protected Block m1, m2, m4, m8, m10, m20, m40;
    protected Block h1, h2, h4, h8;
    protected Block PM, AM;

    /**
        Constructor
        @param type String representing the layout type, "Tutorial", "Grid", or "Fill"
                    Defaults to "Tutorial" if invalid param
                    currently, only "Tutorial" is supported
    */
    public TimePanel(String type)
    {
        layout = new GroupLayout(this);
            setLayout(layout);

        setBackground(Color.BLACK);

        initBlocks();
        initTutorial();
    }

    /**
        Initializes the blocks with a basic style.
    */
    protected void initBlocks()
    {
        s1 = new Block();
        s2 = new Block();
        s4 = new Block();
        s8 = new Block();
        s10= new Block();
        s20= new Block();
        s40= new Block();

        m1 = new Block();
        m2 = new Block();
        m4 = new Block();
        m8 = new Block();
        m10= new Block();
        m20= new Block();
        m40= new Block();

        h1 = new Block();
        h2 = new Block();
        h4 = new Block();
        h8 = new Block();

        AM = new Block();
        PM = new Block();
    }

    /**
        Initializes a beginner-friendly format with guide labels
    */
    protected void initTutorial()
    {
        //add gaps between components and edges
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //create the guide labels
        JLabel AMLabel = new JLabel("AM");
            AMLabel.setForeground(Color.WHITE);
            AMLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            AMLabel.setVerticalTextPosition(SwingConstants.CENTER);
        JLabel PMLabel = new JLabel("PM");
            PMLabel.setForeground(Color.WHITE);
            PMLabel.setHorizontalAlignment(SwingConstants.CENTER);
            PMLabel.setVerticalAlignment(SwingConstants.CENTER);

        JLabel HLabel = new JLabel("Hours");
            HLabel.setForeground(Color.WHITE);
            HLabel.setHorizontalAlignment(SwingConstants.CENTER);
            HLabel.setVerticalAlignment(SwingConstants.CENTER);
        JLabel M10Label = new JLabel("Minute 10's");
            M10Label.setForeground(Color.WHITE);
            M10Label.setHorizontalAlignment(SwingConstants.CENTER);
            M10Label.setVerticalAlignment(SwingConstants.CENTER);
        JLabel M1_Label = new JLabel("Minute 1's");
            M1_Label.setForeground(Color.WHITE);
            M1_Label.setHorizontalAlignment(SwingConstants.CENTER);
            M1_Label.setVerticalAlignment(SwingConstants.CENTER);
        JLabel S10Label = new JLabel("Second 10's");
            S10Label.setForeground(Color.WHITE);
            S10Label.setHorizontalAlignment(SwingConstants.CENTER);
            S10Label.setVerticalAlignment(SwingConstants.CENTER);
        JLabel S1_Label = new JLabel("Second 1's");
            S1_Label.setForeground(Color.WHITE);
            S1_Label.setHorizontalAlignment(SwingConstants.CENTER);
            S1_Label.setVerticalAlignment(SwingConstants.CENTER);

        JLabel N8Label = new JLabel("8");
            N8Label.setForeground(Color.WHITE);
            N8Label.setHorizontalAlignment(SwingConstants.CENTER);
            N8Label.setVerticalAlignment(SwingConstants.CENTER);
        JLabel N4Label = new JLabel("4");
            N4Label.setForeground(Color.WHITE);
            N4Label.setHorizontalAlignment(SwingConstants.CENTER);
            N4Label.setVerticalAlignment(SwingConstants.CENTER);
        JLabel N2Label = new JLabel("2");
            N2Label.setForeground(Color.WHITE);
            N2Label.setHorizontalAlignment(SwingConstants.CENTER);
            N2Label.setVerticalAlignment(SwingConstants.CENTER);
        JLabel N1Label = new JLabel("1");
            N1Label.setForeground(Color.WHITE);
            N1Label.setHorizontalAlignment(SwingConstants.CENTER);
            N1Label.setVerticalAlignment(SwingConstants.CENTER);

        //tell the layout how to set up columns
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(AMLabel).
             addComponent(PMLabel));
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(AM ).
             addComponent(PM ));
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(N8Label).
             addComponent(N4Label).
             addComponent(N2Label).
             addComponent(N1Label));
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(HLabel).
             addComponent(h8 ).
             addComponent(h4 ).
             addComponent(h2 ).
             addComponent(h1 ));
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(M10Label).
             addComponent(m40).
             addComponent(m20).
             addComponent(m10));
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(M1_Label).
             addComponent(m8 ).
             addComponent(m4 ).
             addComponent(m2 ).
             addComponent(m1 ));
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(S10Label).
             addComponent(s40).
             addComponent(s20).
             addComponent(s10));
        hGroup.addGroup(layout.createParallelGroup().
             addComponent(S1_Label).
             addComponent(s8 ).
             addComponent(s4 ).
             addComponent(s2 ).
             addComponent(s1 ));
        layout.setHorizontalGroup(hGroup);

        //tell the layout how to set up rows
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(HLabel).
            addComponent(M10Label).
            addComponent(M1_Label).
            addComponent(S10Label).
            addComponent(S1_Label));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(N8Label).
            addComponent(h8 ).
            addComponent(m8 ).
            addComponent(s8 ));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(N4Label).
            addComponent(h4 ).
            addComponent(m40).
            addComponent(m4 ).
            addComponent(s40).
            addComponent(s4 ));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(AMLabel).
            addComponent(AM ).
            addComponent(N2Label).
            addComponent(h2 ).
            addComponent(m20).
            addComponent(m2 ).
            addComponent(s20).
            addComponent(s2 ));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(PMLabel).
            addComponent(PM ).
            addComponent(N1Label).
            addComponent(h1 ).
            addComponent(m10).
            addComponent(m1 ).
            addComponent(s10).
            addComponent(s1 ));
        layout.setVerticalGroup(vGroup);
    }

    /**
        Get the blocks representing hours
        @return an array of Blocks h8, h4, h2, h1
    */
    public Block[] getHour()
    {
        Block[] b = {h1, h2, h4, h8};
        return b;
    }

    /**
        Get the blocks representing the 10s digit of minutes
        @return an array of Blocks m40, m20, m10
    */
    public Block[] getMinute10s()
    {
        Block[] b = {m10, m20, m40};
        return b;
    }

    /**
        Get the blocks representing the 1s digit of minutes
        @return an array of Blocks m8, m4, m2, m1
    */
    public Block[] getMinute1s()
    {
        Block[] b = {m1, m2, m4, m8};
        return b;
    }

    /**
        Get the blocks representing the 10s digit of seconds
        @return an array of Blocks s40, s20, s10
    */
    public Block[] getSecond10s()
    {
        Block[] b = {s10, s20, s40};
        return b;
    }

    /**
        Get the blocks representing the 1s digit of seconds
        @return an array of Blocks s8, s4, s2, s1
    */
    public Block[] getSecond1s()
    {
        Block[] b = {s1, s2, s4, s8};
        return b;
    }

    /**
        Get the blocks representing Am and Pm
        @return an array of blocks AM, PM
    */
    public Block[] getAmPm()
    {
        Block[] b = {AM, PM};
        return b;
    }

}
