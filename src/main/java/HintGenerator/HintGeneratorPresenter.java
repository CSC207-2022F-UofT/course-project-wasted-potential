package HintGenerator;

import java.util.List;

public class HintGeneratorPresenter implements HintGeneratorOutBoundary {
    public void displayHint(List<int[]> hint) {
        System.out.println(hint);
    }
}
