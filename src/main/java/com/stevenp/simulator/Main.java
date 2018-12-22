package com.stevenp.simulator;

import com.stevenp.simulator.exception.SimulatorException;
import com.stevenp.simulator.simulator.Board;
import com.stevenp.simulator.simulator.Robot;
import com.stevenp.simulator.simulator.Simulator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class Main implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    Scanner scanner = new Scanner(System.in);
    Board board = new Board(5, 5);
    Robot robot = new Robot();
    Simulator simulator = new Simulator(board, robot);

    System.out.println("___________________");
    System.out.println("Toy Robot Simulator");
    System.out.println("___________________");
    System.out.println("\nValid commands are:");
    System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");
    System.out.println("\nEnter a command: \n");
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

