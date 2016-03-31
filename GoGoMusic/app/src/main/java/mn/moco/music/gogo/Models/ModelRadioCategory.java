package mn.moco.music.gogo.Models;

public class ModelRadioCategory {
    private int categoryId;
    private int backgroundImageResource;
    private int logoImageResource;
    private String title = "";

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBackgroundImageResource() {
        return backgroundImageResource;
    }

    public void setBackgroundImageResource(int backgroundImageResource) {
        this.backgroundImageResource = backgroundImageResource;
    }

    public int getLogoImageResource() {
        return logoImageResource;
    }

    public void setLogoImageResource(int logoImageResource) {
        this.logoImageResource = logoImageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
