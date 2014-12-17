package com.seanharger.numbermunchers.application.model;

import java.util.List;

import com.seanharger.numbermunchers.game.model.IMunchersGameType;

public class ApplicationModel {

  private IApplicationModelToViewAdapter _view;
  
  private List<IMunchersGameType> _supportedGameTypes;
  
  public ApplicationModel(List<IMunchersGameType> supportedGameTypes, IApplicationModelToViewAdapter view) {
    _view = view;
    _supportedGameTypes = supportedGameTypes;
  }
  
  public void start() {
    _view.setSupportedGameTypes(_supportedGameTypes);
  }
}

