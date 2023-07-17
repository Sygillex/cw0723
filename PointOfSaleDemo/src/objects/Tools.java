package objects;

public enum Tools {
    CHNS("Chainsaw", "Stihl", 1.99, true, true, false),
    LADW("Ladder", "Werner", 1.49, true, false, true),
    JAKD("Jackhammer", "DeWalt", 2.99, true, false, false),
    JAKR("Jackhammer", "Ridgid", 2.99, true, false, false);

    private String type;
    private String brand;
    private double dailyCharge;
    private boolean weekDayCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;

    Tools(
        String toolType,
        String brand,
        double dailyCharge,
        boolean weekDayCharge,
        boolean weekendCharge,
        boolean holidayCharge
    ) {
        this.type = toolType;
        this.brand = brand;
        this.dailyCharge = dailyCharge;
        this.weekDayCharge = weekDayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public boolean isWeekDayCharge() {
        return weekDayCharge;
    }

    public boolean isWeekendCharge() {
        return weekendCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }

}
