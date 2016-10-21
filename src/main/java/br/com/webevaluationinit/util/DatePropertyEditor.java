package br.com.webevaluationinit.util;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {
    //private static final Logger LOG = Logger.getLogger(DatePropertyEditor.class);

    private final DateFormat dateFormat;

    public DatePropertyEditor(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public void setAsText(String text) {
        try {
            Date date = (Date) dateFormat.parseObject(text);
            setValue(date);
        } catch (ParseException e) {
            //LOG.fatal("error setting date for String: " + text, e);
        }
    }

    /**
     * Format the Date as String, using the specified DateFormat.
     */
    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? this.dateFormat.format(value) : "");
    }
}
