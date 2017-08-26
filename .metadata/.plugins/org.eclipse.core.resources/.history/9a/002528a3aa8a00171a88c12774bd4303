import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.custom.ScrolledComposite;

public class GUI {

	protected Shell shell;
	private Text txtFileDirectory;
	private Text txtTesseract;
	private Text txtOpencv;
	String directory;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(600, 400);
		shell.setText("SWT Application");
		
		txtFileDirectory = new Text(shell, SWT.BORDER);
		txtFileDirectory.setText("test-data\\eurotext.png");
		txtFileDirectory.setBounds(10, 20, 159, 25);
		
		Label lblImage = new Label(shell, SWT.BORDER);
		lblImage.setBounds(10, 51, 240, 281);
		
		Button btnSearch = new Button(shell, SWT.NONE);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try{
				directory  = txtFileDirectory.getText();
				Image img = new Image(null, directory);
				
				lblImage.setImage(img);
				} catch(Exception ee){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.ABORT);
					messageBox.setText("Warning");
					messageBox.setMessage("Imagem não encontrada!");
					 int buttonID = messageBox.open();
				}
			}
		});
		btnSearch.setBounds(175, 20, 75, 25);
		btnSearch.setText("Search...");
		
		Label lblTesseract = new Label(shell, SWT.NONE);
		lblTesseract.setBounds(270, 180, 55, 15);
		lblTesseract.setText("Tesseract");
		
		Label lblOpencv = new Label(shell, SWT.NONE);
		lblOpencv.setBounds(270, 338, 55, 15);
		lblOpencv.setText("OpenCV");
		
		Label lblImagemTeste = new Label(shell, SWT.NONE);
		lblImagemTeste.setBounds(94, 338, 75, 15);
		lblImagemTeste.setText("Imagem teste");
		
		Button btnReadImage = new Button(shell, SWT.NONE);
		btnReadImage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtTesseract.setText("teste");
				txtTesseract.setText("teste 02");
				
				try{
					File imageFile = new File(directory);	
					
					System.out.println("!!!!");
			        System.out.println("!!!!"); 
			        System.out.println("eurotext.png");
			        System.out.println("!!!!");
			        System.out.println("!!!!");
					
					ITesseract instance = new Tesseract();
					
					try {
						String result = instance.doOCR(imageFile);
						txtTesseract.setText(result);
						
						System.out.println(result);
					
					} catch (TesseractException ee){
						System.err.println(ee.getMessage());
					}
				} catch(Exception ee){
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.ABORT);
					messageBox.setText("Warning");
					messageBox.setMessage("Nenhuma imagem selecionada!");
					 int buttonID = messageBox.open();
					/* switch(buttonID) {
					   case SWT.YES:
					  // saves changes ...
					case SWT.NO:
					 // exits here ...
					  break;
					 case SWT.CANCEL:
					// does nothing ...
					 }*/

				}
				
				/*
				System.out.println("!!!!");
		        System.out.println("!!!!"); 
		        System.out.println("eurotext.png");
		        System.out.println("!!!!");
		        System.out.println("!!!!");
				
				ITesseract instance = new Tesseract();
				
				try {
					String result = instance.doOCR(imageFile);
					txtTesseract.setText(result);
					
					System.out.println(result);
				
				} catch (TesseractException ee){
					System.err.println(ee.getMessage());
				}*/
			}
		});
		btnReadImage.setBounds(385, 20, 75, 25);
		btnReadImage.setText("Read image");
		
		Label lblReadTimeTesseract = new Label(shell, SWT.NONE);
		lblReadTimeTesseract.setBounds(486, 180, 91, 15);
		lblReadTimeTesseract.setText("Read time: 00.00");
		
		Label lblReadTimeOpencv = new Label(shell, SWT.NONE);
		lblReadTimeOpencv.setBounds(486, 338, 91, 15);
		lblReadTimeOpencv.setText("Read time: 00.00");
		
		txtTesseract = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		txtTesseract.setText("Image text result");
		txtTesseract.setBounds(270, 53, 307, 120);
		
		txtOpencv = new Text(shell, SWT.BORDER);
		txtOpencv.setText("Image text result");
		txtOpencv.setBounds(270, 212, 307, 120);
		
		
		
	}

	public Text getTxtFileDirectory() {
		return txtFileDirectory;
	}

	public void setTxtFileDirectory(Text txtFileDirectory) {
		this.txtFileDirectory = txtFileDirectory;
	}
}
