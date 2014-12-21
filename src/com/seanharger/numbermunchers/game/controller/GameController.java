package com.seanharger.numbermunchers.game.controller;

import java.awt.Dimension;

import com.seanharger.numbermunchers.game.model.GameModel;
import com.seanharger.numbermunchers.game.model.IGameModelToViewAdapter;
import com.seanharger.numbermunchers.game.model.IMunchersGameType;
import com.seanharger.numbermunchers.game.view.GameView;
import com.seanharger.numbermunchers.game.view.IGameViewToModelAdapter;

public class GameController {

  private IGameControllerToApplicationAdapter _application;
  private GameModel _model;
  private GameView _view;
  
  public GameController(IMunchersGameType gameType, IGameControllerToApplicationAdapter application) {
    _application = application;
    _model = new GameModel(gameType, new IGameModelToViewAdapter() {
      
    });
    
    _view = new GameView(gameType.getBoardDimensions(), new IGameViewToModelAdapter() {

      @Override
      public void onLeftKeyPress() {
        System.out.println("left key press");
        _model.getUserCharacterAdapter().translate(-1, 0);
      }

      @Override
      public void onRightKeyPress() {
        System.out.println("right key press");
        _model.getUserCharacterAdapter().translate(1, 0);
      }

      @Override
      public void onUpKeyPress() {
        System.out.println("up key press");
        _model.getUserCharacterAdapter().translate(0, -1);
      }

      @Override
      public void onDownKeyPress() {
        System.out.println("down key press");
        _model.getUserCharacterAdapter().translate(0, 1);
      }

      @Override
      public void onSpaceBarPress() {
        System.out.println("space key press");
        _model.getUserCharacterAdapter().eat();
      }

      @Override
      public void stop() {
        
      }

      @Override
      public String getGameName() {
        return _model.getGameName();
      }

      @Override
      public int getLevel() {
        return _model.getLevel();
      }
      
    });
  }
  
  public void start() {
    _model.start();
    _view.start();
  }
}
