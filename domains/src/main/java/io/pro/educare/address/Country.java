package io.pro.educare.address;

public enum Country {
    BRA("BRA", "BR", "Brasil"),
    USA("USA", "US", "Estados Unidos"),
    CAN("CAN", "CA", "Canadá");

    private final String alpha3Code;
    private final String alpha2Code;
    private final String name;

    Country(String alpha3Code, String alpha2Code, String name) {
        this.alpha3Code = alpha3Code;
        this.alpha2Code = alpha2Code;
        this.name = name;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
