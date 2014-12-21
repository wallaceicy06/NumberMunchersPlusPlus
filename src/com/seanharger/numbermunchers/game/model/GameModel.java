package com.seanharger.numbermunchers.game.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import com.seanharger.numbermunchers.game.model.character.IBoardItem;
import com.seanharger.numbermunchers.game.model.character.IMovableCharacter;
import com.seanharger.numbermunchers.game.model.character.IMovableCharacterToGameModelAdapter;
import com.seanharger.numbermunchers.game.model.character.Muncher;
import com.seanharger.numbermunchers.game.model.character.NumberFood;
import com.seanharger.numbermunchers.game.model.character.ReggieMonsterFactory;

public class GameModel {
  
  private IGameModelToViewAdapter _view;
  
  private IMunchersGameType _gameType;
  private int _level;
  private GameBoard _gameBoard;
  private List<IMovableCharacter> _gameCharacters;
  private IMovableCharacterToGameModelAdapter _userCharacterAdapter;
  
  public GameModel(IMunchersGameType gameType, IGameModelToViewAdapter view) {
    _view = view;
    _gameType = gameType;
    
    _level = 1;
    _gameBoard = new GameBoard(gameType.getBoardDimensions().height, gameType.getBoardDimensions().width);
    
    _gameCharacters = new ArrayList<IMovableCharacter>();
    
    Muncher muncher = new Muncher();
    _gameCharacters.add(muncher);
    _userCharacterAdapter = new IMovableCharacterToGameModelAdapter() {

      @Override
      public void translate(int dx, int dy) {
        
      }

      @Override
      public void eat() {
        
      }
      
    };
  }
  
  public void start() {
    
  }
  
  public String getGameName() {
    return _gameType.getGameName();
  }
  
  public int getLevel() {
    return _level;
  }
  
  public IMovableCharacterToGameModelAdapter getUserCharacterAdapter() {
    return _userCharacterAdapter;
  }

}
