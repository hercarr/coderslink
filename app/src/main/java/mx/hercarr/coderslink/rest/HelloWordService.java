package mx.hercarr.coderslink.rest;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hercarr on 7/5/16.
 */
public interface HelloWordService {

    @GET("/greeting")
    Call<CoderLinkResponse> sayHello();

}
