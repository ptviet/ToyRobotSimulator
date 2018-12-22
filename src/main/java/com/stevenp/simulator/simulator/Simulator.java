package com.stevenp.simulator.simulator;

import com.stevenp.simulator.exception.SimulatorException;

public class Simulator {
  Board board;
  Robot robot;

  public Simulator(Board board, Robot robot) {
    this.board = board;
    this.robot = robot;
  }

  /*
   * Places the robot on the board in position X,Y and facing NORTH, SOUTH, EAST or WEST
   *
   * @param position Robot position
   * @return true if placed successfully
   * @throws SimulatorException
   */
  public boolean placeRobot(Position position) throws SimulatorException {
    if (board == null)
      throw new SimulatorException("Invalid Board object");

    if (position == null)
      throw new SimulatorException("Invalid Position object");

    if (position.getDirection() == null)
      throw new SimulatorException("Invalid Direction value");

    // validate the position
    if (!board.isValidPosition(position))
      return false;

    // if position is valid then assign values to fields
    robot.setPosition(position);
    return true;
  }

  /*
   * Evals and executes a string command.
   *
   * @param inputString command string
   * @return string value of the executed command
   * @throws SimulatorException
   *
   */
  public String eval(String inputString) throws SimulatorException {
    return "";
  }

  /*
   * Returns the X,Y and Direction of the robot
   */
  public String report() {
    return "";
  }

}
