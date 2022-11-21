package HintGenerator;

import entities.DesignableMaze;

public class HintGeneratorControl {
    private HintGeneratorInBoundary hint_generator_in_boundary;

    public HintGeneratorControl(HintGeneratorInBoundary hint_generator_in_boundary) {
        this.hint_generator_in_boundary = hint_generator_in_boundary;
    }

    public void generateHint(DesignableMaze maze) {
        hint_generator_in_boundary.generateHint(maze);
    }

}
