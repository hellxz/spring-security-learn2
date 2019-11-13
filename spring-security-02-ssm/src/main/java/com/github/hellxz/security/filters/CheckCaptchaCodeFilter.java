package com.github.hellxz.security.filters;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CheckCaptchaCodeFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return true;
    }


}
