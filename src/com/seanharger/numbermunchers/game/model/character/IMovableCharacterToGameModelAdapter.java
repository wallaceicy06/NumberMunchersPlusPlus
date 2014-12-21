package com.seanharger.numbermunchers.game.model.character;

public interface IMovableCharacterToGameModelAdapter {

  public void translate(int dx, int dy);

  public void eat();
}
