package cz.zk.volumetests.exception;

import lombok.Getter;

@Getter
public class mainException extends Exception {

    public mainException() {
        super();
    }

    public mainException(String message) {
        super(message);
    }
}


