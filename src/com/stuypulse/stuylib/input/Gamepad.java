package com.stuypulse.stuylib.input;

import com.stuypulse.stuylib.input.buttons.ButtonWrapper;

/**
 * An class for using gamepads with different interfaces. You can
 * implement this class in another file, and then use it with a standard
 * interface.
 * 
 * Any unimplemented buttons will never be triggered, so if a certain controller
 * is missing one, dont worry about it.
 * 
 * The button type that is used in OI.java is automatically generated by this
 * class, as long as you implement the getRaw...() function, the get...()
 * function will work.
 * 
 * This class does not come with a constructor because by itself, the class does
 * not do anything. You need to extend this class inorder to use it.
 * 
 * @author Sam (sam.belliveau@gmail.com)
 */

public class Gamepad {

    /*******************************/
    /*** IMPLEMENTABLE FUNCTIONS ***/
    /*******************************/

    // Left Stick //
    public double getLeftX()    { return 0.0; }
    public double getLeftY()    { return 0.0; }

    // Right Stick //
    public double getRightX()   { return 0.0; }
    public double getRightY()   { return 0.0; }

    // D-Pad //
    public boolean getRawDPadUp()       { return false; }
    public boolean getRawDPadDown()     { return false; }
    public boolean getRawDPadLeft()     { return false; }
    public boolean getRawDPadRight()    { return false; }

    // Bumpers //
    public boolean getRawLeftBumper()   { return false; }
    public boolean getRawRightBumper()  { return false; }
    
    // Triggers //
    public double getRawLeftTriggerAxis()   { return 0.0; }
    public double getRawRightTriggerAxis()  { return 0.0; }

    // Face Buttons //
    public boolean getRawLeftButton()   { return false; }
    public boolean getRawRightButton()  { return false; }
    public boolean getRawTopButton()    { return false; }
    public boolean getRawBottomButton() { return false; }

    // Start / Select / Option //
    public boolean getRawSelectButton() { return false; }
    public boolean getRawStartButton()  { return false; }
    public boolean getRawOptionButton() { return false; }
    
    // Analog Stick Buttons // 
    public boolean getRawLeftAnalogButton()     { return false; }
    public boolean getRawRightAnalogButton()    { return false; }

    // Rumble //
    public void setRumble(double intensity)     { return; }

    
    /**************************************************/
    /*** BUTTONS BASED OFF OF IMPLEMENTED FUNCTIONS ***/
    /**************************************************/

    // Left Stick //
    public final double getLeftMag() { return Math.hypot(getLeftX(), getLeftY()); }
    public final double getLeftAngle() { 
        double x = getLeftX();
        double y = getLeftY();
        
        if(x == 0 && y == 0) { return 0; }
        else { return Math.toDegrees(Math.atan2(y, x)); }
    }

    // Right Stick //
    public final double getRightMag() { return Math.hypot(getRightX(), getRightY()); }
    public final double getRightAngle() { 
        double x = getRightX();
        double y = getRightY();
        
        if(x == 0 && y == 0) { return 0; }
        else { return Math.toDegrees(Math.atan2(y, x)); }
    }

    // D-Pad //
    public final ButtonWrapper getDPadUp()       { return new ButtonWrapper(() -> this.getRawDPadUp()); }
    public final ButtonWrapper getDPadDown()     { return new ButtonWrapper(() -> this.getRawDPadDown()); }
    public final ButtonWrapper getDPadLeft()     { return new ButtonWrapper(() -> this.getRawDPadLeft()); }
    public final ButtonWrapper getDPadRight()    { return new ButtonWrapper(() -> this.getRawDPadRight()); }

    // Bumpers //
    public final ButtonWrapper getLeftBumper()   { return new ButtonWrapper(() -> this.getRawLeftBumper()); }
    public final ButtonWrapper getRightBumper()  { return new ButtonWrapper(() -> this.getRawRightBumper()); }

    // Triggers //
    protected static final double TRIGGER_AXIS_THRESHOLD = 3.0 / 16.0;

    public final boolean getRawLeftTrigger()    { return getRawLeftTriggerAxis() > TRIGGER_AXIS_THRESHOLD; }
    public final ButtonWrapper getLeftTrigger()  { return new ButtonWrapper(() -> this.getRawLeftTrigger()); }

    public final boolean getRawRightTrigger()   { return getRawRightTriggerAxis() > TRIGGER_AXIS_THRESHOLD; }
    public final ButtonWrapper getRightTrigger() { return new ButtonWrapper(() -> this.getRawRightTrigger()); }

    // Face Buttons // 
    public final ButtonWrapper getLeftButton()   { return new ButtonWrapper(() -> this.getRawLeftButton()); }
    public final ButtonWrapper getRightButton()  { return new ButtonWrapper(() -> this.getRawRightButton()); }
    public final ButtonWrapper getTopButton()    { return new ButtonWrapper(() -> this.getRawTopButton()); }
    public final ButtonWrapper getBottomButton() { return new ButtonWrapper(() -> this.getRawBottomButton()); }

    // Select / Start / Option //
    public final ButtonWrapper getSelectButton() { return new ButtonWrapper(() -> this.getRawSelectButton()); }
    public final ButtonWrapper getStartButton()  { return new ButtonWrapper(() -> this.getRawStartButton()); }
    public final ButtonWrapper getOptionButton() { return new ButtonWrapper(() -> this.getRawOptionButton()); }

    // Analog Stick Buttons // 
    public final ButtonWrapper getLeftAnalogButton()     { return new ButtonWrapper(() -> this.getRawLeftAnalogButton()); }
    public final ButtonWrapper getRightAnalogButton()    { return new ButtonWrapper(() -> this.getRawRightAnalogButton()); }
}
