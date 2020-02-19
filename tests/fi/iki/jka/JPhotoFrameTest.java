package fi.iki.jka;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.prefs.Preferences;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JPhotoFrameTest {
    @Test
    public void placeholder() throws Exception {
        assertThat(2, equalTo(2));
    }

    @Test
    public void testSlideShowCalled() throws Exception {
        ActionEvent event = new ActionEvent(this, 0, JPhotoMenu.A_SLIDESHOW);
        final AtomicInteger interval = new AtomicInteger(0);

        JPhotoFrame frame = new JPhotoFrame() {
            @Override
            public void setTitle() {

            }
            @Override
            void visualiseSlideShow(int i) {
                interval.set(i);
            }
        };
        frame.actionPerformed(event);
        assertThat(frame.wasCalled, equalTo(true));
        assertThat(interval.get(), equalTo(5000));
    }

    @Test
    public void testSlideShowQuickCalled() throws Exception {
        ActionEvent event = new ActionEvent(this, 0, JPhotoMenu.A_SLIDESHOW_QUICK);
        final AtomicInteger interval = new AtomicInteger(0);

        JPhotoFrame frame = new JPhotoFrame() {
            @Override
            public void setTitle() {

            }
            @Override
            void visualiseSlideShow(int i) {
                interval.set(i);
            }
        };
        frame.actionPerformed(event);
        assertThat(frame.wasCalled, equalTo(true));
        assertThat(interval.get(), equalTo(2000));
    }


}