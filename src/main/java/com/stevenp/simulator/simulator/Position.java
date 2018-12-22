package com.stevenp.simulator.simulator;

import com.stevenp.simulator.exception.ToyRobotException;

public class Position {
  private int x;
  private int y;
  private Direction direction;

  public Position(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  private Position(Position position) {
    this.x = position.getX();
    this.y = position.getY();
    this.direction = position.getDirection();
  }

  private void change(int x, int y) {
    this.x = this.x + x;
    this.y = this.y + y;
  }

  public Position getNextPosition() throws ToyRobotException {
    if (this.direction == null)
      throw new ToyRobotException("Invalid robot direction");

    // new position to validate
    Position newPosition = new Position(this);
    switch (this.direction) {
      case NORTH:
        newPosition.change(0, 1);
        break;
      case EAST:
        newPosition.change(1, 0);
        break;
      case SOUTH:
        newPosition.change(0, -1);
        break;
      case WEST:
        newPosition.change(-1, 0);
        break;
    }
    return newPosition;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
