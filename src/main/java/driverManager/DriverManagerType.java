package driverManager;

public enum DriverManagerType {
	
	CHROME("chromedriver", "Init ChromeDriver"),
    FIREFOX("firefoxdriver", "Init firefoxdriver"),
    EDGE("edgedriver", "Init edgedriver");

    private String driverName;
    private String desc;


    DriverManagerType(String driverName, String desc) {
        this.driverName = driverName;
        this.desc = desc;
    }

    /**
     * Gets the Driver
     *
     * @return get the Driver
     */
    public String getDriver() {
        return driverName;
    }

    public String getDriverdesc() {
        return desc;
    }

}
