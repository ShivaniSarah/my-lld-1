package comPackage.lld6Improved.lld6;


public class Size {
    int height;
    int length;
    int width;

    public Size(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    int getVolume(){
        return height*width*length;
    }
}
