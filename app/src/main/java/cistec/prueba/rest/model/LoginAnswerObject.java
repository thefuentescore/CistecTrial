package cistec.prueba.rest.model;

import com.google.gson.annotations.SerializedName;

public class LoginAnswerObject {
    @SerializedName("error_code")
    private Integer error_code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Data data;

    public Integer getError_code() {
        return error_code;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public class Data {
        @SerializedName("access_token")
        private String access_token;

        public String getAccess_token() {
            return access_token;
        }
    }
}
