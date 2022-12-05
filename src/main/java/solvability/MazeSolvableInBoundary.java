package solvability;

import entities.DesignableMaze;

public interface MazeSolvableInBoundary {
    public MazeSolvabilityResponseModel checkMazeSolvability(DesignableMaze maze);
}
