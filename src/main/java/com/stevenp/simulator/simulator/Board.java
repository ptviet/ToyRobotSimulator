package com.stevenp.simulator.simulator;

public class Board {
  private int rows;
  private int columns;

  public Board(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
  }

  public boolean isValidPosition(Position position) {
    return !(
        position.getX() > this.columns || position.getX() < 0 ||
            position.getY() > this.rows || position.getY() < 0
    );
  }

}
