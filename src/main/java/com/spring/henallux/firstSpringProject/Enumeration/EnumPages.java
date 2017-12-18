package com.spring.henallux.firstSpringProject.Enumeration;

public enum EnumPages {

    HOME("integrated:home", "redirect:/home"),
    CART("integrated:cart", "redirect:/cart");

    private String title;
    private String redirection;

    EnumPages(String title, String redirection) {
        this.title = title;
        this.redirection = redirection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRedirection() {
        return redirection;
    }

    public void setRedirection(String redirection) {
        this.redirection = redirection;
    }
}
