package edu.cascadia.mobas.campusguidebook.data.typeconverter;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class OffsetDateTimeConverter {

    @TypeConverter
    public static OffsetDateTime toOffsetDateTime(@Nullable String dateTimeString) {

        // null input provides null output
        if (dateTimeString == null) return null;

        // Convert a valid ISO8601 String to an OffsetDateTime
        try {
            return OffsetDateTime.parse(dateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (Exception e){
            //TODO: log failed conversion
            return null;
        }
    }

    @TypeConverter
    public static String fromOffsetDateTime(@Nullable OffsetDateTime offsetDateTime) {

        // null input returns null output
        if (offsetDateTime == null) {
            return null;
        } else {
            return offsetDateTime.toString();
        }
    }

}
