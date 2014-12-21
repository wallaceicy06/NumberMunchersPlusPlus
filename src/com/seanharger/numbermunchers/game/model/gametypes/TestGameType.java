package com.seanharger.numbermunchers.game.model.gametypes;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import com.seanharger.numbermunchers.game.model.IMunchersGameType;
import com.seanharger.numbermunchers.game.model.IMunchersLevel;
import com.seanharger.numbermunchers.game.model.character.IComputerCharacter;
import com.seanharger.numbermunchers.game.model.character.ReggieMonsterFactory;
import com.seanharger.numbermunchers.game.util.IFactory;

public class TestGameType implements IMunchersGameType {

  private ArrayList<IFactory<IComputerCharacter>> _monsters;
  
  public TestGameType() {
    _monsters = new ArrayList<IFactory<IComputerCharacter>>();
    _monsters.add(ReggieMonsterFactory.SINGLETON);
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
  public boolean isCorrectAnswer(int number) {
    return true;
  }
  
  @Override
  public String toString() {
    return "TestGame";
  }

  @Override
  public Dimension getBoardDimensions() {
    return new Dimension(6, 5);
  }

}
