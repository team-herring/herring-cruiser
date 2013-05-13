package org.herring.cruiser.request.analysis;

import java.io.InputStream;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface Request {
    public void analysis(InputStream in) throws Exception;
    public void close();
}
