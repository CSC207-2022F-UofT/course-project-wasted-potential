package solvability;

import entities.DesignableMaze;

public interface MazeSolvableInBoundary {
    MazeSolvabilityResponseModel checkMazeSolvability(DesignableMaze maze);
}
