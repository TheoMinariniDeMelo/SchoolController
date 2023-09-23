package io.pro.educare;

public enum TimeZone {
    BR("BRA", "BR", "Brasil", "America/Sao_Paulo"),
    US("USA", "US", "Estados Unidos", "America/New_York"),
    CA("CAN", "CA", "Canadá", "America/Toronto");

    private final String countryCode;
    private final String country;
    private final String countryName;
    private final String timezone;

    TimeZone(String countryCode, String country, String countryName, String timezone) {
        this.countryCode = countryCode;
        this.country = country;
        this.countryName = countryName;
        this.timezone = timezone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTimezoneDisplayName() {
        return java.util.TimeZone.getTimeZone(timezone).getDisplayName();
    }
}
