package com.stevenp.simulator.simulator.service;

import com.stevenp.simulator.exception.SimulatorException;
import com.stevenp.simulator.simulator.model.*;

public interface Simulator {
  void initBoard(Board board);
  void initRobot(Robot robot);
  boolean placeRobot(Position position) throws SimulatorException;
  void simulate(String inputString) throws SimulatorException;
  String report();
}
