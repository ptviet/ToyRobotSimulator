package com.stevenp.simulator;

import com.stevenp.simulator.exception.SimulatorException;
import com.stevenp.simulator.simulator.service.Simulator;
import com.stevenp.simulator.simulator.model.Board;
import com.stevenp.simulator.simulator.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {
  @Autowired
  Simulator simulator;

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    Scanner scanner = new Scanner(System.in);
    simulator.initBoard(new Board(5, 5));
    simulator.initRobot(new Robot());

    System.out.println("___________________");
    System.out.println("Toy Robot SimulatorImpl");
    System.out.println("___________________");
    System.out.println("\nValid commands are:");
    System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");
    System.out.println("\nPLACE a Robot: \n");
    System.out.print("> ");
    boolean keepRunning = true;
    while (keepRunning) {
      String inputString = scanner.nextLine();
      if (inputString.equals("EXIT") || inputString.equals("exit")) {
        keepRunning = false;
      } else {
        try {
          simulator.simulate(inputString);
        } catch (SimulatorException e) {
          System.out.println(e.getMessage());
        } finally {
          System.out.print("> ");
        }
      }
    }

  }
}

