package com.csg.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Items implements Serializable {


    @SerializedName("items")
    private List<Item> itemsList;

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public String toString() {
        return String.format("[%s]", itemsList);
    }

    public static class Item implements Serializable {

        @SerializedName("id")
        private String id;
        @SerializedName("login")
        private String login;
        @SerializedName("avatar_url")
        private String avatarurl;
        @SerializedName("gravatar_id")
        private String gravatarid;
        @SerializedName("url")
        private String url;
        @SerializedName("html_url")
        private String htmlurl;
        @SerializedName("subscriptions_url")
        private String subscriptionsurl;
        @SerializedName("organizations_url")
        private String organizationsurl;
        @SerializedName("repos_url")
        private String reposurl;
        @SerializedName("type")
        private String type;
        @SerializedName("score")
        private String score;
        @SerializedName("site_admin")
        private String siteadmin;

        public String getSiteadmin() {
            return siteadmin;
        }

        public void setSiteadmin(String siteadmin) {
            this.siteadmin = siteadmin;
        }

        public String getFollowersurl() {
            return followersurl;
        }

        public void setFollowersurl(String followersurl) {
            this.followersurl = followersurl;
        }

        @SerializedName("followers_url")
        private String followersurl;



        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getAvatarurl() {
            return avatarurl;
        }

        public void setAvatarurl(String avatarurl) {
            this.avatarurl = avatarurl;
        }

        public String getGravatarid() {
            return gravatarid;
        }

        public void setGravatarid(String gravatarid) {
            this.gravatarid = gravatarid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHtmlurl() {
            return htmlurl;
        }

        public void setHtmlurl(String htmlurl) {
            this.htmlurl = htmlurl;
        }

        public String getSubscriptionsurl() {
            return subscriptionsurl;
        }

        public void setSubscriptionsurl(String subscriptionsurl) {
            this.subscriptionsurl = subscriptionsurl;
        }

        public String getOrganizationsurl() {
            return organizationsurl;
        }

        public void setOrganizationsurl(String organizationsurl) {
            this.organizationsurl = organizationsurl;
        }

        public String getReposurl() {
            return reposurl;
        }

        public void setReposurl(String reposurl) {
            this.reposurl = reposurl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

    }
}
