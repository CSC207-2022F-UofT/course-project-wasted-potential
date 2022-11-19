package HintGenerator;

import entities.DesignableMaze;
import java.util.List;

public class HintGeneratorInteractor implements HintGeneratorInBoundary {
    private HintGeneratorOutBoundary hint_generator_out_boundary;

    public HintGeneratorInteractor(HintGeneratorOutBoundary hint_generator_out_boundary) {
        this.hint_generator_out_boundary = hint_generator_out_boundary;
    }

    public void generateHint(DesignableMaze maze) {
        List<int[]> hint_path = HintGenerator.generateHint(maze);
        hint_generator_out_boundary.displayHint(hint_path);
    }
}
