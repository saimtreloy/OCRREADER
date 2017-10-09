package saim.com.ocrreader;

/**
 * Created by NREL on 10/9/17.
 */

public class ModelPhone {
    String phoneName, firstRadiation, secondRediation;

    public ModelPhone(String phoneName, String firstRadiation, String secondRediation) {
        this.phoneName = phoneName;
        this.firstRadiation = firstRadiation;
        this.secondRediation = secondRediation;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getFirstRadiation() {
        return firstRadiation;
    }

    public String getSecondRediation() {
        return secondRediation;
    }
}
