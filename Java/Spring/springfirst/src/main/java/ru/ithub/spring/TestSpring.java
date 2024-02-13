package ru.ithub.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ShowPage showPage = context.getBean("showPageBean", ShowPage.class);
        showPage.viewPage();

        System.out.println(showPage.getName());
        System.out.println(showPage.getWith());
        System.out.println(showPage.getHeight());
        context.close();
    }
}
