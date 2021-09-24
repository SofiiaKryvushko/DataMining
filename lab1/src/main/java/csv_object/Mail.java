package csv_object;

public class Mail {

    private String type;
    private String content;

    public Mail(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
