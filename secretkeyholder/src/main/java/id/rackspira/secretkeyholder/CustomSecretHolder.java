package id.rackspira.secretkeyholder;

import android.content.Context;
import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class CustomSecretHolder {

    private Context context;

    public CustomSecretHolder(Context context){
        this.context=context;
    }

    public void setSecretKey(String apiKey){
        if(LocalStoreUtils.getKeySecret(context)==null) {

            byte[] data = Base64.decode(apiKey, Base64.DEFAULT);
            try {
                LocalStoreUtils.setKeySecret(new String(data, "UTF-8"), context);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public String getSecretKey(){
        return LocalStoreUtils.getKeySecret(context);
    }

    public void setSecretUrl(String baseUrl){
        if(LocalStoreUtils.getUrlSecret(context)==null) {

            byte[] data = Base64.decode(baseUrl, Base64.DEFAULT);
            try {
                LocalStoreUtils.setUrlSecret(new String(data, "UTF-8"), context);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public String getSecretUrl(){
        return LocalStoreUtils.getUrlSecret(context);
    }

}