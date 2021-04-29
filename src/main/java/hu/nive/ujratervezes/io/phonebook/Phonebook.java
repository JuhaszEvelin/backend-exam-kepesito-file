package hu.nive.ujratervezes.io.phonebook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Phonebook {

    //TODO A paraméterben kapott Mapben a kulcsok nevek, az értékek pedig telefonszámok.
    // Írd ki az összes kulcs-érték párt az outputként megadott címre, minden kulcs-érték párt egy új sorba, az alábbi szintaxisban:
    //
    //név: telefonszám
    //
    //A kiírás sorrendje a fájlba nem fontos, de a Map összes elemét pontosan egyszer írd ki a fájlba!
    //
    //Ha a metódus akármelyik paraméternek null-t kapna, akkor dobj IllegalArgumentException-t!

    public void exportPhonebook(Map<String, String> contacts, String output) {

        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }

        File file = new File(output);
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(file, true)){
            for (Map.Entry<String, String> entry : contacts.entrySet() ) {
                String name = entry.getKey();
                String phoneNum = entry.getValue();
                fileWriter.append(name + ": " + phoneNum + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}