package com.seanharger.numbermunchers.game.model.character;

import com.seanharger.numbermunchers.game.model.character.NumberFoodListener.NumberFoodEvent;

public class NumberFood implements IBoardItem {
  
  private int _number;
  private boolean _isCorrect;
  private NumberFoodListener _listener;
  
  public NumberFood(int number, boolean isCorrect, NumberFoodListener listener) {
    _number = number;
    _isCorrect = isCorrect;
    _listener = listener;
  }
  
  public void eat() {
    _listener.onEat(new NumberFoodEvent(this));
  }
  
  public int getNumber() {
    return _number;
  }
  
  public boolean isCorrect() {
    return _isCorrect;
  }
 
}
