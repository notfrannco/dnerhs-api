package py.gov.mspbs.controller;

public class FileResponse {
    private String id;

    private String type;
    private long size;

    public FileResponse(String id, String type, long size) {
        this.id = id;
        this.type = type;
        this.size = size;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }
}
