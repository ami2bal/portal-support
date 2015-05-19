package org.vd.portal.support.tools.converter;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by vav6wy on 22/07/14.
 */
public class DateConverter {

    /**
     * Convertit la date au format localdate
     *
     * @param date
     * @return
     */
    public static LocalDate getLocalDate(Date date) {
        if (null == date) {
            return null;
        }
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    /**
     * Convertit la date au format String, selon le pattern donné
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date, String pattern, boolean returnEmptyIfNull) {
        if (null == date) {
            if (returnEmptyIfNull) {
                return "";
            } else {
                return null;
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * Convertit la XmlDate au format String, selon le pattern donné
     *
     * @param xmlGregorianCalendar
     * @return
     */
    public static String formatDate(XMLGregorianCalendar xmlGregorianCalendar, String pattern, boolean returnEmptyIfNull) {
        if (null == xmlGregorianCalendar) {
            if (returnEmptyIfNull) {
                return "";
            } else {
                return null;
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = Date.from(xmlGregorianCalendar.toGregorianCalendar().toInstant());
        return simpleDateFormat.format(date);
    }
}
