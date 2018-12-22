package com.stevenp.simulator.simulator;

import com.stevenp.simulator.exception.SimulatorException;
import com.stevenp.simulator.simulator.enums.Direction;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RobotTest {
  @Rule
  public org.junit.rules.ExpectedException thrown = ExpectedException.none();

  @Test
  public void testMovement() throws SimulatorException {

    Robot robot = new Robot(new Position(0, 0, Direction.NORTH));

    robot.move();
    Assert.assertEquals(0, robot.getPosition().getX());
    Assert.assertEquals(1, robot.getPosition().getY());
    Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());


    robot.setPosition(new Position(1, 2, Direction.EAST));
    robot.move();
    robot.move();
    robot.rotateLeft();
    robot.move();

    Assert.assertEquals(3, robot.getPosition().getX());
    Assert.assertEquals(3, robot.getPosition().getY());
    Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());

    robot.setPosition(new Position(0, 0, Direction.NORTH));
    robot.rotateRight();
    Assert.assertEquals(Direction.EAST, robot.getPosition().getDirection());
    robot.rotateRight();
    Assert.assertEquals(Direction.SOUTH, robot.getPosition().getDirection());
    robot.rotateRight();
    Assert.assertEquals(Direction.WEST, robot.getPosition().getDirection());
    robot.rotateRight();
    Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());
    robot.rotateRight();
    Assert.assertEquals(Direction.EAST, robot.getPosition().getDirection());
  }

}