package com.seanharger.numbermunchers.game.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import com.seanharger.numbermunchers.game.model.character.IComputerCharacter;
import com.seanharger.numbermunchers.game.model.character.NumberFood;
import com.seanharger.numbermunchers.game.util.IFactory;

public interface IMunchersGameType {

  public Dimension getBoardDimensions();
  
  public ArrayList<IFactory<IComputerCharacter>> getAvailableMonsters(int level);
  
  public int getMonsterSpeed(int level);
  
  public int getMonsterSpawnInterval(int level);
  
  public int getMaximumMonsters(int level);
  
  public String getGameName();
    
  public boolean isCorrectAnswer(int number);
}
