package cistec.prueba.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cistec.prueba.R;

public class ProjectDetailActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView descriptionTextView;
    private ImageView projectImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        initView();
    }

    private void initView() {
        this.nameTextView = findViewById(R.id.projectdetail_name);
        this.descriptionTextView = findViewById(R.id.projectdetail_description);
        this.projectImageView = findViewById(R.id.projectdetail_image);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            this.nameTextView.setText(bundle.getString("name"));
            this.descriptionTextView.setText(bundle.getString("description"));
            Picasso.get().load(bundle.getString("image_url")).into(this.projectImageView);
        }
    }
}
