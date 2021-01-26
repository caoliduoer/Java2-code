package org.example.moddel;

import java.util.Objects;

public class DocInfo {
    private Integer id;//类似数据库主键，识别不同的文档
    private  String title;//标题：使用每个文档的名字（HTML文件名)
    private String url;//oracle官网Api文档下HTML的URL

    private String content;//文档的正文，网页内容：<html(<标签>内容<标签>

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DocInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocInfo docInfo = (DocInfo) o;
        return id.equals(docInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
