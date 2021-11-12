public class Weet {
    private String emoticon;
    private String name;
    private String username;
    private boolean verified;
    private String weetText;
    private WitterDate date;
    private static int numWeets = 0;
    private static int numFakeWeets = 0;

    public Weet(String emoticon, String name, String username, boolean verified) {
        this.emoticon = emoticon;
        this.name = name;
        this.username = username;
        this.verified = verified;
    }

    public void setWeet(String weetText) {
        this.weetText = weetText;
        if (weetText.length() > 140) {
            String tempWeet = weetText.substring(0, 137);
            tempWeet = tempWeet + "...";
            this.weetText = tempWeet;
        }
        numWeets++;
    }

    public void setDate(WitterDate date) {
        this.date = date;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public String getFullName() {
        return name;
    }

    public void setFullName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getWeetText() {
        return weetText;
    }

    @Override
    public String toString() {
        String verified;
        if (isVerified()) {
            verified = " ✓";
        } else { verified = ""; }

        String weet = emoticon + " " + name + verified + " @" + username + '\n' +
                weetText + '\n' + date + '\n';
        return weet;
    }

    public WitterDate getDate() {
        return date;
    }

    public boolean equals(Weet otherWeet) {
        if (this.weetText.equals(otherWeet.weetText)) {
            numFakeWeets++;
            numWeets--;
            return true;
        } else {
            return false;
        }
    }

    public static int getNumWeets() {
        return numWeets;
    }

    public static int getNumFakeWeets() {
        return numFakeWeets;
    }

    public void plagiarismCheck(Weet otherWeet) {
        boolean fakeWeet = equals(otherWeet);
        boolean sameDate = false;

        if (this.date.getMonth() == otherWeet.date.getMonth() &&
            this.date.getDay() == otherWeet.date.getDay() &&
            this.date.getYear() == otherWeet.date.getYear()) {
            sameDate = true;
        }

        if (fakeWeet == true && sameDate == true) {
            this.weetText = "[Plagiarism detected. Text removed.]";
        }
    }
}
