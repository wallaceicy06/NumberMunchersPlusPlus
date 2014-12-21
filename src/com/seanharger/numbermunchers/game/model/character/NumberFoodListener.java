package com.seanharger.numbermunchers.game.model.character;

import java.util.EventListener;
import java.util.EventObject;

public interface NumberFoodListener extends EventListener {
  
  public void onEat(NumberFoodEvent e);
  
  public class NumberFoodEvent extends EventObject {

    private static final long serialVersionUID = -2230363554820689088L;

    public NumberFoodEvent(NumberFood source) {
      super(source);
    }
    
  }
}
