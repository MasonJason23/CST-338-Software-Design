public class WitterDate {

    private String month;
    private int day;
    private int year; // a four digit number
    private int hour;
    private int minute;
    private boolean am;


    // no argument constructor
    public WitterDate() {
        month = "January";
        day = 1;
        year = 2017;
        hour = 12;
        minute = 0;
        am = true;
    }

    public WitterDate(String aMonth, int aDay, int aYear, int aHour, int aMinute, boolean aAm) {
        setDate(aMonth, aDay, aYear, aHour, aMinute, aAm); // invoking setDate() method
    }

    public WitterDate(int aDay, int aHour, boolean aAm) {
        setDate(aDay, aHour, aAm);
    }

    // copy constructor
    public WitterDate(WitterDate wDate) {

        // not a real date
        if (wDate == null) {
            System.out.println("Fatal error.");
            System.exit(-1);
        }

        month = wDate.month;
        day = wDate.day;
        year = wDate.year;
        hour = wDate.hour;
        minute = wDate.minute;
        am = wDate.am;
    }

    public void setDate(String aMonth, int aDay, int aYear, int aHour, int aMinute, boolean aAm) {
        month = aMonth;
        day = aDay;
        year = aYear;
        hour = aHour;
        minute = aMinute;
        am = aAm;
    }

    public void setDate(int aDay, int aHour, boolean aAm) {
        setDate("September", aDay, 2017, aHour, 0, aAm);
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public String toString() {
        String abbrevMonth = month.substring(0,3);

        String amString = "";

        if (am) {
            amString = "AM";
        } else {
            amString = "PM";
        }

        String result = String.format("%d:%02d %s - %s %d, %d", hour, minute, amString, abbrevMonth, day, year);

        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof WitterDate) {
            WitterDate other = (WitterDate) o;
            return month.equals(other.month) && day == other.day && year == other.year;
        } else {
            return false;
        }
    }
}