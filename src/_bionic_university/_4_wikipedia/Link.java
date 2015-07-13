package _bionic_university._4_wikipedia;

public class Link  implements Comparable<Link>{
    private String name;
    private String url;
    private String description;
    private int importance;
    private int progress;

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

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Link name: " + this.name + "; importance: " + this.importance + "; progress: " + this.progress + "%" + "\n" +
                "URL: " + this.url + "\n" +
                "Description: " + this.description + "\n";
    }

    @Override
    public int compareTo(Link link) {
        return link.getName().compareTo(this.getName());
    }
}
