package design_pattern;

/**
 * It's a container for iterator design pattern.
 * Created by Yau on 12/5/2016.
 */
public interface Container {

    /**
     * Get an iterator.
     *
     * @param theKey searching keyword.
     * @return an iterator.
     */
    public Iterator getIterator(final String theKey);

    /**
     * Size of the iterator.
     *
     * @return a size.
     */
    public int getSize();
}
