package com.example.tddexample;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import org.apache.tools.ant.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowLog;

@RunWith(RobolectricTestRunner.class)
public class RobolectricTest {

    MainActivity activity;

    // Android.util.Log를 System.out 출력
    @Before
    public void setUp() throws Exception{
        ShadowLog.stream = System.out;
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void logTest(){
        System.out.println("hello RobolectricTest");
        Log.d("TAG","Log.d change sysout");
    }

    @Test
    public void changeAcitivityTest(){
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        activity.findViewById(R.id.change_btn).performClick();
        Intent intent = new Intent(activity,SecondActivity.class);
        Intent actual = Shadows.shadowOf(activity).getNextStartedActivity();
        Assert.assertEquals(intent.getComponent(),actual.getComponent());
    }

    @Test
    public void lifecycleActivityTest(){
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        controller.create().start().resume().stop().destroy();
        Assert.assertEquals(true, controller.get().isDestroyed());
    }

    @Test
    public void textViewTest(){
        TextView textView = activity.findViewById(R.id.textView);
        Assert.assertEquals("Hello World!",textView.getText());
    }

}
