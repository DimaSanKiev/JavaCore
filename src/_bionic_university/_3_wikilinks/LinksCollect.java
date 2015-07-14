package _bionic_university._3_wikilinks;

import java.util.HashSet;

public class LinksCollect {
    private static int newId = 0;
    private HashSet<Link> list = null;

    public LinksCollect(){
        list = new HashSet<Link>();
    }

    public void addLink(String link, String name){
        Link l = new Link(link, name);
        if (list.add(l))
            newId = l.getId();
        else
            Link.setNewId(newId);
    }

    public HashSet<Link> getList(){
        return list;
    }

    public Link getById(int id){
        for (Link link: list){
            if (link.getId() == id)
                return link;
        }
        return null;
    }

    public boolean setPrio(int id, int prio){
        Link link = getById(id);
        if (link == null) return false;
        link.setPriority(prio);
        return true;
    }

    public boolean setLinksProc(int id, Link.Status status){
        Link link = getById(id);
        if (link == null) return false;
        link.setLinksProc(status);
        return true;
    }

    public boolean setStudyProc(int id, Link.Status status){
        Link link = getById(id);
        if (link == null) return false;
        link.setStudyProc(status);
        return true;
    }

    public void update(Link link){
        int id  = link.getId();
        Link lOld = getById(id);
        if (lOld == null){
            list.add(link);
        } else{
            lOld.setId(link.getId());
            lOld.setLink(link.getLink());
            lOld.setLinksProc(link.getLinksProc());
            lOld.setName(link.getName());
            lOld.setPriority(link.getPriority());
            lOld.setStudyProc(link.getStudyProc());
        }
        if (id > newId)
            newId = id;
    }
}
