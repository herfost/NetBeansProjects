package utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldUtilities {

    /**
     * fornisce una lista degli attributi presenti all'interno di una classe
     * <italic>typeClass</italic>
     *
     * @param typeClass la classe di oggetti da leggere: <bold>deve essere un
     * Java Baan<bold>
     * @return lista degli attributi
     */
    public static List<Field> getFields(Class<?> typeClass) {
        return Arrays.asList(typeClass.getDeclaredFields());
    }

    /**
     * fornisce una lista delle class (DataType) degli attributi presenti
     * all'interno di una classe
     * <italic>typeClass</italic>
     *
     * @param typeClass la classe di oggetti da leggere: <bold>deve essere un
     * @return lista delle classi (DataType) degli attributi
     */
    public static List<Class<?>> getFieldsTypes(Class<?> typeClass) {
        List<Field> fields = Arrays.asList(typeClass.getDeclaredFields());
        List<Class<?>> classes = new ArrayList<>();
        fields.forEach((field) -> {
            classes.add(field.getType());
        });

        return classes;
    }

    // OK
    public static List<String> getFieldsNames(List<Field> fields) {
        List<String> fieldsName = new ArrayList<>();
        fields.forEach((field) -> {
            fieldsName.add(field.getName());
        });

        return fieldsName;
    }
}
