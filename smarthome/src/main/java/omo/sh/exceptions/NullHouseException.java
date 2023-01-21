package omo.sh.exceptions;

public class NullHouseException extends RuntimeException{

    public NullHouseException(String message) {
        super(message);
    }

    public static NullHouseException create() {
        return new NullHouseException("House has disappeared!\n So strange D:\n");
    }
}
