package com.seanharger.numbermunchers.game.model.character;

public interface IComputerCharacter extends IMovableCharacter {
  
  public void move(IMovableCharacterToGameModelAdapter remote);

}
