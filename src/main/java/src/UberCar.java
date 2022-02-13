package src;

import java.io.Serializable;

/**
 *
 * @author Trisha
 */
public class UberCar implements Serializable {

    private static final long serialVersionUID = 1L;

    String engineNo;
    String licenseplate;
    String manufacturer;
    String manufactureYear;
    int numberOfSeat;
    int modelNumber;
    String maintenanceExpDate;

    Boolean availability;
    int uberSerialNumber;
    String catlogUpdateDatetime;

    public UberCar(String engineNo, String licenseplate, String manufacturer, String manufactureYear, int numberOfSeat, int modelNumber, String maintenanceExpDate, Boolean availability, int uberSerialNumber, String catlogUpdateDatetime) {
        this.engineNo = engineNo;
        this.licenseplate = licenseplate;
        this.manufacturer = manufacturer;
        this.manufactureYear = manufactureYear;
        this.numberOfSeat = numberOfSeat;
        this.modelNumber = modelNumber;
        this.maintenanceExpDate = maintenanceExpDate;
        this.availability = availability;
        this.uberSerialNumber = uberSerialNumber;
        this.catlogUpdateDatetime = catlogUpdateDatetime;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getMaintenanceExpDate() {
        return maintenanceExpDate;
    }

    public void setMaintenanceExpDate(String maintenanceExpDate) {
        this.maintenanceExpDate = maintenanceExpDate;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public int getUberSerialNumber() {
        return uberSerialNumber;
    }

    public void setUberSerialNumber(int uberSerialNumber) {
        this.uberSerialNumber = uberSerialNumber;
    }

    public String getCatlogUpdateDatetime() {
        return catlogUpdateDatetime;
    }

    public void setCatlogUpdateDatetime(String catlogUpdateDatetime) {
        this.catlogUpdateDatetime = catlogUpdateDatetime;
    }

    public boolean equals(UberCar uberCar) {
        return (this.engineNo.equals(uberCar.engineNo)
                && this.licenseplate.equals(uberCar.licenseplate)
                && this.manufacturer.equals(uberCar.manufacturer)
                && this.manufactureYear.equals(uberCar.manufactureYear)
                && this.numberOfSeat == (uberCar.numberOfSeat)
                && this.modelNumber == (uberCar.modelNumber)
                && this.maintenanceExpDate.equals(uberCar.maintenanceExpDate)
                && this.availability.equals(uberCar.availability)
                && this.uberSerialNumber == (uberCar.uberSerialNumber)
                && this.catlogUpdateDatetime.equals(uberCar.catlogUpdateDatetime));
    }
}
