package com.seanharger.numbermunchers.application.view;

public interface IApplicationViewToModelAdapter<TGameClass, TLevelClass> {

  public void onPlayPressed(TGameClass gameType, TLevelClass levelType);
}
