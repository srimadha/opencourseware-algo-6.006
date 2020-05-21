package com.handy;

/**
 * Created by Sri on 6/11/2019.
 **/

/**
 * Assumptions:
 1. The board is an NxN square.
 2. The board’s squares start white but can flip to black.
 3. Multiple ants start in the center of the board (pick any center cell for even sided boards).
 4. Ants can be facing North, South, East or West.
 5. We want to make the ants take M steps.
 Ant 1:
 1. Starts off facing North.
 2. When on a white square, rotate 90o clockwise, toggle the square to black, step in the new
 direction
 3. When on a black square, rotate 90o counterclockwise, toggle the square to white, step in the
 new direction
 Ant 2:
 1. Starts off facing West.
 2. Always rotate 90o counterclockwise and step in the new direction
 (In the future, there may be other types of Ants with different behavior)
 Output:
 Please print the board with the colors of each cell along with the location and direction of each ant at
 the end of each step.
 What you will be graded on:
 ● Correctness
 ● Extensibility
 ● Code readability
 ● Code structure and organization
 */

import java.util.Arrays;
import java.util.function.Function;

public class LangtonsAnts {

    public static void main(String args[]) {
        LangtonsAnts la = new LangtonsAnts();
        int boardSize = 3;
        int steps = 6;
        Color board[][] = new Color[boardSize][boardSize];


        // Initialize Ant1
        AntOrientation antOrientation = la.getAntPosOrientation(boardSize, Direction.N);
        la.initializeBoard(board, Color.W);
        Function<BoardDetails, BoardDetails> antBehaviour = getAnt1BehaviorFunction(la);
        la.simulateAntMovements(board, antOrientation, antBehaviour, steps);

        // Initialize Ant2
        AntOrientation antOrientation2 = la.getAntPosOrientation(boardSize, Direction.W);
        la.initializeBoard(board, Color.W);
        Function<BoardDetails, BoardDetails> antBehaviour2 = getAnt2BehaviorFunction(la);
        la.simulateAntMovements(board, antOrientation2, antBehaviour2, steps);
    }

    public void simulateAntMovements(Color board[][], AntOrientation antOrientation, Function<BoardDetails, BoardDetails> antBehaviour, int steps) {
        for (int i = 0; i <= steps; i++) {
            printBoard(board, i);
            printAntOrientation(antOrientation);
            BoardDetails currBoardDetails = new BoardDetails(antOrientation, board[antOrientation.pos.x][antOrientation.pos.y]);
            BoardDetails simulatedBoardDetails = antBehaviour.apply(currBoardDetails);
            board[antOrientation.pos.x][antOrientation.pos.y] = simulatedBoardDetails.color;
            antOrientation = simulatedBoardDetails.antOrientation;
        }
    }

    private static Function<BoardDetails, BoardDetails> getAnt1BehaviorFunction(LangtonsAnts la) {
        return boardDetails -> {
            AntOrientation antOrientation = boardDetails.antOrientation;
            AntOrientation newAntOrientation;
            Color newColor;
            switch (boardDetails.color) {
                case W: {
                    // Rotate and flip 90Deg Clockwise if W and Flip
                    newAntOrientation = antOrientation.rotateAndStep(90);
                    newColor = Color.B;
                    break;
                }
                case B: {
                    // Rotate and flip -90Deg Clockwise if B and Flip
                    newAntOrientation = antOrientation.rotateAndStep(-90);
                    newColor = Color.W;
                    break;
                }
                default:
                    throw new IllegalArgumentException("Invalid Color");
            }
            // Returning the modified Board details
            return la.getModifiedBoard(newAntOrientation, newColor);
        };
    }

    private static Function<BoardDetails, BoardDetails> getAnt2BehaviorFunction(LangtonsAnts la) {
        return boardDetails -> {
            AntOrientation newAntOrientation = boardDetails.antOrientation.rotateAndStep(90);
            return la.getModifiedBoard(newAntOrientation, boardDetails.color);
        };
    }

    public AntOrientation getAntPosOrientation(int boardSize, Direction d) {
        Position pos = getStartPosition(boardSize);
        return new AntOrientation(pos, d);
    }

    public Position getStartPosition(int size) {
        if (size % 2 == 1) {
            return new Position(size / 2, size / 2);
        } else {
            // Randomize the position of even boards
            int xInc = Math.random() < 0.5 ? 0 : -1;
            int yInc = Math.random() < 0.5 ? 0 : -1;
            return new Position(size / 2 + xInc, size / 2 + yInc);
        }
    }

    class BoardDetails {
        AntOrientation antOrientation;
        Color color;

        public BoardDetails(AntOrientation antOrientation, Color color) {
            this.antOrientation = antOrientation;
            this.color = color;
        }
    }

    class AntOrientation {
        Position pos;
        Direction dir;

        public AntOrientation(Position pos, Direction dir) {
            this.pos = pos;
            this.dir = dir;
        }

        public AntOrientation rotateAndStep(int deg) {
            Direction newDir = getNewDirection(deg);
            Position newPosition;
            switch (newDir) {
                case N:
                    newPosition = pos.incrementX(-1);
                    break;
                case S:
                    newPosition = pos.incrementX(1);
                    break;
                case E:
                    newPosition = pos.incrementY(1);
                    break;
                case W:
                    newPosition = pos.incrementY(-1);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Direction");
            }
            return new AntOrientation(newPosition, newDir);
        }

        private Direction getNewDirection(int deg) {
            switch (deg) {
                case 90: {
                    switch (dir) {
                        case N:
                            return Direction.E;
                        case E:
                            return Direction.S;
                        case S:
                            return Direction.W;
                        case W:
                            return Direction.N;
                    }
                }
                case -90: {
                    switch (dir) {
                        case N:
                            return Direction.W;
                        case E:
                            return Direction.N;
                        case S:
                            return Direction.E;
                        case W:
                            return Direction.S;
                    }
                }
            }
            throw new IllegalArgumentException("Invalid value for degree");
        }

        public String toString() {
            return "Ant Orientation : " + pos.toString() + " Direction : " + dir;
        }
    }

    class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position incrementX(int inc) {
            return new Position(this.x + inc, this.y);
        }


        public Position incrementY(int inc) {
            return new Position(this.x, this.y + inc);
        }

        public String toString() {
            return this.x + "," + this.y;
        }
    }

    enum Color {
        W, B
    }

    enum Direction {
        N, E, W, S
    }

    public void initializeBoard(Color board[][], Color c) {
        for (Color row[] : board) {
            Arrays.fill(row, c);
        }
    }

    private void printBoard(Color board[][], int i) {
        System.out.println("Simulation Step : " + i);
        for (Color row[] : board) {
            for (Color c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private void printAntOrientation(AntOrientation antOrientation) {
        System.out.println(antOrientation.toString() + "\n");
    }

    public BoardDetails getModifiedBoard(AntOrientation ao, Color c) {
        return new BoardDetails(ao, c);
    }

}
