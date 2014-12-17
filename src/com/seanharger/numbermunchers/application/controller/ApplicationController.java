package com.seanharger.numbermunchers.application.controller;

import java.util.ArrayList;
import java.util.List;

import com.seanharger.numbermunchers.application.model.ApplicationModel;
import com.seanharger.numbermunchers.application.model.IApplicationModelToViewAdapter;
import com.seanharger.numbermunchers.application.view.ApplicationView;
import com.seanharger.numbermunchers.application.view.IApplicationViewToModelAdapter;
import com.seanharger.numbermunchers.game.model.IMunchersGameType;
import com.seanharger.numbermunchers.game.model.IMunchersLevel;

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
    
    _view = new ApplicationView(new IApplicationViewToModelAdapter<IMunchersGameType, IMunchersLevel>() {

      @Override
      public void onPlayPressed(IMunchersGameType gameType, IMunchersLevel levelType) {
        
      }
      
    });
  }
  
  private List<IMunchersGameType> loadGameTypes() {
    ArrayList<IMunchersGameType> gameTypes = new ArrayList<IMunchersGameType>();
    gameTypes.add(new IMunchersGameType() {
      
      private List<IMunchersLevel> _testLevels = new ArrayList<IMunchersLevel>();
      
      {
        _testLevels.add(new IMunchersLevel() {
          @Override
          public String toString() {
            return "Test level";
          }
        });
      } 
      
      @Override
      public List<IMunchersLevel> getLevelOptions() {
        return _testLevels;
      }
      
      @Override
      public String toString() {
        return "Test game";
      }
      
    });
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
