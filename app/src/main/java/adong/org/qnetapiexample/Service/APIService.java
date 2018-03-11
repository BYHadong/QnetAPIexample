package adong.org.qnetapiexample.Service;

import adong.org.qnetapiexample.GetURL;
import adong.org.qnetapiexample.PEdata.PEResult;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user011 on 2018-03-11.
 */

public interface APIService {
    @GET(GetURL.suportURL + GetURL.PEListURL + GetURL.servicekey)
    Call<PEResult> getPEResult();
}
