package advance.iak.advance3;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MyFirstTest {

    @Rule
    public ActivityTestRule<TestActivity> testRule = new ActivityTestRule<>(TestActivity.class);

    @Test
    public void testSum(){
        onView(withId(R.id.angka1))
                .perform(replaceText("2"));


        onView(withId(R.id.angka2))
                .perform(replaceText("3"));

        onView(withId(R.id.btn_sum))
                .perform(click());

        onView(withId(R.id.tv_result))
                .check(matches(withText("5")));
    }

}
