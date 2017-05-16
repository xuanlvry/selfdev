package design.structure.adapter;

/**
 * @author Chengfei.Sun on 2016/10/17.
 */
public class Mp4Player implements AdvancedMediaPlayer{
    public void playVlc(String fileName) {
        //do nothing
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
