package org.errorsolver.topik8.components;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class LoadCSV {

    // private final String filePath;
    private String fileName;
    private InputStream is;
    private final List<CSVRecord> records = new ArrayList<>();
    private String[][] dataParse = {};

    // private void load() {
    //  try (FileReader reader = new FileReader(this.filePath, StandardCharsets.UTF_8)) {
    //     Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
    //     for (CSVRecord record : records) {
    //         // Menampilkan nilai setiap kolom dalam baris CSV
    //         for (String header : record.toMap().keySet()) {
    //             System.out.print(record.get(header) + " ");
    //         }
    //         System.out.println();
    //     }
    // } catch (IOException e) {
    //     e.printStackTrace();
    // }
    // }
    // ambil file dri resources

       public LoadCSV(String fileName) {
        this.fileName = fileName;
        // load();
        _getStream();
        _readCSVStream();
        _saveData();
        // readCSVStream(); // Do not call overridable method in constructor
    }
    
    // ambil header
    public String[] getHeader() {
        String[] header = this.records.get(0).getParser().getHeaderNames().toArray(String[]::new);
        // System.out.println("Header: " + this.records.get(0).getParser().getHeaderNames());
        // this.records.get(0).getParser().getHeaderNames().forEach(action);
        return header;
    }

    public String[][] getData() {
        // int rowCount = this.records.size();
        // int colCount = this.getHeader().length;
        // String[][] stringArrayData = new String[rowCount][colCount];
        // for (int i = 0; i < rowCount; i++) {
        //     CSVRecord record = this.records.get(i);
        //     for (int j = 0; j < colCount; j++) {
        //         stringArrayData[i][j] = record.get(j);
        //     }
        // }
        // return stringArrayData;
        return this.dataParse;
    }

    // ambil file dri resources
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

    // baca file csv
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

    // simpan data
    private void _saveData() {
        System.out.println("Data: " + this.records.get(1).getParser().getRecords());
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
