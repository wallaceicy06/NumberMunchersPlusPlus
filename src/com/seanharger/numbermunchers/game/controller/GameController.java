package com.seanharger.numbermunchers.game.controller;

import com.seanharger.numbermunchers.game.model.GameModel;
import com.seanharger.numbermunchers.game.model.IGameModelToViewAdapter;
import com.seanharger.numbermunchers.game.view.GameView;
import com.seanharger.numbermunchers.game.view.IGameViewToModelAdapter;

public class GameController {

  private IGameControllerToApplicationAdapter _application;
  private GameModel _model;
  private GameView _view;
  
  public GameController(IGameControllerToApplicationAdapter application) {
    _application = application;
    _model = new GameModel(new IGameModelToViewAdapter() {
      
    });
    _view = new GameView(new IGameViewToModelAdapter() {
      
    });
  }
  
  public void start() {
    _model.start();
    _view.start();
  }
}
