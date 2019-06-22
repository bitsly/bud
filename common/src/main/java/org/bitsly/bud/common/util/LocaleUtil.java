package org.bitsly.bud.common.util;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class LocaleUtil {

    public static Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }
}
