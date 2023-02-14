package utility;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import static utility.FieldUtilities.getFields;

public class ObjectUtilities {

    /**
     * restituisce un oggetto di tipo <italic>typeClass</italic> specificando il
     * contenuto degli attributi della classe desiderata
     * <italic>fieldsContent</italic>
     *
     * @param typeClass la classe dell'oggetto da costruire
     * @param fieldsContent il contenuto dei attributi in ordine di apparizione
     * dell'attributo all'interno dalla classe
     * @return l'oggetto della classe <italic>typeClass</italic>
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static Object createObject(Class<?> typeClass, List<String> fieldsContent) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Field> fields = getFields(typeClass);
        Integer fieldsCount = fields.size();
        Class<?>[] fieldsClass = new Class[fieldsCount];
        Object[] fieldsValue = new Object[fieldsCount];

        for (int i = 0; i < fieldsCount; i++) {
            fieldsClass[i] = fields.get(i).getType();
            fieldsValue[i] = parseObject(fieldsClass[i], fieldsContent.get(i));
        }

        return typeClass.getConstructor(fieldsClass).newInstance(fieldsValue);
    }

    /**
     * restituisce un oggetto impostandone il valore corrispettivo
     * <italic>value</italic>
     *
     * @param classType classe dell'oggeto da restituire
     * @param value valore dell'oggetto costruito
     * @return l'oggetto costruito
     * @throws ClassNotFoundException
     */
    public static Object parseObject(Class<?> classType, String value) throws ClassNotFoundException {
        Object object = null;

        if (Byte.class == classType) {
            object = Byte.parseByte(value);
        }

        if (Character.class == classType) {
            object = Byte.parseByte(value);

        }

        if (Integer.class == classType) {
            object = Integer.parseInt(value);
        }

        if (Double.class == classType) {
            object = Double.parseDouble(value);
        }

        if (String.class == classType) {
            object = value;
        }

        if (Boolean.class == classType) {
            object = Boolean.parseBoolean(value);
        }

        if (null == object) {
            throw new ClassNotFoundException();
        }

        return object;
    }
}
