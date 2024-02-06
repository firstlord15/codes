package ru.ithub.spring;

public class ShowPage {
    private Page page;

    public ShowPage(Page page) {
        this.page = page;
    }

    public void viewPage() {
        System.out.println(page.getPageFormat());
    }
}
