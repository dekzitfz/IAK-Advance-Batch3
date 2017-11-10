package advance.iak.advance3.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class PeopleContract {

    public static final String AUTHORITY = "advance.iak.advance3";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String PATH_PEOPLE = "people";

    public static final class PeopleEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PEOPLE).build();

        public static final String TABLE_NAME = "people";
        public static final String PEOPLE_NAME = "recipe_name";
        public static final String PEOPLE_ADDRESS = "recipe_id";
    }
}
