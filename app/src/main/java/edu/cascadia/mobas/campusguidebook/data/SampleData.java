package edu.cascadia.mobas.campusguidebook.data;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.model.User;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SampleData {
    //TODO: Investigate ZoneOffsetTransitionRule;
    private static final ZoneOffset zone = ZoneOffset.of("America/Los Angeles");
    public static final Event[] events = {
            new Event("Math Club - Weekly Meeting", "Meets every other Tuesday at 3:30", "CC1-210", OffsetDateTime.of(2022, 10, 4, 15, 30, 0, 0, zone)),
            new Event("Engineering Club - Symposium", "The biggest Engineering event of the year", "CC2-120", OffsetDateTime.of(2022, 10, 7, 11, 0, 0, 0, zone)),
    };

    public static final Club[] clubs = {
            new Club("Math Club", "A group for students who love math or who would like to learn more", "Mathy McMathface <mathy@mathface.com", "Almathia Newton <anewton@gmail.com>"),
            new Club("Engineering Club", "A group for students who love to design, fabricate, and build", "Howard Wolowitz <hwolowitz@caltech.edu", "Motor Close <motorclose@badjoke.com>"),
    };

    public static final Sustainability[] sustainabilities = {
            new Sustainability("Wetlands"),
    };

    public static final User[] users = new User[]{
            new User("John Q. Public", "Math Club, Engineering Club", "OpenSecret"),
    };
}
