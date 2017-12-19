package com.spring.henallux.firstSpringProject.Enumeration;

public enum EnumPages {

    HOME("integrated:home", "redirect:/home"),
    CART("integrated:cart", "redirect:/cart"),
    ARTICLE_DETAIL("integrated:articleDetail", ""),
    CARRELAGE_INTERIEUR("integrated:carrelageInterieur", ""),
    CHECKOUT("integrated:chekout", ""),
    CONNECTION("integration:connection", "redirect:/connection"),
    CONNECTION_INSCRIPTION("integrated:connectionInscription", "redirect:/connectionInscription"),
    ORDER_HISTORY("integrated:orderhistory", "");


    private String page;
    private String redirection;

    EnumPages(String page, String redirection) {
        this.page = page;
        this.redirection = redirection;
    }

    public String getPage() {
        return page;
    }

    public void setTitle(String page) {
        this.page = page;
    }

    public String getRedirection() {
        return redirection;
    }

    public void setRedirection(String redirection) {
        this.redirection = redirection;
    }
}
