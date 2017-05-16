package design.structure.adapter;

/**
 * 更高级媒体播放器
 * @author Chengfei.Sun on 2016/10/17.
 */
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
