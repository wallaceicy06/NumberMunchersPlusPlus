package com.seanharger.numbermunchers.game.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.seanharger.numbermunchers.game.model.character.IBoardItem;
import com.seanharger.numbermunchers.game.util.Location;

public class GameBoard {

  private Dimension _boardDimensions;
  private ArrayList<ArrayList<List<IBoardItem>>> _board;
  private Map<IBoardItem, Location> _itemIndex;
  
  public GameBoard(int height, int width) {
    _boardDimensions = new Dimension(width, height);
    _board = new ArrayList<ArrayList<List<IBoardItem>>>(height);
    for (int row = 0; row < height; row++) {
      _board.add(new ArrayList<List<IBoardItem>>(width));
      for (int col = 0; col < width; col++) {
        _board.get(row).add(new LinkedList<IBoardItem>());
      }
    }
    
    _itemIndex = new HashMap<IBoardItem, Location>();
  }
  
  public int getHeight() {
    return _board.size();
  }
  
  public int getWidth() {
    return _board.get(0).size();
  }
  
  public void placeItem(IBoardItem item, int row, int col) {
    _board.get(row).get(col).add(item);
    _itemIndex.put(item, new Location(row, col));
  }
  
  public void removeItem(IBoardItem item) {
    Location loc = _itemIndex.get(item);
    _board.get(loc.row).get(loc.col).remove(item);
    _itemIndex.remove(item);
  }
  
  public Location getItemLocation(IBoardItem item) {
    return _itemIndex.get(item);
  }
  
  public List<IBoardItem> getItemsAtLocation(int row, int col) {
    return _board.get(row).get(col);
  }
}
