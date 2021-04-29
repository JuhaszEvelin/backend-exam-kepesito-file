package hu.nive.ujratervezes.io.phonebook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {

        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }

        File file = new File(output);
        cleanFile(file);
        writeFile(contacts, file);
    }

    private void writeFile(Map<String, String> contacts, File file) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String name = entry.getKey();
                String phoneNum = entry.getValue();
                fileWriter.append(name + ": " + phoneNum + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cleanFile(File file) {
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}