package design.structure.adapter;

/**
 * 所谓适配器模式就是将一个类的接口，转换成客户期望的另一个接口。它可以让原本两个不兼容的接口能够无缝完成对接。
 *
 * 使用场景：需要使用一个类的功能，但是该类的接口不符合使用场合要求的接口，可使用定制适配器；
 * 又或者是有一个接口定义的行为过多，则可以定义一个缺省适配器，让子类选择性的覆盖适配器的方法
 * @author Chengfei.Sun on 2016/10/17.
 */
public class MediaAdapter implements MediaPlayer{
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
