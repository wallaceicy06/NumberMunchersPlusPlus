package com.seanharger.numbermunchers.application.view;

public interface IApplicationViewToModelAdapter<TGameClass> {

  public void onPlayPressed(TGameClass gameType);
}
