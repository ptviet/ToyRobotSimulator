package com.stevenp.simulator.simulator.service;

import com.stevenp.simulator.exception.SimulatorException;
import com.stevenp.simulator.simulator.enums.*;
import com.stevenp.simulator.simulator.model.*;
import org.springframework.stereotype.Service;

@Service
public class SimulatorImpl implements Simulator {
  private Board board;
  private Robot robot;

  public SimulatorImpl() {
  }

  @Override
  public void initBoard(Board board) {
    this.board = board;
  }

  @Override
  public void initRobot(Robot robot) {
    this.robot = robot;
  }

  /*
   * Places the robot on the board in position X,Y and facing NORTH, SOUTH, EAST or WEST
   *
   * @param position Robot position
   * @return true if placed successfully
   * @throws SimulatorException
   */
  @Override
  public boolean placeRobot(Position position) throws SimulatorException {
    if (board == null)
      throw new SimulatorException("Invalid Board object");

    if (robot == null)
      throw new SimulatorException("Invalid Robot object");

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
   * Validates and executes a string command.
   *
   * @param inputString command string
   * @return string value of the executed command
   * @throws SimulatorException
   *
   */
  @Override
  public void simulate(String inputString) throws SimulatorException {

    String[] args = inputString.split(" ");

    // validate command
    Command command;
    try {
      command = Command.valueOf(args[0]);
    } catch (IllegalArgumentException e) {
      throw new SimulatorException("Invalid command");
    }
    if (command == Command.PLACE && args.length < 2) {
      throw new SimulatorException("Invalid command");
    }

    // validate PLACE params
    String[] params;
    int x = 0;
    int y = 0;
    Direction commandDirection = null;
    if (command == Command.PLACE) {
      params = args[1].split(",");
      try {
        x = Integer.parseInt(params[0]);
        y = Integer.parseInt(params[1]);
        commandDirection = Direction.valueOf(params[2]);
      } catch (Exception e) {
        throw new SimulatorException("Invalid command");
      }
    }

    if (command != Command.PLACE) {
      if (robot.getPosition() == null) {
        throw new SimulatorException("Place Robot on Board first!");
      }
    }

    switch (command) {
      case PLACE:
        placeRobot(new Position(x, y, commandDirection));
        break;

      case MOVE:
        if (board.isValidPosition(robot.getPosition().getNextPosition()))
          robot.move();
        break;

      case LEFT:
        robot.rotateLeft();
        break;

      case RIGHT:
        robot.rotateRight();
        break;

      case REPORT:
        System.out.println("\n" + report() + "\n");
        break;

      default:
        throw new SimulatorException("Invalid command");
    }

  }

  @Override
  public String report() {
    return robot.report();
  }
}
