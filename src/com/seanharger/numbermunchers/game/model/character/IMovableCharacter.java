package com.seanharger.numbermunchers.game.model.character;

import com.seanharger.numbermunchers.game.util.IPaintStrategy;

public interface IMovableCharacter extends IBoardItem {

  public void interactWith(IBoardItem other);
  
}
