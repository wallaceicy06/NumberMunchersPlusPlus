package com.seanharger.numbermunchers.game.model.character;

import com.seanharger.numbermunchers.game.util.IFactory;
import com.seanharger.numbermunchers.game.util.IPaintStrategy;

public class ReggieMonsterFactory implements IFactory<IComputerCharacter> {
  
  public static final ReggieMonsterFactory SINGLETON = new ReggieMonsterFactory();
  
  @Override
  public ReggieMonster make() {
    return new ReggieMonster();
  }
  
  private class ReggieMonster implements IComputerCharacter {

    @Override
    public IPaintStrategy getPaintStrategy() {
      // TODO Auto-generated method stub
      return null;
    }
    
  }
}
