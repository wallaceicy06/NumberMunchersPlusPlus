package com.seanharger.numbermunchers.game.view;

import java.awt.Dimension;

public interface IGameViewToModelAdapter {
    
  public String getGameName();
  
  public int getLevel();
  
  public void onLeftKeyPress();
  
  public void onRightKeyPress();
  
  public void onUpKeyPress();
  
  public void onDownKeyPress();
  
  public void onSpaceBarPress();
  
  public void stop();
}
