package _bionic_university._4_wikipedia;

public class Link {
    private String name;
    private String url;
    private String description;

    public enum Importance {
        LOW, NORMAL, HIGH
    }

    public enum Progress {
        INCOMPLETE, IN_PROCESS, COMPLETE
    }

    public void linkImportance() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
