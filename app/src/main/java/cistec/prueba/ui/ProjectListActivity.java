package cistec.prueba.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import cistec.prueba.R;
import cistec.prueba.rest.model.Project;

public class ProjectListActivity extends AppCompatActivity {

    private List<Project> projects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
    }
}
