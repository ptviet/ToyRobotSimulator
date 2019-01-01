package com.stevenp.simulator.simulator.model;

import com.stevenp.simulator.exception.SimulatorException;
import com.stevenp.simulator.simulator.enums.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RobotTest {

  private Robot robot;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    robot = new Robot(new Position(0, 0, Direction.NORTH));
  }

  @Test
  public void testReport() throws SimulatorException {
    Assert.assertEquals("0,0,NORTH", robot.report());
  }

  @Test
  public void testMovement() throws SimulatorException {

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