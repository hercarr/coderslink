package mx.hercarr.coderslink.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hercarr on 7/5/16.
 */
public class CodersLinkAPI {

    private static final String URL_BASE = "http://rest-service.guides.spring.io";
    private static Retrofit retrofit;
    private static HelloWordService helloWordService;

    private CodersLinkAPI() {

    }

    static {
        setupRetrofit();
        setupApis();
    }

    private static void setupRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }

    private static void setupApis() {
        helloWordService = retrofit.create(HelloWordService.class);
    }

    public static HelloWordService getHelloWordService() {
        return helloWordService;
    }
}
