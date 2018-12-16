package cistec.prueba.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import java.util.List;

import cistec.prueba.R;
import cistec.prueba.rest.adapter.CistecRestAdapter;
import cistec.prueba.rest.model.Project;
import cistec.prueba.rest.model.ProjectListAnswerObject;
import cistec.prueba.ui.adapter.RVAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectListActivity extends AppCompatActivity {

    private List<Project> projects;

    private CistecRestAdapter cistecRestAdapter;

    private RVAdapter adapter;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    private String access_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        //Initialize the view components
        initViews();
        getAccessTokenFromSharedPreferences();

        //Get ProjectList
        cistecRestAdapter = new CistecRestAdapter();
        executeRestGetProjectList();
    }

    /**
     * Executes the call to the api and manages the results
     */
    private void executeRestGetProjectList(){
        Call<ProjectListAnswerObject> call = cistecRestAdapter.getList(this.access_token);
        call.enqueue(new Callback<ProjectListAnswerObject>() {
            @Override
            public void onResponse(Call<ProjectListAnswerObject> call, Response<ProjectListAnswerObject> response) {
                onGetProjectSuccess(call, response);
            }

            @Override
            public void onFailure(Call<ProjectListAnswerObject> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.get_projectList_error, Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    /**
     * Gets the response data and initializes the adapter and the recycler view
     * @param call api call
     * @param response api response
     */
    private void onGetProjectSuccess(Call<ProjectListAnswerObject> call, Response<ProjectListAnswerObject> response) {
        this.projects = response.body().getData();
        this.adapter = new RVAdapter(this.projects, this);
        this.recyclerView.setAdapter(this.adapter);

    }

    /**
     * Gets the access token from the shared preferences
     */
    private void getAccessTokenFromSharedPreferences() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref), Context.MODE_PRIVATE);
        String accessTokenKey = getResources().getString(R.string.access_token_key);
        this.access_token= sharedPref.getString(accessTokenKey,"");

    }

    /**
     * Initializes the view components
     */
    private void initViews(){
        this.recyclerView = (RecyclerView) findViewById(R.id.projectListView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                executeRestGetProjectList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
