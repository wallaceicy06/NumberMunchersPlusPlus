package com.seanharger.numbermunchers.application.model;

import java.util.List;

import com.seanharger.numbermunchers.game.model.IMunchersGameType;
import com.seanharger.numbermunchers.game.model.gametypes.TestGameType;

public class ApplicationModel {

  private IApplicationModelToViewAdapter _view;
  
  private List<IMunchersGameType> _supportedGameTypes;
  
  public ApplicationModel(List<IMunchersGameType> supportedGameTypes, IApplicationModelToViewAdapter view) {
    _view = view;
    _supportedGameTypes = supportedGameTypes;
    _supportedGameTypes.add(new TestGameType());
  }
  
  public void start() {
    _view.setSupportedGameTypes(_supportedGameTypes);
  }
}

