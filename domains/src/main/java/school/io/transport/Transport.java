package school.io.transport;

public enum Transport {
    CAR(0),
    BUS(1),
    ANOTHER(2),
    OTHER(3),
    MOTORCYCLE(4);

    private int value;

    Transport(int i) {
        value = i;
    }

    public static Transport fromValue(int i) {
        for (Transport transport : Transport.values()) {
            if (transport.value == i) {
                return transport;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Transport: " + i);
    }
}