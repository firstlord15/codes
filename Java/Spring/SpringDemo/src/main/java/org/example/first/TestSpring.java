package org.example.first;

import org.example.second.MusicPlayer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);

        // first exp (beans)
        System.out.println(testBean.getName());
        System.out.println(testBean.getSurname());
        System.out.println();

        // second exp (IoC) and third (DI)
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = musicPlayer == musicPlayer1;
        System.out.println(comparison);

        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        context.close();
    }
}
