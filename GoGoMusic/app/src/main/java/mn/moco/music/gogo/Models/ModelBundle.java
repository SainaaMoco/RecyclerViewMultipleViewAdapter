package mn.moco.music.gogo.Models;

public class ModelBundle {
    private ModelRadioCategory item1;
    private ModelRadioCategory item2;
    private ModelRadioCategory item3;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public ModelRadioCategory getItem1() {
        return item1;
    }

    public void setItem1(ModelRadioCategory item1) {
        size++;
        this.item1 = item1;
    }

    public ModelRadioCategory getItem2() {
        return item2;
    }

    public void setItem2(ModelRadioCategory item2) {
        size++;
        this.item2 = item2;
    }

    public ModelRadioCategory getItem3() {
        return item3;
    }

    public void setItem3(ModelRadioCategory item3) {
        size++;
        this.item3 = item3;
    }
}
