package com.turtlecat;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;


/**
 * ალექსანდრე პატარიძე
 * TurtleCat Studios
 * 2013
 * კოდი შეგიძლიათ გაავრცელოთ სურვილისამებრ, სახელი არ წაშალოთ დალშე პოხუი ^_^
 */
public class Beeui{

    private JPanel panel1;   //მთავარი პანელი
    private JTextField textField2;       //მობილურის ნომერი
    private JTextArea textArea1;         //ტექსტი
    private JTextField textField3;       //კაპჩას ველი
    private JButton send;               //გაგზავნის ღილაკი
    private JLabel captchaLabel;         // კაპჩას ადგილი პანელზე
    private JComboBox comboBox1;      // ინდექსების სია
    private JButton buttonLoadCaptcha;     //captcha-ს ჩასატვირთი ღილაკი
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel wordCounter;    //wordCounter -ასოების მთვლელი
    private JTable table1;   // ცხრილი
    private JScrollPane contactTable;   // ჩამოსაფურცლი
    private ImageIcon loading;

    private HtmlForm form;         //HTML ფორმა
    private WebClient bee;           //ვებკლიენტი
    private HtmlPage sendsms;        //სმს-ის გაგზავნის გვერდი
    private HtmlImage captcha;         //კაპჩას სურათი
    private HtmlSelect index;         //html combobox
    private HtmlOption option;         //ჩამონათვალი
    private HtmlImageInput sendButton;      //html image button

    private static String os;   //ოპერაციული სისტემის სახელი
    private static String userName; //მომხმარებლის სახელი
    private static File beeDir;    //ამ პროგრამის ფოლდერი სადაც ინახება ნომრების სია და captcha - სურათი
    public static String captchaloc;  //ამ საქაღალდეში(beeDir) მოთავსებული captcas სურათის მისამართი
    public Scanner scan;
    public static String numFileLoc; //ნომრების შესანახი
    public Formatter out;
    public DefaultTableModel model;   //ცხრილის მოდელი
    public static File beeFile;


    public static JFrame frame;

