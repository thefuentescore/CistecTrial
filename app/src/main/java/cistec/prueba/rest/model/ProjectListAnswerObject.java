package cistec.prueba.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectListAnswerObject {
    @SerializedName("error_code")
    private Integer error_code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private  List<Project> data;

    public Integer getError_code() {
        return error_code;
    }

    public String getMessage() {
        return message;
    }

    public List<Project> getData() {
        return data;
    }
}
