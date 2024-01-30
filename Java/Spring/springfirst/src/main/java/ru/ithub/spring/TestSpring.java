package ru.ithub.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Page page = context.getBean("pageBean", Page.class);
        ShowPage showPage = new ShowPage(page);
        showPage.showPage();
        context.close();
    }
}
