package cistec.prueba.rest.service;

import java.util.List;

import cistec.prueba.rest.constants.ApiConstants;
import cistec.prueba.rest.model.LoginAnswerObject;
import cistec.prueba.rest.model.Project;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.Call;

public interface RestService {

    @FormUrlEncoded
    @POST(ApiConstants.SIGNIN_POST)
    Call<LoginAnswerObject> logIn (@Field("user_name")String username, @Field("password")String password);

    @GET(ApiConstants.LIST_GET)
    Call<List<Project>> getList(@Header("X-Authorization") String authToken);
}
