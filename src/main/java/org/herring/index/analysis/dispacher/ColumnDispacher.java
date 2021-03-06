package org.herring.index.analysis.dispacher;

import org.herring.index.context.ColumnContext;

import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface ColumnDispacher<T> {
    void dispach(List<T> datas, ColumnContext context);
}
