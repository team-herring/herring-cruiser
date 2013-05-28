package org.herring.index.analysis.dispacher;

import org.herring.index.context.ColumnContext;
import org.herring.index.file.writer.FileWriterFileChannel;
import org.herring.index.index.column.Column;
import org.herring.index.index.column.index.writer.IndexWriter;
import org.herring.index.index.column.index.writer.IndexWriterMemoryList;
import org.herring.index.index.column.keyword.KeywordTable;
import org.herring.index.index.column.keyword.KeywordTableMemoryList;

import java.util.List;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class ColumnDispacherSimple implements ColumnDispacher<String> {
    @Override
    public void dispach(List<String> datas, ColumnContext context) {


        //send column
    }

    private Column createColumn(String date, String name, List<String> datas) throws Exception {
        IndexWriter indexWriter = new IndexWriterMemoryList(new FileWriterFileChannel());
        KeywordTable keywordTable = new KeywordTableMemoryList();
        Column column = new Column(date, name, indexWriter, keywordTable);
        column.create(datas);
        column.save(new FileWriterFileChannel());
        return column;
    }
}
