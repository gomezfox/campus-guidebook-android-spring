package edu.cascadia.mobas.campusguidebook.data;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import java.util.TimeZone;
import java.time.ZoneId;
import java.time.ZonedDateTime;


import edu.cascadia.mobas.campusguidebook.AppExecutors;
import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.model.User;


@RequiresApi(api = Build.VERSION_CODES.O)
public class SampleData {

    private static final ZoneId zoneId = TimeZone.getTimeZone("America/Los_Angeles").toZoneId();
    public static final Event[] events = {
            new Event("Math Club - Weekly Meeting", "Meets every other Tuesday at 3:30", "CC1-210", ZonedDateTime.of(2022,3,1,15,30,0,0, zoneId)),
            new Event("Engineering Club - Symposium", "The biggest Engineering event of the year", "CC2-120", ZonedDateTime.of(2022, 10, 7, 11, 0, 0, 0, zoneId)),
    };

    public static final Club[] clubs = {
            new Club("Japanese Culture Club", "The purpose of this club is to provide a comfortable place for the students at Cascadia college to learn and experience Japanese culture together. In our club, we will share traditional Japanese culture such as Japanese calligraphy, origami, karate, etc. together.","","jcc.cascadia@gmail.com", "https://www.cascadia.edu/images_calendar/collegerelations/JapaneseCultureClub.png"),
            new Club("CC Engineers Club", "The engineering club is open to any student who is interested in science, technology, engineering, and math (STEM). Through hands on activities, members of all skill levels will have the opportunity to design, build, and share engineered projects with other creative problem solvers. Get ready to strengthen your skills, create a collection of projects related to your career, and connect with your peers! Some of the club projects we've undertaken include designing 3d printing models, making a video game with python, and electronic prototyping with Arduino.", "Howard Wolowitz <hwolowitz@caltech.edu>", "cascadiaengineers@gmail.com", "https://www.cascadia.edu/images_calendar/collegerelations/CCEngineersClub.png"),
            new Club("Math Club", "A group for students who love math or who would like to learn more", "Mathy McMathface <mathy@mathface.com>", "Almathia Newton <anewton@gmail.com>"),
    };

    public static final Sustainability[] sustainabilities = {
            new Sustainability("Wetlands", "Wetlands along North Creek have been restored, benefiting local wildlife and salmon populations"),
    };

    public static final User[] users = new User[]{
            new User("John Q. Public", "Math Club, Engineering Club", "OpenSecret"),
    };

    public static void addAll(AppDatabase appDatabase, AppExecutors appExecutors) {
        // clear existing data from all tables and add all the sample data above
        appExecutors.diskIO().execute(() -> {
            appDatabase.clearAllTables();
            // use a transaction to insert all the sample data in one pass
            appDatabase.runInTransaction(() -> {
                for (Event event : SampleData.events) {
                    appDatabase.EventDao().insert(event);
                }
                for (Club club : SampleData.clubs) {
                    appDatabase.ClubDao().insert(club);
                }
                for (Sustainability sustainability : SampleData.sustainabilities) {
                    appDatabase.SustainabilityDao().insert(sustainability);
                }
                for (User user : SampleData.users)
                    appDatabase.UserDao().insert(user);
                Log.d("AppDatabase", "Adding sample data FINISHED");
            });
        });
    }
 }


