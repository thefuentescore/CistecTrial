package cistec.prueba.rest.adapter;

import java.util.List;

import cistec.prueba.rest.constants.ApiConstants;
import cistec.prueba.rest.model.Project;
import cistec.prueba.rest.service.RestService;
import retrofit2.Call;

public class CistecRestAdapter extends BaseAdapter implements RestService {
    private RestService cistecRestService;

    public CistecRestAdapter(){
        super(ApiConstants.BASE_CISTEC_URL);
        cistecRestService =  createService(RestService.class);
    }

    @Override
    public Call<Object> logIn(String username, String password) {
        return cistecRestService.logIn(username,password);
    }

    @Override
    public Call<List<Project>> getList(String authToken) {
        return cistecRestService.getList(authToken);
    }
}