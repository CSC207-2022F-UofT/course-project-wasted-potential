package solvability;

public class MazeSolvablePresenter implements MazeSolvableOutBoundary {
    public MazeSolvabilityResponseModel reportSolvability(boolean solvable) {
        if (solvable) {
            return new MazeSolvabilityResponseModel(true,
                    "This maze is solvable", "#86d154");
        }
        return new MazeSolvabilityResponseModel(false,
                "This maze is not solvable", "#d4555d");    }
}
