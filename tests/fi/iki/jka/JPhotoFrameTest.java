package fi.iki.jka;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import java.awt.event.ActionEvent;
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
        JPhotoFrame frame = new JPhotoFrame("Penguins are cute",new JPhotoCollection()){
            @Override
            protected void init(String frameName, JPhotoCollection photos) throws Exception{
                System.out.println("Overriden init");
                this.photos = new JPhotoCollection();
                this.photos.setTitle("Title");
                prefs = Preferences.userRoot().node("/fi/iki/jka/jphotoframe");
                int splitWidth = prefs.getInt(SPLIT, 190);
                this.list = new JPhotoList(photos, splitWidth);
            }

            @Override
            void visualiseSlideShow(int interval) {

            }
        };
        frame.actionPerformed(event);
        assertThat(frame.wasCalled, equalTo(true));

    }



}