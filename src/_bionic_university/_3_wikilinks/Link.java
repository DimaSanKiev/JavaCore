package _bionic_university._3_wikilinks;

public class Link{
    public enum Status{NO, INPROGRESS, FINISHED};

    private static int newId = 0;

    private int id;
    private String link;
    private String name;
    private Status linksProc;
    private Status studyProc;
    private int priority;

    public Link(){
        id = ++newId;
    }

    public Link(String link, String name){
        id = ++newId;
        this.link = link;
        this.name = name;
        linksProc = Status.NO;
        studyProc = Status.NO;
        priority = 0;
    }

    public static int getNewId() {
        return newId;
    }

    public static void setNewId(int newId) {
        Link.newId = newId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getLinksProc() {
        return linksProc;
    }

    public void setLinksProc(Status linksProc) {
        this.linksProc = linksProc;
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
    public boolean equals(Object l){
        return this.link.equals(((Link)l).getLink());
    }

    @Override
    public int hashCode(){
        return link.hashCode();
    }
}
