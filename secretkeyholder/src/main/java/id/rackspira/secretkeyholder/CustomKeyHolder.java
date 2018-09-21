package id.rackspira.secretkeyholder;

import android.content.Context;
import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class CustomKeyHolder {

    private Context context;

    public CustomKeyHolder(Context context){
        this.context=context;
    }

    public void setSecretKey(String apiKey){
        if(LocalStoreUtils.getAppSecret(context)==null) {

            byte[] data = Base64.decode(apiKey, Base64.DEFAULT);
            try {
                LocalStoreUtils.setAppSecret(new String(data, "UTF-8"), context);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public String getSecretKey(){
        return LocalStoreUtils.getAppSecret(context);
    }

}