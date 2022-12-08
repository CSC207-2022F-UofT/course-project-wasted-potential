package retrieval;

import java.util.List;

public class MazeIDRepository implements MazeRetrieverContainer {

    List<Integer> mazeIDs;

    public MazeIDRepository(List<Integer> mazeIDs) {
        this.mazeIDs = mazeIDs;
    }

    @Override
    public MazeRetrieverIterator getIterator() {
        return new IdMazeRetrieverIterator();
    }

    private class IdMazeRetrieverIterator implements MazeRetrieverIterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < mazeIDs.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return mazeIDs.get(index++);
            }
            return null;
        }

    }
}
