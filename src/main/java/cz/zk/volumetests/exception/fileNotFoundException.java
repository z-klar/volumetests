package cz.zk.volumetests.exception;

import lombok.Getter;

@Getter
public class fileNotFoundException extends mainException {

    public fileNotFoundException(String message) {
        super(message);
    }
}


