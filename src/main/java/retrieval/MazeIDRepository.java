package retrieval;

import java.util.List;

/**
 * The type Maze id repository.
 */
public class MazeIDRepository implements MazeRetrieverContainer {

    /**
     * A list of unique identifiers for each maze.
     */
    List<Integer> mazeIDs;

    /**
     * Instantiates a new Maze id repository.
     *
     * @param mazeIDs the maze IDs to be added to the list
     */
    public MazeIDRepository(List<Integer> mazeIDs) {
        this.mazeIDs = mazeIDs;
    }

    @Override
    public MazeRetrieverIterator getIterator() {
        return new IdMazeRetrieverIterator();
    }

    private class IdMazeRetrieverIterator implements MazeRetrieverIterator {

        /**
         * The Index.
         */
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
