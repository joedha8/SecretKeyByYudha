package id.rackspira.secretkeyholder;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStoreUtils {
    private static final String PREF_FILE_NAME = "id.rackspira.secretkeyholder";
    private static final String KEY_SECRET = "secret_key";
    private static final String URL_SECRET = "secret_url";

    public static void setKeySecret(String secret, Context context) {
        try {
            SharedPreferences.Editor editor = getSharedEditor(context);
            editor.putString(KEY_SECRET, secret);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getKeySecret(Context context) {
        try {
            SharedPreferences pref = getSharedPreference(context);
            return pref.getString(KEY_SECRET, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setUrlSecret(String secret, Context context) {
        try {
            SharedPreferences.Editor editor = getSharedEditor(context);
            editor.putString(URL_SECRET, secret);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrlSecret(Context context) {
        try {
            SharedPreferences pref = getSharedPreference(context);
            return pref.getString(URL_SECRET, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SharedPreferences.Editor getSharedEditor(Context context)
            throws Exception {
        if (context == null) {
            throw new Exception("Context null Exception");
        }
        return getSharedPreference(context).edit();
    }

    private static SharedPreferences getSharedPreference(Context context)
            throws Exception {
        if (context == null) {
            throw new Exception("Context null Exception");
        }
        return context.getSharedPreferences(PREF_FILE_NAME, 0);
    }
}
