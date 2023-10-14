import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReaderMain {
    public static void main(String[] args) throws IOException, CsvException {
        // Путь к вашему CSV-файлу
        String csvFile = "путь_к_вашему_файлу.csv";

        try (CSVReaderMain reader = new CSVReader(new FileReader(csvFile), new CSVParserBuilder().withSeparator('\t').build())) {
            List<String[]> records = reader.readAll();

            for (String[] record : records) {
                // Пример: Вывести значение для первой колонки
                String value = record[0];
                System.out.println("Значение: " + value);
            }
        }
    }
}
