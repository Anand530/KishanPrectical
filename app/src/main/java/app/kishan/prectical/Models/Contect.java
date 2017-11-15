package app.kishan.prectical.Models;

/**
 * Created by Administrator on 8/19/2017.
 */

public class Contect {
    String Caption;

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    String Number;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    String ContryCode;

    public String getContryCode() {
        return ContryCode;
    }

    public void setContryCode(String contryCode) {
        ContryCode = contryCode;
    }

    String ImageLink;

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }

    private boolean isShared;

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }
}
