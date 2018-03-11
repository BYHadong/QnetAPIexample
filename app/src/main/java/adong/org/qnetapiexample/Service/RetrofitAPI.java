package adong.org.qnetapiexample.Service;

import adong.org.qnetapiexample.GetURL;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user011 on 2018-03-11.
 */

public class RetrofitAPI {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GetURL.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
