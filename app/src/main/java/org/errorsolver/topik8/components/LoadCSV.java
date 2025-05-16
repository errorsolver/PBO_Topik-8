package org.errorsolver.topik8.components;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class LoadCSV {

    private final String fileName;
    private InputStream is;
    private final List<CSVRecord> records = new ArrayList<>();
    private String[][] dataParse = {};

    public LoadCSV(String fileName) {
        this.fileName = fileName;
        _getStream();
        _readCSVStream();
        _saveData();
    }

    public String[] getHeader() {
        String[] header = this.records.get(0).getParser().getHeaderNames().toArray(String[]::new);
        return header;
    }

    public String[][] getDatas() {
        return this.dataParse;
    }

    private void _getStream() {
        try {
            this.is = getClass().getClassLoader().getResourceAsStream(this.fileName);
            if (is == null) {
                System.out.println("File CSV tidak ditemukan!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void _readCSVStream() {
        try {
            CSVParser parser = CSVFormat.DEFAULT
                    .withHeader().withSkipHeaderRecord()
                    .parse(new InputStreamReader(this.is));

            for (CSVRecord record : parser) {
                this.records.add(record);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void _saveData() {
        List<CSVRecord> dataTemp = this.records;
        dataTemp.remove(0);

        int dataSize = dataTemp.size();
        int columnCount = this.getHeader().length;
        String[][] rowData = new String[dataSize][columnCount];
        for (int i = 0; i < dataTemp.size(); i++) {
            CSVRecord record = dataTemp.get(i);
            for (int j = 0; j < columnCount; j++) {
                rowData[i][j] = record.get(j);
            }
        }

        this.dataParse = rowData;
    }
}
