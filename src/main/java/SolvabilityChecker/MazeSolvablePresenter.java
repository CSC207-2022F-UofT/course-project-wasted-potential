package SolvabilityChecker;

public class MazeSolvablePresenter implements MazeSolvableOutBoundary {
    public void reportSuccess() {
        System.out.println("Maze is solvable");
    }
    public void reportFailure() {
        System.out.println("Maze is NOT solvable");
    }
}
