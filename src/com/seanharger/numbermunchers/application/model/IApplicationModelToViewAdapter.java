package com.seanharger.numbermunchers.application.model;

import java.util.List;

import com.seanharger.numbermunchers.game.model.IMunchersGameType;

public interface IApplicationModelToViewAdapter {

  public void setSupportedGameTypes(List<IMunchersGameType> gameTypes);
}
