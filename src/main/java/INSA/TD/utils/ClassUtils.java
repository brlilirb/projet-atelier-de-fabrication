package INSA.TD.utils;

import java.lang.reflect.ParameterizedType;

public class ClassUtils {

    private ClassUtils() {
    }

    /**
     * Permet de récupérer la classe qui est transmise en <T>
     *
     * @param clazz classe de l'entité
     * @param <T>   infer type
     * @return la classe selon le infer type
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClassType(Class<?> clazz) {
        ParameterizedType superClass = (ParameterizedType) clazz.getGenericSuperclass(); // Récupère la classe parent
        return (Class<T>) superClass.getActualTypeArguments()[0]; // Récupère seulement le premier paramètre <T> dans une classe comme EntityService<T, ..., U>
    }
}
