package design.structure.adapter;

/**
 * @author Chengfei.Sun on 2016/10/17.
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    public void playMp4(String fileName) {
        //do nothing
    }
}
