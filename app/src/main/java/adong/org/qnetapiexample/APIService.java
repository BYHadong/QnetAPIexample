package adong.org.qnetapiexample;

import adong.org.qnetapiexample.data.PEResult;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user011 on 2018-03-11.
 */

public interface APIService {
    @GET(GetURL.suportURL + GetURL.PEListURL + GetURL.servicekey)
    Call<PEResult> getPEResult();
}
