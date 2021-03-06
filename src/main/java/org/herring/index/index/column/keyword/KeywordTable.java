package org.herring.index.index.column.keyword;

import org.herring.index.file.reader.FileReader;
import org.herring.index.file.writer.FileWriter;

import java.io.IOException;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public interface KeywordTable {
    Long appendKeyword(String keyword);
    String get(Long key);
    Long get(String keyword);
    void save(FileWriter fileWriter, String directory, String fileName) throws IOException;
    void load(FileReader fileReader, String directory, String fileName) throws IOException;
    void discard();
}