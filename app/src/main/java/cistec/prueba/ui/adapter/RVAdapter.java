package cistec.prueba.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import cistec.prueba.R;
import cistec.prueba.rest.model.Project;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ProjectViewHolder> {

    List<Project> projects;
    Context ctx;

    public RVAdapter(List<Project> projects, Context context) {
        this.projects = projects;
        this.ctx = context;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project, parent, false);
        ProjectViewHolder projectViewHolder = new ProjectViewHolder(view);
        return projectViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder projectViewHolder, int i) {
        projectViewHolder.projectName.setText(projects.get(i).getName());
        projectViewHolder.projectDescription.setText(projects.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return this.projects.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView projectName;
        TextView projectDescription;

        ProjectViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            projectName = (TextView) itemView.findViewById(R.id.projectNameTextView);
            projectDescription  = (TextView) itemView.findViewById(R.id.projectDescriptionTextView);
        }
    }

}
