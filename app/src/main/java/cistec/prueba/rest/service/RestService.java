package cistec.prueba.rest.service;

import java.util.List;

import cistec.prueba.rest.constants.ApiConstants;
import cistec.prueba.rest.model.LoginAnswerObject;
import cistec.prueba.rest.model.Project;
import cistec.prueba.rest.model.ProjectListAnswerObject;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.Call;

public interface RestService {

    /**
     * RESR Api call for login. Its a POST call.
     * @param username username
     * @param password password
     * @return Login answer object
     */
    @FormUrlEncoded
    @POST(ApiConstants.SIGNIN_POST)
    Call<LoginAnswerObject> logIn (@Field("user_name")String username, @Field("password")String password);

    /**
     * REST Api call for getting the project list.
     * @param authToken authorization token
     * @return Get Project list answer object
     */
    @GET(ApiConstants.LIST_GET)
    Call<ProjectListAnswerObject> getList(@Header("X-Authorization") String authToken);
}
