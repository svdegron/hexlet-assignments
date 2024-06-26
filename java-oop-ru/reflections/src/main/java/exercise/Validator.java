package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();

        for (Field field: address.getClass().getDeclaredFields()) {
            NotNull annotation = field.getAnnotation(NotNull.class);

            if (annotation != null) {
                try {
                    field.setAccessible(true);
                    Object valueOfField = field.get(address);

                    if (valueOfField == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {

        Map<String, List<String>> notValidItems = new HashMap<>();
        // {country=[length less than 4], street=[can not be null]}
        for (Field field: address.getClass().getDeclaredFields()) {
            NotNull aNotNull = field.getAnnotation(NotNull.class);
            MinLength aMinLength = field.getAnnotation(MinLength.class);
            List<String> notValidFields = new ArrayList<>();

            if (aNotNull != null) {
                try {
                    field.setAccessible(true);
                    Object valueOfField = field.get(address);

                    if (valueOfField == null) {
                        notValidFields.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (aMinLength != null) {
                try {
                    field.setAccessible(true);
                    Object valueOfField = field.get(address);

                    if (valueOfField.toString().length() < aMinLength.minLength()) {
                        notValidFields.add("length less than " + aMinLength.minLength());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (!notValidFields.isEmpty()) {
                notValidItems.put(field.getName(), notValidFields);
            }
        }

        return notValidItems;
    }
}
// END
