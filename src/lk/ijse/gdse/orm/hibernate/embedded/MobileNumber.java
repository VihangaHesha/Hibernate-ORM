package lk.ijse.gdse.orm.hibernate.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class MobileNumber {
    private String type;
    private String mobileNumber;

    public MobileNumber(String type, String mobileNumber) {
        this.type = type;
        this.mobileNumber = mobileNumber;
    }

    public MobileNumber() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "MobileNumber{" +
                "type='" + type + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
