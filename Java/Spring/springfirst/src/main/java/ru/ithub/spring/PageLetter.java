package ru.ithub.spring;

public class PageLetter implements Page{
    public PageLetter() {
    }

    @Override
    public String getPageFormat() {
        return "Формат страницы Letter";
    }
}
