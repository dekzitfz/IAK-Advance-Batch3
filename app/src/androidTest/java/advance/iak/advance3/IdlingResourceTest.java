package advance.iak.advance3;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class IdlingResourceTest {

    private IdlingResource idlingResource;

    @Rule
    public ActivityTestRule<RetrofitActivity> testRule = new ActivityTestRule<>(RetrofitActivity.class);

    @Before
    public void registerIdlingResource(){
        idlingResource = testRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(idlingResource);
    }

    @After
    public void unregisterIdlingResource(){
        if(idlingResource != null) IdlingRegistry.getInstance().unregister(idlingResource);
    }

    @Test
    public void githubTest(){
        onView(withId(R.id.btn_retrofit))
                .perform(click());

        onView(withId(R.id.github_name))
                .check(matches(withText("Adi Andrea")));
    }

}
