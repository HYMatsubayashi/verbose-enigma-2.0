package net.sourceforge.tess4j;

import java.io.File;
import net.sourceforge.tess4j.*;



import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.recognition.software.jdeskew.ImageDeskew;

import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.ImageHelper;
import net.sourceforge.tess4j.util.LoggHelper;


public class TesseractExample {
	
	
	private static final Logger logger = LoggerFactory.getLogger(new LoggHelper().toString());
	//static final double MINIMUM_DESKEW_THRESHOLD = 0.05d;
	static final double MINIMUM_DESKEW_THRESHOLD = 0.05d;
	ITesseract instance;
    //private final static String expOCRResult = "The (quick) [brown] {fox} jumps!\nOver the $43,456.78 <lazy> #90 dog";
	private final static String expOCRResult = "Weslley";
	
	

	public static void main(String[] args) throws IOException, TesseractException {
		
		File imageFile = new File("test-data\\eurotext.png");
		
		System.out.println("!!!!");
        System.out.println("!!!!"); 
        System.out.println("eurotext.png");
        System.out.println("!!!!");
        System.out.println("!!!!");
		
		ITesseract instance = new Tesseract();
		
		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		
		} catch (TesseractException e){
			System.err.println(e.getMessage());
		}
		
		
		///---------
		
		
		///public void testDoOCR_SkewedImage() throws Exception {
	        logger.info("doOCR on a skewed PNG image");
	        File imageFile2 = new File("test-data\\eurotext_deskew.png");
	        //File imageFile2 = new File("test-data\\eurotext90.png");
			//File imageFile2 = new File("test-data\\eurotext180.png");
	        //File imageFile2 = new File("test-data\\teste6.png");
	        
	        System.out.println("!!!!");
	        System.out.println("!!!!");
	        
	        System.out.println("test-data\\eurotext_deskew.png");
	        //System.out.println("test-data\\eurotext90.png");
	        //System.out.println("test-data\\eurotext180.png");
	        //System.out.println("test-data\\teste6.png");
	        
	        System.out.println("!!!!");
	        System.out.println("!!!!");
	        BufferedImage bi = ImageIO.read(imageFile2);
	        ImageDeskew id = new ImageDeskew(bi);
	        double imageSkewAngle = id.getSkewAngle(); // determine skew angle
	        if ((imageSkewAngle > MINIMUM_DESKEW_THRESHOLD || imageSkewAngle < -(MINIMUM_DESKEW_THRESHOLD))) {
	            bi = ImageHelper.rotateImage(bi, -imageSkewAngle); // deskew image
	        }

	        //String expResult = expOCRResult;
	        String result = instance.doOCR(bi);
	        logger.info(result);
	        System.out.println(result);
	       // assertEquals(expResult, result.substring(0, expResult.length()));
	  ///  }
		///------------------------
		
	        
	        
	        System.out.println("teste do xita");
	        //File imageFile3 = new File("test-data\\xita_deskew20.png");
	        File imageFile3 = new File("test-data\\TESTN.JPG");
	        //File imageFile3 = new File("test-data\\t_f03.jpg");
	        BufferedImage bi2 = ImageIO.read(imageFile3);
	        ImageDeskew id2 = new ImageDeskew(bi2);
	        double imageSkewAngle2 = id2.getSkewAngle(); // determine skew angle
	        if ((imageSkewAngle2 > MINIMUM_DESKEW_THRESHOLD || imageSkewAngle2 < -(MINIMUM_DESKEW_THRESHOLD))) {
	            bi2 = ImageHelper.rotateImage(bi2, -imageSkewAngle2); // deskew image
	        }

	        //String expResult2 = "The (quick) [brown] {fox} jumps!\nOver the $43,456.78 <lazy> #90 dog";
	        String result2 = instance.doOCR(bi2);
	        System.out.println(result2);
	       // assertEquals(expResult2, result2.substring(0, expResult2.length()));
	        
	        
	        
	    ////======================    

	}

	
	
	

}
