package com.innovativeastrosolutions.astrosoftcore;

import com.innovativeastrosolutions.astrosoftcore.beans.AstroData;
import com.innovativeastrosolutions.astrosoftcore.beans.Place;
import com.innovativeastrosolutions.astrosoftcore.core.Horoscope;
import com.innovativeastrosolutions.astrosoftcore.util.Options;
import org.junit.Test;

/**
 * Created by relango on 10/3/17.
 */
public class SimpleTest {

    @Test
    public void testHoroscope(){
        StringBuilder sb = new StringBuilder();
        Place place = new Place("Erode", 11.366666666666667D, 77.73333333333333D, 5.5D);
        Options options = Options.get();
        Horoscope h = new Horoscope(new AstroData("Raja", 11, 12, 1980, 1, 44, 0, place, options));
        h.calculateAll();
        System.out.println(h);
    }
}
