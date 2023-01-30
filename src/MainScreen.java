import Policy.Customer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class MainScreen extends JFrame {

    Font myFont = new Font("SansSerif", Font.BOLD, 20);
    Color myColor = Color.GRAY;

    // Panel 1
    JTextField subfirstName;
    JTextField sublastName;
    JTextField subCity;
    JTextField subPhone;

    // Panel 2
    JTextField model;
    JTextField manufacturer;
    JTextField plateNum;
    JTextField estimated;
    JRadioButton damageRadio1;
    JRadioButton damageRadio2;
    JRadioButton damageRadio3;
    JRadioButton damageRadio4;
    ButtonGroup groupOne;

    // Panel 3
    JCheckBox obligatoryCheckbox;
    JCheckBox allRisksCheckbox;
    JCheckBox vehicleDamageCheckbox;
    JCheckBox driverDamageCheckbox;
    JCheckBox assistCheckbox;
    List<String> coveredRisksList = new ArrayList<>();
    List<String> premiumRisksList = new ArrayList<>();
    List<String> coverageRisksList = new ArrayList<>();
    List<String> ceilingRisksList = new ArrayList<>();

    //  Panel 4
    JRadioButton yearRadio;
    JRadioButton yearRadio2;
    JRadioButton yearRadio3;
    ButtonGroup groupTwo;
    JLabel todayLBL;
    int validityYear = 0;
    SimpleDateFormat dateFormat;
    Date currentDate;

    //  Panel 5
    JTextArea risksTxt;
    JTextField searchTxt;
    Map<Integer, Customer> customerMap = new TreeMap<>();

    //  Panel 7
    JTextArea policyTxt;

    // Panel 8
    JTextArea customerTxt;

    // Panel 9
    JLabel claimingTxt;
    JLabel claimingTxt2;
    JTextField claimingCustomerField;

    // Panel 10
    JLabel claimingCustomerNameLbl;
    JLabel claimStatusLbl2;
    JTextArea claimingCustomerRisksCoveredArea;
    JLabel claimingCustomerValidDateLbl;
    boolean cond1;
    boolean cond2;
    boolean cond3;

    // Panel 11
    JTextArea settlementArea;
    float totalPremium = 0f;
    float totalCoverage = 0f;
    float totalCeiling = 0f;

    // Panel 12
    JTextArea settlementArea2;


    public MainScreen() {
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        CustomizePanel8();
        CustomizePanel9();
        CustomizePanel10();
        CustomizePanel11();
        CustomizePanel12();
    }


    private void CustomizePanel1() {
        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Customer    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);

        p1.setBorder(titledBorder);

        JLabel firstNameLBL = new JLabel("First Name");
        JLabel lastNameLBL = new JLabel("Last Name");
        JLabel cityLBL = new JLabel("City");
        JLabel phoneLBL = new JLabel("Phone");

        subfirstName = new JTextField();
        subfirstName.setOpaque(false);
        sublastName = new JTextField();
        sublastName.setOpaque(false);
        subCity = new JTextField();
        subCity.setOpaque(false);
        subPhone = new JTextField();
        subPhone.setOpaque(false);

        p1.add(firstNameLBL);
        p1.add(subfirstName);
        p1.add(lastNameLBL);
        p1.add(sublastName);
        p1.add(cityLBL);
        p1.add(subCity);
        p1.add(phoneLBL);
        p1.add(subPhone);

        p1.setBounds(15, 15, 300, 200);
        p1.setLayout(new GridLayout(4, 2));

        setLayout(null);
        add(p1);

    }

    private void CustomizePanel2() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Vehicle    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        JPanel p2 = new JPanel();
        p2.setBorder(titledBorder);

        JLabel plateNumLBL = new JLabel(" Plate Number");
        JLabel modelLBL = new JLabel(" Model Year");
        JLabel manufacturerLBL = new JLabel(" Manufacturer");
        JLabel estimatedLBL = new JLabel(" Estimated Value");
        JLabel spaceLBL = new JLabel(" ");
        JLabel damageLBL = new JLabel(" Major Damage");

        plateNum = new JTextField();
        plateNum.setOpaque(false);
        model = new JTextField();
        model.setOpaque(false);
        manufacturer = new JTextField();
        manufacturer.setOpaque(false);
        estimated = new JTextField();
        estimated.setOpaque(false);

        damageRadio1 = new JRadioButton();
        damageRadio1.setText(" Motor");
        damageRadio2 = new JRadioButton();
        damageRadio2.setText("  Wheels");
        damageRadio3 = new JRadioButton();
        damageRadio3.setText(" Body");
        damageRadio4 = new JRadioButton();
        damageRadio4.setText(" None");

        groupOne = new ButtonGroup();
        groupOne.add(damageRadio1);
        groupOne.add(damageRadio2);
        groupOne.add(damageRadio3);
        groupOne.add(damageRadio4);

        p2.add(plateNumLBL);
        p2.add(plateNum);
        p2.add(modelLBL);
        p2.add(model);
        p2.add(manufacturerLBL);
        p2.add(manufacturer);
        p2.add(estimatedLBL);
        p2.add(estimated);
        p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(damageRadio1);
        p2.add(damageRadio2);
        p2.add(damageRadio3);
        p2.add(damageRadio4);

        p2.setBounds(15, 250, 300, 500);
        p2.setLayout(new GridLayout(14, 1));
        add(p2);


    }

    private void CustomizePanel3() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Plan    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        JPanel p3 = new JPanel();
        p3.setBorder(titledBorder);
        p3.setBounds(330,15,300,200);
        p3.setLayout(new GridLayout(6,1));

        JLabel packageLBL = new JLabel("Select Your Plan");

        obligatoryCheckbox = new JCheckBox("Obligatory");
        allRisksCheckbox = new JCheckBox("All Risk");
        vehicleDamageCheckbox = new JCheckBox("Vehicle Damage");
        driverDamageCheckbox = new JCheckBox("Driver Damage");
        assistCheckbox = new JCheckBox("Assistance");

        GetRisksCoveredByPlan();

        p3.add(packageLBL);
        p3.add(obligatoryCheckbox);
        p3.add(allRisksCheckbox);
        p3.add(vehicleDamageCheckbox);
        p3.add(driverDamageCheckbox);
        p3.add(assistCheckbox);

        add(p3);

    }

    private void CustomizePanel4() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Validity Period    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        JPanel p4 = new JPanel();
        p4.setBorder(titledBorder);
        p4.setBounds(330,250,300,250);
        p4.setLayout(new GridLayout(6,1));

        JLabel spacer2 = new JLabel(" ");
        spacer2.setOpaque(false);
        yearRadio = new JRadioButton();
        yearRadio.setText(" 1 Year");
        yearRadio2 = new JRadioButton();
        yearRadio2.setText(" 2 Years");
        yearRadio3 = new JRadioButton();
        yearRadio3.setText(" 3 Years");

        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 1;
            }
        });
        yearRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 2;
            }
        });
        yearRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 3;
            }
        });

        groupTwo = new ButtonGroup();
        groupTwo.add(yearRadio);
        groupTwo.add(yearRadio2);
        groupTwo.add(yearRadio3);

        todayLBL = new JLabel();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        currentDate = new Date();
        todayLBL.setText("Today: " + dateFormat.format(currentDate));
        todayLBL.setOpaque(false);

        Font font = todayLBL.getFont();
        float size = font.getSize() + 3.0f;
        todayLBL.setFont(font.deriveFont(size));

        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadio);
        p4.add(yearRadio2);
        p4.add(yearRadio3);
        p4.add(spacer2);
        p4.add(spacer2);

        add(p4);
    }

    private void CustomizePanel5() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Actions    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        JPanel p5 = new JPanel();
        p5.setBounds(330,520,300,230);
        p5.setBorder(titledBorder);
        p5.setLayout(new GridLayout(7,1));


        JButton saveBtn = new JButton("Save Customer");
        JButton showBtn = new JButton("Show Plan Details");
        JButton loadBtn = new JButton("Load Customer");
        JButton newBtn = new JButton("New Customer");

        JTextField searchTxt = new JTextField("Enter Car Plate Number");
        searchTxt.setOpaque(false);

        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JLabel spacer3 = new JLabel(" ");
        spacer3.setOpaque(false);

        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel spacer4 = new JLabel(" ");
        spacer4.setOpaque(false);
        JLabel spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);
        JLabel spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        p5.add(spacer6);
        p5.add(showBtn);
        p5.add(saveBtn);
        p5.add(newBtn);
        p5.add(spacer5);
        p5.add(searchTxt);
        p5.add(loadBtn);

        add(p5);


    }

    private void CustomizePanel6() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Covered Risks    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        JPanel p6 = new JPanel();
        p6.setBorder(titledBorder);
        p6.setBounds(645,15,300,200);

        risksTxt = new JTextArea(7,1);
        risksTxt.setEditable(false);
        risksTxt.setOpaque(false);
        risksTxt.setLineWrap(true);

        Font font = risksTxt.getFont();
        float size = font.getSize() + 3.0f;
        risksTxt.setFont(font.deriveFont(size));

        p6.add(risksTxt);
        p6.setLayout(new GridLayout(1,1));
        add(p6);



    }

    public void CustomizePanel7() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Policy Details    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);
        JPanel p7 = new JPanel();
        p7.setBounds(645,250,300,250);
        p7.setBorder(titledBorder);
        p7.setLayout(new GridLayout(6, 1));

        policyTxt = new JTextArea(20, 1);
        policyTxt.setEditable(false);
        policyTxt.setOpaque(false);
        policyTxt.setLineWrap(true);

        Font font = policyTxt.getFont();
        float size = font.getSize() + 3.0f;
        policyTxt.setFont(font.deriveFont(size));

        p7.add(policyTxt);
        p7.setLayout(new GridLayout(1, 1));
        add(p7);

    }

    public void CustomizePanel8() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Customer Details    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);

        JPanel p8 = new JPanel();
        p8.setBorder(titledBorder);
        p8.setBounds(645, 520, 300, 230);
        p8.setLayout(new GridLayout(6, 1));

        customerTxt = new JTextArea(20, 1);
        customerTxt.setEditable(false);
        customerTxt.setOpaque(false);
        customerTxt.setLineWrap(true);

        Font font = customerTxt.getFont();
        float size = font.getSize() + 3.0f;
        customerTxt.setFont(font.deriveFont(size));

        p8.add(customerTxt);
        p8.setLayout(new GridLayout(1,1));
        add(p8);

    }

    public void CustomizePanel9() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Claims    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);

        JPanel p9 = new JPanel();
        p9.setBorder(titledBorder);
        p9.setBounds(960, 15, 300, 485);

        claimingTxt = new JLabel("Enter the claiming customer's plate number");
        JLabel spacer99 = new JLabel("               ");
        claimingTxt2 = new JLabel("Select the type of damage or assistance needed");

        claimingCustomerField = new JTextField();
        claimingCustomerField.setPreferredSize(new Dimension(250,30));
        claimingCustomerField.setOpaque(false);

        String[] items = {
                "Fire",
                "Robbery",
                "Third Party Damage",
                "Vehicle Damage",
                "Driver Damage",
                "Transport",
                "Car Replacement"
        };

        final JList claimList = new JList(items);

        claimList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        claimList.setOpaque(false);

        claimList.setPreferredSize(new Dimension(250,150));

        JButton searchClaimer = new JButton("Search Customer");
        List<String> coveredRisksByUserList = new ArrayList<>();
        searchClaimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton confirmClaimBtn = new JButton("    Confirm Claim");
        confirmClaimBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        p9.add(claimingTxt);
        p9.add(claimingCustomerField);
        p9.add(searchClaimer);
        p9.add(spacer99);
        p9.add(claimingTxt2);
        p9.add(claimList);
        p9.add(confirmClaimBtn);
        add(p9);


    }

    public void CustomizePanel10() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Claim Status    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);

        JPanel p10 = new JPanel();
        p10.setBorder(titledBorder);
        p10.setBounds(960,520,300,230);
        p10.setLayout(new GridLayout(4,1));

        claimingCustomerNameLbl = new JLabel("Claiming Customer: ");
        claimingCustomerValidDateLbl = new JLabel("Date of Policy Validity: ");
        claimStatusLbl2 = new JLabel("Claiming Status: ");

        claimingCustomerRisksCoveredArea = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(claimingCustomerRisksCoveredArea);
        claimingCustomerRisksCoveredArea.setOpaque(false);

        p10.add(claimingCustomerNameLbl);
        p10.add(claimingCustomerValidDateLbl);
        p10.add(pictureScrollPane);
        p10.add(claimStatusLbl2);

        add(p10);


    }

    public void CustomizePanel11() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Payments    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);

        JPanel p11 = new JPanel();
        p11.setBorder(titledBorder);
        p11.setBounds(1275,15,250,230);
        p11.setLayout(new GridLayout(2,1));

        settlementArea = new JTextArea();
        settlementArea.setOpaque(false);

        Font font = settlementArea.getFont();
        float size = font.getSize() + 4.0f;
        settlementArea.setFont(font.deriveFont(size));

        p11.add(settlementArea);
        add(p11);


    }

    public void CustomizePanel12() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray, 1),
                        "    Payments    ",
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont, myColor);

        JPanel p12 = new JPanel();
        p12.setBorder(titledBorder);
        p12.setBounds(1275,250,250,500);
        p12.setLayout(new GridLayout());

        settlementArea2 = new JTextArea();
        settlementArea2.setOpaque(false);
        p12.add(settlementArea2);

        Font font = settlementArea2.getFont();
        float size = font.getSize() + 4.0f;
        settlementArea2.setFont(font.deriveFont(size));

        add(p12);

    }



    private void GetRisksCoveredByPlan() {

    }


    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("InsuranceArc");
        mainScreen.setBounds(0, 0, 1920, 1080);
    }


}
