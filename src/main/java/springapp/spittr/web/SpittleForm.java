package springapp.spittr.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.function.DoubleBinaryOperator;

public class SpittleForm {

    @NotNull
    @Size(min=1, max = 150)
    private String message;

    @Min(-180)
    @Max(180)
    private Double latitude;

    @Min(-90)
    @Max(90)
    private Double longitude;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
