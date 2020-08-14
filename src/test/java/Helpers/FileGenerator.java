package Helpers;

import static Junit5.TestBase.PATH_TO_TEST_FILE;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Step;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileGenerator {

  @Step
  public File createPropertiesFile(String fileName) {
    return createFile(PATH_TO_TEST_FILE, fileName, ".properties");
  }

  @Step
  public File createCsvFile(String fileName) {
    return createFile(PATH_TO_TEST_FILE, fileName, ".csv");
  }

  @Step
  public File createFile(String filePath, String fileName, String fileExtension) {
    File file = new File(filePath + fileName + fileExtension);
    try {
      file.createNewFile();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    return file;
  }

  @Step
  public File writeToCsvFile(File file, List<String[]> text) {
    try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
      csvWriter.writeAll(text);
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    return file;
  }

  @Step
  public List<String[]> readCsvFile(File file) {
    List<String[]> data = new ArrayList<>();
    try {
      Reader reader = new FileReader(file, StandardCharsets.UTF_8);
      try (CSVReader csvReader = new CSVReader(reader)) {
        data = csvReader.readAll();
        csvReader.close();
        reader.close();
      }
    } catch (IOException | CsvException e) {
      e.printStackTrace();
    }
    return data;
  }

  @Step
  public void deleteFile(File file) {
    file.delete();
  }
}
