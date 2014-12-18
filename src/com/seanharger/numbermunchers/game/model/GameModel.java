package com.seanharger.numbermunchers.game.model;

import java.util.List;

import com.seanharger.numbermunchers.game.model.character.ICharacter;

public class GameModel {
  
  private IGameModelToViewAdapter _view;
  
  private List<ICharacter> _gameCharacters;
  
  public GameModel(IGameModelToViewAdapter view) {
    _view = view;
    
    
  }
  
  public void start() {

  }

}
