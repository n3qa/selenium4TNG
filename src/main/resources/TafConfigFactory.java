package net.aldi.taf.core;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Factory;
import org.aeonbits.owner.loaders.Loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>TafConfigFactory class.</p>
 */
public class TafConfigFactory {

    private static LinkedHashMap<String,Object> Global_Config = new LinkedHashMap<>();

    /** Don't let anyone instantiate this class */
    private TafConfigFactory() {}

    /**
     * Returns a new instance of a config Factory object.
     * @return a new instance of a config Factory object.
     */
    public static Factory newInstance() {
        return ConfigFactory.newInstance();
    }

    /**
     * <p>create.</p>
     *
     * @param clazz a {@link java.lang.Class} object.
     * @param imports a {@link java.util.Map} object.
     * @param <T> a T object.
     * @return a T object.
     */
    public static <T extends Config> T create(Class<? extends T> clazz, Map<?, ?>... imports) {
        HashMap<String, Object> props;
        Long threadId = Thread.currentThread().getId();
        T obj =  ConfigFactory.create(clazz, imports);
        boolean mask;
        HashMap<String,Object> values = new HashMap<>();
        for (Method method:clazz.getMethods()) {
            mask = false;
            Config.Key key = method.getAnnotation(Config.Key.class);
            if(key==null){continue;}
            MaskValue mask_anno = method.getAnnotation(MaskValue.class);
            if(mask_anno!=null){ mask = mask_anno.value();}
            try {
                method.setAccessible(true);
                values.put(key.value(), mask ? "*****": method.invoke(obj));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        Global_Config.put(clazz.getSimpleName(),values);
        return obj;
    }
    /**
     * <p>getModulConfig.</p>
     * @return a {@link java.util.LinkedHashMap} object.
     */
    public static LinkedHashMap<String,Object> getModulConfig(){
        return Global_Config == null ? new LinkedHashMap<>() : Global_Config;
    }
    /**
     * <p>setProperty.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param value a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String setProperty(String key, String value) {
        return ConfigFactory.setProperty(key, value);
    }

    /**
     * <p>getProperties.</p>
     * @return a {@link java.util.Properties} object.
     */
    public static Properties getProperties() {
        return ConfigFactory.getProperties();
    }

    /**
     * <p>setProperties.</p>
     * @param properties a {@link java.util.Properties} object.
     */
    public static void setProperties(Properties properties) {
        ConfigFactory.setProperties(properties);
    }


    /**
     * <p>getProperty.</p>
     * @param key a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getProperty(String key) {
        return ConfigFactory.getProperty(key);
    }

    /**
     * <p>clearProperty.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String clearProperty(String key) {
        return ConfigFactory.clearProperty(key);
    }

    /**
     * <p>registerLoader.</p>
     * @param loader a {@link org.aeonbits.owner.loaders.Loader} object.
     */
    public static void registerLoader(Loader loader) {
        ConfigFactory.registerLoader(loader);
    }
}
