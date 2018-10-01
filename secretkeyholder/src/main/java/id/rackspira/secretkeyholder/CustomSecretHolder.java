package id.rackspira.secretkeyholder;

import android.app.Application;
import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class CustomSecretHolder extends Application {

    public void setSecretKey(String apiKey){
        if(LocalStoreUtils.getKeySecret(getApplicationContext())==null) {

            byte[] data = Base64.decode(apiKey, Base64.DEFAULT);
            try {
                LocalStoreUtils.setKeySecret(new String(data, "UTF-8"), getApplicationContext());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public String getSecretKey(){
        return LocalStoreUtils.getKeySecret(getApplicationContext());
    }

    public void setSecretUrl(String baseUrl){
        if(LocalStoreUtils.getUrlSecret(getApplicationContext())==null) {

            byte[] data = Base64.decode(baseUrl, Base64.DEFAULT);
            try {
                LocalStoreUtils.setUrlSecret(new String(data, "UTF-8"), getApplicationContext());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public String getSecretUrl(){
        return LocalStoreUtils.getUrlSecret(getApplicationContext());
    }

}