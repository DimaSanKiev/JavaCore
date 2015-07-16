package _bionic_university._5_wikipedia;

public class WikiLink {
    public enum Status {NO, IN_PROGRESS, FINISHED}

    private static int count = 0;

    private int id;
    private String url;
    private String name;
    private String description;
    private Status linkProc;
    private Status studyProc;
    private int priority;

    public WikiLink() {
        id = ++count;
    }

    public WikiLink(String url, String name) {
        id = ++count;
        this.url = url;
        this.name = name;
        linkProc = Status.NO;
        studyProc = Status.NO;
        priority = 0;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WikiLink.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getLinkProc() {
        return linkProc;
    }

    public void setLinkProc(Status linkProc) {
        this.linkProc = linkProc;
    }

    public Status getStudyProc() {
        return studyProc;
    }

    public void setStudyProc(Status studyProc) {
        this.studyProc = studyProc;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object link) {
        return this.url.equals(((WikiLink) link).getUrl());
    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }
}