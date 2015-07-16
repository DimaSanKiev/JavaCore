package _bionic_university._5_wikipedia;

import java.util.HashSet;
import java.util.Set;

public class WikiLinksCollector {
    private static int count = 0;
    private Set<WikiLink> list = null;

    public WikiLinksCollector() {
        list = new HashSet<WikiLink>();
    }

    public void addLink(String url, String name) {
        WikiLink link = new WikiLink(url, name);
        if (list.add(link)) {
            count = link.getId();
        } else
            WikiLink.setCount(count);
    }

    public Set<WikiLink> getList() {
        return list;
    }

    public WikiLink getById(int id) {
        for (WikiLink link : list) {
            if (link.getId() == id)
                return link;
        }
        return null;
    }

    public boolean setPriority(int id, int priority) {
        WikiLink link = getById(id);
        if (link == null) return false;
        link.setPriority(priority);
        return true;
    }

    public boolean setLinkProc(int id, WikiLink.Status status) {
        WikiLink link = getById(id);
        if (link == null) return false;
        link.setLinkProc(status);
        return true;
    }

    public boolean setStudyProc(int id, WikiLink.Status status) {
        WikiLink link = getById(id);
        if (link == null) return false;
        link.setStudyProc(status);
        return true;
    }

    public void update(WikiLink link) {
        int id = link.getId();
        WikiLink oldLink = getById(id);
        if (oldLink == null)
            list.add(link);
        else {
            oldLink.setId(link.getId());
            oldLink.setUrl(link.getUrl());
            oldLink.setName(link.getName());
            oldLink.setDescription(link.getDescription());
            oldLink.setLinkProc(link.getLinkProc());
            oldLink.setStudyProc(link.getStudyProc());
            oldLink.setPriority(link.getPriority());
        }
        if (id > count)
            count = id;
    }
}
