package com.stevenp.simulator.simulator;

import com.stevenp.simulator.exception.SimulatorException;

public class Robot {
  private Position position;

  public Robot() {
  }

  public Robot(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return this.position;
  }

  public void setPosition(Position position) {
    if (position != null) {
      this.position = position;
    }

  }

  /**
   * Moves the robot one unit forward in the direction it is currently facing
   */
  public void move() throws SimulatorException {
    this.setPosition(position.getNextPosition());
  }

  /**
   * Rotates the robot 90 degrees LEFT
   */
  public void rotateLeft() {
    if (this.position.getDirection() != null) {
      this.position.setDirection(this.position.getDirection().leftDirection());
    }

  }

  /**
   * Rotates the robot 90 degrees RIGHT
   */
  public void rotateRight() {
    if (this.position.getDirection() != null) {
      this.position.setDirection(this.position.getDirection().rightDirection());
    }
  }

}
