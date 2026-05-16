package org.informatics.exceptions;

import java.time.LocalDate;

public class ExpiredGoodsException extends RuntimeException {

    public ExpiredGoodsException(String message) {
        super(message);
    }
}