    public static void main(String[] args) {


        os=System.getProperty("os.name").toLowerCase();    //ოპერაციული სისტემის სახელის მინიჭება
        userName = System.getProperty("user.name");         // მომხმარებლის სახელის დათრევა
        System.out.println(System.getProperty("user.home")); //მომხმარებლის საქაღალდის დათრევა
        System.out.println(os);

        if(os.contains("lin")) {   //თუ შეიცავს lin
            try
            {
           //     UIManager.setLookAndFeel(new GTKLookAndFeel());
                beeDir = new File("/home/" + userName + "/.beesms");  //ფოლდერის მისამართი

                if(!beeDir.exists()){    //თუ არ არის ესეთი ფოლდერი
                    beeDir.mkdir();      //შექმენი
                }


                captchaloc = "/home/" +userName+ "/.beesms/captcha.jpg";   //ქაფჩას სურათის და ნომრების  მისამართი
                numFileLoc = "/home/" +userName+ "/.beesms/numbers.txt";

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(os.contains("mac")){
            try
            {
                //UIManager.setLookAndFeel(new NimbusLookAndFeel());
                beeDir = new File("/Users/" + userName + "/.beesms");

                captchaloc = "/Users/" +userName+ "/.beesms/captcha.jpg";
                numFileLoc = "/Users/" +userName+ "/.beesms/numbers.txt";

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(os.contains("win")){
            try
            {
                UIManager.setLookAndFeel(new WindowsLookAndFeel());
                beeDir = new File(System.getProperty("user.home") + "\\beesms");
                if(!beeDir.exists()){
                    beeDir.mkdir();

                }
                captchaloc = System.getProperty("user.home") + "\\beesms\\captcha.jpg";
                numFileLoc = System.getProperty("user.home") + "\\beesms\\numbers.txt";

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        beeFile = new File(numFileLoc);   //ნომრების ფაილი
        if(!beeFile.exists()){
            try {
                beeFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(beeFile.getAbsoluteFile());
        frame = new JFrame("BeeSMS");             //მთავარი ფანჯარა
        frame.setContentPane(new Beeui().panel1);     //
        frame.setPreferredSize(new Dimension(630,300)); //ფანჯრის ზომა
        frame.setResizable(false);  //მზარდი იყოს თუ არა ფანჯარა

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);


    }

    public Beeui() {
        textArea1.setLineWrap(true);     //სიტყევბის გადამტანი textArea-ში
        textArea1.setWrapStyleWord(true);  //როგორი სტილის მიხედვით გადაიტანოს ამ შემთხვევაში გადააქვს სიტყვის მიხედვით
        final String [] indexArray = {"592","568", "571", "597", "579", "574", "577", "593", "555", "558",
                                "557", "514", "599", "595", "591", "598", "551", "596", "570"};       //ნომრების მასივი



        model = new DefaultTableModel();    //მოდელს ვუთითებთ ახალი მოდელის ობიექტს

        table1.setModel(model);           //ცხრილის მოდელზე დაფუძნება
        model.addColumn("სახელი");
        model.addColumn("ნომერი");
        try{
            scan = new Scanner(new File(numFileLoc));   //ნომრების ფაილი numfileLoc
            while(scan.hasNext()){
                String a,b;
                a=scan.nextLine(); //es jer kuTxulobs saxels
                b=scan.nextLine(); //ბ კითხულობს ნომერს
                String [] info = {a,b};    // მასივში ვწერრთ
                model.addRow(info);      //მოდელზე ვამატებთ სტრიქონს ინფო მასივში შემავალი ინფორმაცია
            }

        }
        catch (Exception e){

            e.printStackTrace();
        }


        model.addTableModelListener(new TableModelListener() {   // მოდელის მსმენელი (listnere რომელიც ელოდება  მოქმედებას
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println("Table changed");

                try {
                    out = new Formatter(new File(numFileLoc)); // ფორმატერის ობიექტს გადავცემთ ნომრების ფაილს
                    for(int i=0; i<model.getRowCount(); i++){     //მოდელის სტრიქონების რაოდენობამდე

                        out.format(model.getValueAt(i, 0).toString() + "\n" + model.getValueAt(i, 1).toString() + "\n");  //ფაილში აანხლებს მოდელში ყოველ ჯერზე შეცვლილ ინფორმაციას ( getvalueit მოდელიდან მოაქ ჯერ სახელი და მერე ნომერი და გადაყავს სტრინგში )
                    }
                    out.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
            table1.addMouseListener(new MouseAdapter() { //ცხრილზე დაჭერა ანუ მსემენლი
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for(int i=0; i<indexArray.length; i++){  ///ციკლი მასივის ზომამდე
                    if(model.getValueAt(table1.getSelectedRow(),1).toString().substring(0,3).equals(indexArray[i])){  //მოდელიდან მოაქვს მნიშვნელობა ცხრილის მონიშნული სტრიქონიდან მეორე სტვეტს სტრინგში გადაგვყავს და ვიყენებთ პირველ 3 ციფრს  თუ ემთხვევა მასივის რომელიმე წევრს
                        comboBox1.setSelectedIndex(i);  //ამოირჩიოს დამთხვეული წევრი
                        textField2.setText(model.getValueAt(table1.getSelectedRow(),1).toString().substring(3,9));  //ჩაწეროს ინდექსის გარეშე ნომერი
                    }
                }

            }
        });


        comboBox1.setModel(new DefaultComboBoxModel(indexArray));  //comboboxs    ვაფუძნებთ მოდელზე და მასივზეა დაფუძნებული

        loading = new ImageIcon(Beeui.class.getResource("loading.gif"));  //რესურსი მოგვაქვს beeui კლასიდან

        buttonLoadCaptcha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker<Void, String>() {      //swinworkeri აკეთებს ახალ ნაკადს რომელიც მუშაბის დასრულებისგან მისცემს ბრძანებას რომ რაგაც უნდა შეიცვლაოს  //ინტერეისი დამხმარე ნაკადი
                    @Override
                    protected Void doInBackground() throws Exception {
                        if (!Thread.interrupted()) {    //თუ ნაკადი არ გაწყვეტილა
                            updateGui();       //გაანხლე ინტერფეისი
                        }
                        return null;
                    }
                }.execute();     //გაშევბა swingWorkeris
            }
        });
        captchaLabel.setText("captcha");

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textArea1.getText().length()>160 ){
                    JOptionPane.showMessageDialog(null, "ლიმიტია 160 მდე","შეცდომა", JOptionPane.WARNING_MESSAGE );
                }
                else{
                    form = (HtmlForm) sendsms.getFormByName("sendsms");     //

                    index = form.getSelectByName("smstoprefix");     //HtmlSelect-ის მოძებნა სახელის მიხედვით HtmlForm-ში


                    option = index.getOption(comboBox1.getSelectedIndex());       //HtmlOption არის  HtmlSelect-ის ნაწილი, იგივე ოფცია სიიდან. //ვირჩევთ HtmlSelect-დან   comboBox1-ში ამორჩეულ ელემენტს
                    option.setSelected(true);         //ვნიშნავთ ამორჩეულ ელემენტს
                    System.out.println(option.getText());    //შემოწმება იმისა თუ სწორად არის ამორჩეული ინდექსი

                    form.getInputByName("smsto").setValueAttribute(textField2.getText());   //ნომერს ვწერთ HtmlInput-ში    textField2-იდან

                    form.getTextAreaByName("dirtysmstext").setText(textArea1.getText());       //HtmlTextarea-ში ვწერთ  textArea1-დან წამოღებულ ტექსტს
                    sendButton = sendsms.getFirstByXPath("//input[@type='image']");         //XPath არის html-ში მისამართის მსგავსი რამ. //getFirstByXPath() მეთოდი გვიბრუნდებს პირველ html ელემენტს რომელიც დაემთხვა მოთხვონილ xpath-ს

                    form.getInputByName("confirmcode").setValueAttribute(textField3.getText());
                    try {
                        sendsms = (HtmlPage) sendButton.click();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    if(sendsms.getElementById("counterDiv")!=null){
                        System.out.println("SMS Sent");
                    }
                    else{
                        System.out.println("Failed to send SMS");
                    }

                }

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "პროგრამა დაწერილია TurtleCat Studios-ის მიერ.\n" +
                        "პროგრამაში გამოყენებულია gargoylesoftware-ის HtmlUnit API", "BeeSMS", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText().length()==6){          //ამოწმებს არის თუ არა ნომერის ველში შეყვანილი 6 ასო
                    String [] newData = {"", comboBox1.getSelectedItem().toString()+ textField2.getText()};    //თუ შეყვანილია იქმება ახალი სტრინგების მასივი რომელშიც პირველი ელემენტი (ანუ სახელი) ცარიელი სტრინგია შემდეგ იღებს კომბობოქსში ამორჩეულ ინდექსს მას ამატებს ველში შეყვანილ ნომერს და სვამს მასივში
                    model.addRow(newData);  //მასივი ემატება მოდელს
                }
                else{
                    String [] newData = {"",""};    //იქმნება სტრინგების მასივი ცარიელი სტრინგებით
                    model.addRow(newData);       //ემატება მოდელს ცარიელი მასივი
                }
            }
        });
        textArea1.addKeyListener(new KeyAdapter() {   //KeyAdapter არის ინტერფეისი რომელსაც აქვს მეთოდი keyTyped რომელიც იჭერს კლავიატურიდან არის თუ არა რამე შეყვანილი
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                wordCounter.setText(textArea1.getText().length() + "/160-დან");

                if (textArea1.getText().length() >= 160) {
                    wordCounter.setText("<html><font color='red'>" + wordCounter.getText() + "</font></html>");
                }
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeRow(table1.getSelectedRow());    //მოდელიდან ამოშალე სტრიქონი რომელიც ცხრილზე არის მონიშნული
            }
        });
    }
    public void loadCaptcha(){
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);      //ლოგერის გათიშვა


        bee = new WebClient(BrowserVersion.CHROME);//იქმნება ვებკლიენტის ობიექტი
        try {
            sendsms = (HtmlPage) bee.getPage("https://mobile.beeline.ge/ge/main/sms/send.wbp"); //მისამართძე გადასვლა
        } catch (IOException e) {
            e.printStackTrace();
        }


        captcha    = (HtmlImage) sendsms.getFirstByXPath("//img[@alt='Код']");  // პირველად აითრიე x მისართით//captcha დამცავი კოდი
        try {
            captcha.saveAs(new File(captchaloc));   // ფაილის ოქბიექტი იქმნება ამ კაპფჩა ლოგის მიხედით ინახავს შემდეგ კაფჩას შენახვა captchaloc
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void updateGui(){

        captchaLabel.setText("");
        captchaLabel.setIcon(loading);

        loadCaptcha();
        captchaLabel.setText("");
        System.out.println("shoud be loaded icon");
        try {
            captchaLabel.setIcon(new ImageIcon(ImageIO.read(new File(captchaloc)))); // სურათის იკონკის კლასის ობიექტს გადაეცემა ImageIO კლასის-ს ამოკითხული  ახალი ფაილის ობიექტი რომელიც დაფუძნებულია captchaloc-ზე ანუ კაპჩას სურათის მისამართზე
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
