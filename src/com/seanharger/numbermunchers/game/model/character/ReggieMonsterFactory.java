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
    public void move(IMovableCharacterToGameModelAdapter remote) {
      int direction = (int) (Math.random() * 4);
      switch (direction) {
        case 0:
          remote.translate(1, 0);
          break;
        case 1:
          remote.translate(0, 1);
          break;
        case 2:
          remote.translate(-1, 0);
          break;
        case 3:
          remote.translate(0, -1);
          break;
      }
    }

    @Override
    public void interactWith(IBoardItem other) {
      Class<? extends IBoardItem> otherClass = other.getClass();

      if (otherClass == NumberFood.class) {
        NumberFood number = (NumberFood) other;
        if (number.isCorrect()) {
          number.eat();
        }
      } else if (otherClass == ReggieMonster.class) {
        System.out.println("Interacting with Reggie monster.");
      } else {
        System.out.println("Default case.");
      }
    }
    
  }
}
