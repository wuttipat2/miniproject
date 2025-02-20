package com.coffeetracker.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)

public class ResponseConstants {
    public static final class Status {
        public static final Integer STATUS_SUCCESS = 1000;
        public static final Integer STATUS_INTERNAL_SERVICE_ERROR = 4000;
        public static final Integer STATUS_UNAUTHORIZED = 4001;
        public static final Integer STATUS_FORBIDDEN = 4003;
        public static final Integer STATUS_SYSTEM_SERVICE_ERROR = 5000;

        private Status() {
        }

    }
    public static final class ErrorCode {
        public static final Integer ERROR_CODE_UNAUTHORIZED = 100000;
        public static final Integer ERROR_CODE_UNABLE_TO_PROCEED = 109999;
    }
    public static final class ErrorMessage {
        public static final String ERROR_MESSAGE_UNAUTHORIZED = "Unauthorized";
        public static final String ERROR_MESSAGE_LOGIN_SALE_UNABLE_TO_PROCEED = "Unable to proceed";
    }
}
