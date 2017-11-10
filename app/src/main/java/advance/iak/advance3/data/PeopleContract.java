package advance.iak.advance3.data;

import android.provider.BaseColumns;

public class PeopleContract {

    public static final class PeopleEntry implements BaseColumns {
        public static final String TABLE_NAME = "people";
        public static final String PEOPLE_NAME = "recipe_name";
        public static final String PEOPLE_ADDRESS = "recipe_id";
    }
}
