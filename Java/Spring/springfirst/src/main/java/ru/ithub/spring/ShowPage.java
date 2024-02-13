package ru.ithub.spring;

public class ShowPage {
    private Page page;
    private String name;
    private String with;
    private String height;

    public ShowPage(Page page, String name, String with, String height) {
        this.page = page;
        this.name = name;
        this.with = with;
        this.height = height;
    }

    public ShowPage() {}

    public String getName() {
        return name;
    }

    public String getWith() {
        return with;
    }

    public String getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWith(String with) {
        this.with = with;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setPage(Page page){
        this.page = page;
    }

    public void viewPage() {
        System.out.println(page.getPageFormat());
    }
}
