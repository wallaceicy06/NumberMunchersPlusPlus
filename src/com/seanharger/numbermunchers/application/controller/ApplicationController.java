package com.seanharger.numbermunchers.application.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import com.seanharger.numbermunchers.application.model.ApplicationModel;
import com.seanharger.numbermunchers.application.model.IApplicationModelToViewAdapter;
import com.seanharger.numbermunchers.application.view.ApplicationView;
import com.seanharger.numbermunchers.application.view.IApplicationViewToModelAdapter;
import com.seanharger.numbermunchers.game.controller.GameController;
import com.seanharger.numbermunchers.game.controller.IGameControllerToApplicationAdapter;
import com.seanharger.numbermunchers.game.model.GameModel;
import com.seanharger.numbermunchers.game.model.IGameModelToViewAdapter;
import com.seanharger.numbermunchers.game.model.IMunchersGameType;
import com.seanharger.numbermunchers.game.model.IMunchersLevel;
import com.seanharger.numbermunchers.game.model.character.IComputerCharacter;
import com.seanharger.numbermunchers.game.view.GameView;
import com.seanharger.numbermunchers.game.view.IGameViewToModelAdapter;

public class ApplicationController {

  private ApplicationModel _model;
  private ApplicationView _view;

  public ApplicationController() {
    List<IMunchersGameType> gameTypes = loadGameTypes();

    _model = new ApplicationModel(gameTypes, new IApplicationModelToViewAdapter() {

      @Override
      public void setSupportedGameTypes(List<IMunchersGameType> gameTypes) {
        _view.setSupportedGameTypes(gameTypes);
      }

    });

    _view =
        new ApplicationView(
            new IApplicationViewToModelAdapter<IMunchersGameType>() {

              @Override
              public void onPlayPressed(IMunchersGameType gameType) {
                GameController gameController = new GameController(gameType, new IGameControllerToApplicationAdapter() {
                });
                gameController.start();
              }

            });
  }

  private List<IMunchersGameType> loadGameTypes() {
    ArrayList<IMunchersGameType> gameTypes = new ArrayList<IMunchersGameType>();

    return gameTypes;
  }

  public static void main(String[] args) {
    new ApplicationController().start();
  }

  public void start() {
    _model.start();
    _view.start();
  }
}
