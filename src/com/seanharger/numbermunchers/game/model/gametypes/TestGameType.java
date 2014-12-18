package com.seanharger.numbermunchers.game.model.gametypes;

import java.util.ArrayList;
import java.util.List;

import com.seanharger.numbermunchers.game.model.IMunchersGameType;
import com.seanharger.numbermunchers.game.model.IMunchersLevel;
import com.seanharger.numbermunchers.game.model.character.IComputerCharacter;
import com.seanharger.numbermunchers.game.model.character.ReggieMonsterFactory;
import com.seanharger.numbermunchers.game.util.IFactory;

public class TestGameType implements IMunchersGameType {

  private ArrayList<IFactory<IComputerCharacter>> _monsters;
  private String[][] _boardTiles;
  
  public TestGameType() {
    _monsters = new ArrayList<IFactory<IComputerCharacter>>();
    _monsters.add(ReggieMonsterFactory.SINGLETON);
    
    _boardTiles = new String[5][6];
    for (int i = 0; i < _boardTiles.length; i++) {
      for (int j = 0; i < _boardTiles[0].length; j++) {
        _boardTiles[i][j] = String.format("%d%d", i, j);
      }
    }
  }
  
  @Override
  public List<IMunchersLevel> getLevelOptions() {
    return new ArrayList<IMunchersLevel>();
  }

  @Override
  public ArrayList<IFactory<IComputerCharacter>> getAvailableMonsters(int level) {
    return _monsters;
  }

  @Override
  public int getMonsterSpeed(int level) {
    return 2;
  }

  @Override
  public int getMonsterSpawnInterval(int level) {
    return 10;
  }

  @Override
  public int getMaximumMonsters(int level) {
    return 2;
  }

  @Override
  public String getGameName() {
    return "TestGame";
  }

  @Override
  public String[][] getBoardTiles() {
    return _boardTiles;
  }

  @Override
  public boolean isCorrectAnswer(int x, int y) {
    return true;
  }

}
