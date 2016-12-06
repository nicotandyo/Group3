package design_pattern;

/**
 * Iterator for design pattern.
 * Created by Yau on 12/5/2016.
 */
public interface Iterator {

    /**
     * Looking there is next object or not.
     *
     * @return true if there is an object, false otherwise.
     */
    public boolean hasNext();

    /**
     * Iterate to the next object.
     *
     * @return next object.
     */
    public Object next();
}
