package test.springdata.sample.util;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public final class KeyUtils {

    public static String toKeyString(Key parentKey, String kind, Long id) {
        Key key = KeyFactory.createKey(parentKey, kind, id);
        return KeyFactory.keyToString(key);
    }

    public static String toKeyString(String parentKey, String kind, Long id) {
        return toKeyString(KeyFactory.stringToKey(parentKey), kind, id);
    }

    public static Long toKeyId(String key) {
        return KeyFactory.stringToKey(key).getId();
    }
}
