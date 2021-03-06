package org.herring.index.index.column.keyword;

import org.apache.log4j.Logger;
import org.herring.index.context.ColumnConfig;
import org.herring.index.file.reader.FileReader;
import org.herring.index.file.writer.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class KeywordTableMemoryList implements KeywordTable {
    private static final Logger LOG = Logger.getLogger(KeywordTableMemoryList.class);
    private List<String> keywords;


    public KeywordTableMemoryList() {
        LOG.info("created KeywordTableMemoryList");
        this.keywords = new ArrayList<String>();
    }

    @Override
    public Long appendKeyword(String keyword) {
        String result = null;
        int index = -1;
        for (int i = 0; i < keywords.size(); i++) {
            String target = keywords.get(i);
            boolean isContains = target.equals(keyword);
            if (isContains){
                result = target;
                index = i;
                break;
            }
        }

        if (result != null)
            return (long) index;

        keywords.add(keyword);
        index = keywords.size() - 1;
        return (long) index;
    }

    @Override
    public String get(Long key) {
        if (keywords.size()-1 < key)
            return null;
        return keywords.get(key.intValue());
    }


    @Override
    public Long get(String keyword) {
        for (int i = 0; i < keywords.size(); i++) {
            String str = keywords.get(i);

            if (keyword.equals(str))
                return (long) i;
        }
        return null;
    }

    @Override
    public void save(FileWriter fileWriter, String directory, String fileName) throws IOException {
        fileWriter.createFile(directory, fileName + ColumnConfig.EXTENDS_KEYWORD_NAME);

        for (String keyword : keywords)
            fileWriter.appendLine(keyword);
    }

    @Override
    public void load(FileReader fileReader, String directory, String fileName) throws IOException {

    }

    @Override
    public void discard() {
    }
}
