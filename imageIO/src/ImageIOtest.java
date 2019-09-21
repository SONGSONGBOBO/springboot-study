import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @ClassName ImageIO
 * @Description TODO
 * @Author songbo
 * @Date 19-8-4 下午1:51
 **/
public class ImageIOtest {

    public static boolean test(String addr,String name){
        BufferedImage image = null;
        try {
            URL httpUrl=new URL(addr);
            image= ImageIO.read(httpUrl);
            ImageIO.write(image,"png", new File("/home/songbo/"+name+".png"));
            //System.out.println(image.getWidth()+"  "+image.getHeight());
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(ImageIOtest.test("https://www.gravatar.com/avatar/ba17d0863fd9221a6cf16a6a5b09d66b.png","haha"));
    }
}
