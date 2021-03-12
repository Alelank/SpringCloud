package com.yiran.cloud.entity;

import java.io.Serializable;

/**
 * Created by Ale on 2021/3/12
 */
public class JavaBook implements Serializable {
    private long id;
    private String name;
    private String author;
    private String content;
    private String desc;
    private String publishingHouse;
    private String publishingDate;

    public JavaBook() {

    }

    public JavaBook(JavaBookBuilder javaBookBuilder) {
        this.id = javaBookBuilder.id;
        this.name = javaBookBuilder.name;
        this.author = javaBookBuilder.author;
        this.content = javaBookBuilder.content;
        this.desc = javaBookBuilder.desc;
        this.publishingHouse = javaBookBuilder.publishingHouse;
        this.publishingDate = javaBookBuilder.publishingDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDesc() {
        return desc;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    @Override
    public String toString() {
        return "JavaBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", desc='" + desc + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", publishingDate='" + publishingDate + '\'' +
                '}';
    }

    public static class JavaBookBuilder {
        private long id;
        private String name;
        private String author;
        private String content;
        private String desc;
        private String publishingHouse;
        private String publishingDate;

        public JavaBookBuilder builderId(long id) {
            this.id = id;
            return this;
        }

        public JavaBookBuilder builderName(String name) {
            this.name = name;
            return this;
        }

        public JavaBookBuilder builderAuthor(String author) {
            this.author = author;
            return this;
        }

        public JavaBookBuilder builderContent(String content) {
            this.content = content;
            return this;
        }

        public JavaBookBuilder builderDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public JavaBookBuilder builderPublishingHouse(String publishingHouse) {
            this.publishingHouse = publishingHouse;
            return this;
        }

        public JavaBookBuilder builderPublishingDate(String publishingDate) {
            this.publishingDate = publishingDate;
            return this;
        }

        public JavaBook builder() {
            return new JavaBook(this);
        }

    }
}
