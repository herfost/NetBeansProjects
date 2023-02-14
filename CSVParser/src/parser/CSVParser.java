package parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utility.FieldUtilities;
import utility.ObjectUtilities;

public class CSVParser {

    /**
     * parsing di un file csv <italic>csvPath</italic> in oggetti
     * <italic>typeClass<italic>
     *
     * @param typeClass la classe di oggetti da leggere: <bold>deve essere un
     * Java Baan<bold>
     * @param csvPath il percorso del file in lettura
     * @param csvDelimiter stringa che serpare i campi (USA: ',' - EUROPA: ';')
     * @return lista di oggetti letti;
     * @throws IOException
     * @throws FileNotFoundException
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     * @throws UnmatchingFieldNameException la numenclatura o l'ordine dei campi
     * non combaciano tra typeClass e cvsPath
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static List<Object> readFromCSV(Class<?> typeClass, String csvPath, String csvDelimiter) throws IOException, FileNotFoundException, NoSuchMethodException, ClassNotFoundException, UnmatchingFieldNameException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InvalidFileTypeException {

        List<Field> fields = FieldUtilities.getFields(typeClass);
        List<String> fieldsNames = FieldUtilities.getFieldsNames(fields);
        List<String> csvFieldsNames = Arrays.asList(getCSVFields(csvPath, csvDelimiter));

        boolean validFieldNames = fieldsNames.equals(csvFieldsNames);
        if (!validFieldNames) {
            String message = String.format("Invalid Field Nameing: fields declared in %s != fields declared in %s", typeClass.getName(), csvPath);
            throw new UnmatchingFieldNameException(message);
        }

        List<String[]> csvRecords = getCSVRecords(csvPath, csvDelimiter);
        List<Object> objects = new ArrayList<>();

        for (String[] record : csvRecords) {
            Object object = ObjectUtilities.createObject(typeClass, Arrays.asList(record));
            objects.add(object);
        }

        return objects;
    }

    /**
     * lettura nome dei campi presenti all'interno del file csv
     * <italic>path</italic>
     *
     * @param path il percorso del file in lettura
     * @param delimiter stringa che serpare i campi (USA: ',' - EUROPA: ';')
     * @return elenco nome dei campi
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidFileTypeException estensione file non valida
     */
    public static String[] getCSVFields(String path, String delimiter) throws FileNotFoundException, IOException, InvalidFileTypeException {
        if (!isCSVPath(path)) {
            throw new InvalidFileTypeException();
        }

        String line = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8).get(0);
        return line.split(delimiter);
    }

    /**
     * lettura dei campi presenti
     *
     * @param path per
     * @param delimiter
     * @return
     * @throws IOException
     * @throws InvalidFileTypeException estensione file non valida
     */
    public static List<String[]> getCSVRecords(String path, String delimiter) throws IOException, InvalidFileTypeException {
        if (!isCSVPath(path)) {
            throw new InvalidFileTypeException();
        }

        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        lines.remove(0); // la prima riga del file contiene i nomi dei campi

        List<String[]> records = new ArrayList<>();
        lines.forEach((line) -> {
            String[] record = line.split(delimiter);
            records.add(record);
        });

        return records;
    }

    /**
     * verifica che l'estensione del percorso path sia .csv
     *
     * @param path il percorso
     * @return true in caso l'estensione sia .csv, false altrimenti
     */
    private static boolean isCSVPath(String path) {
        String extension = path.substring(path.lastIndexOf('.') + 1);
        return "csv".equals(extension);
    }

}
