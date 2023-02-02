import Plan.*;
import Policy.Customer;
import Policy.Policy;
import Policy.Vehicle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.*;

public class MainScreen extends JFrame {
    Font myFont = new Font("SansSerif", Font.BOLD,20);
    Color myColor = Color.GRAY;

    // Panel 1
    JTextField subFirstName;
    JTextField subLastName;
    JTextField subCity;
    JTextField subPhone;

    // Panel 2
    JTextField model;
    JTextField manufacturer;
    JTextField plateNum;
    JTextField estimated;
    JRadioButton damageRadioBtn1;
    JRadioButton damageRadioBtn2;
    JRadioButton damageRadioBtn3;
    JRadioButton damageRadioBtn4;
    ButtonGroup groupOne;

    // Panel 3
    JCheckBox obligatoryCheckbox;
    JCheckBox allRiskCheckbox;
    JCheckBox vehicleDamageCheckbox;
    JCheckBox driverDamageCheckbox;
    JCheckBox assistCheckbox;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRiskList = new ArrayList<>();


    // Panel 4
    JRadioButton yearRadioBtn1;
    JRadioButton yearsRadioBtn2;
    JRadioButton yearRadioBtn3;
    ButtonGroup groupTwo;
    JLabel todayLBL;
    int validityYear = 0;
    SimpleDateFormat sDf;
    Date currentDate;

    // panel 5
    JTextArea risksTXT;
    JTextField searchTXT;

    // panel 7
    JTextArea policyTXT;

    // Panel 8
    JTextArea customerTXT;


    // Panel 9
    JLabel claimingTXT;
    JLabel claimingTXT2;
    JTextField claimingCustomerField;


    // Panel 10
    JLabel claimingCustomerNameLBL;
    JLabel claimStatusLBL2;
    JTextArea claimingCustomerRisksCoveredAREA;
    JLabel claimingCustomerValidDateLBL;
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


    // Constructor
    public MainScreen(){
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
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Customer  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        p1.setBorder(titledBorder);


        JLabel firstNameLBL = new JLabel(" First Name");
        JLabel lastNameLBL = new JLabel(" Last Name");
        JLabel cityLBL = new JLabel(" City");
        JLabel phoneLBL = new JLabel(" Phone");

        subFirstName = new JTextField();
        subLastName = new JTextField();
        subCity = new JTextField();
        subPhone = new JTextField();

        p1.add(firstNameLBL);
        p1.add(subFirstName);
        p1.add(lastNameLBL);
        p1.add(subLastName);
        p1.add(cityLBL);
        p1.add(subCity);
        p1.add(phoneLBL);
        p1.add(subPhone);


        p1.setBounds(15,15,300,200);
        p1.setLayout(new GridLayout(4,2));

        setLayout(null);
        add(p1);
    }
    private void CustomizePanel2(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Vehicle  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p2 = new JPanel();
        p2.setBorder(titledBorder);


        JLabel plateNumLBL = new JLabel(" Plate Number");
        JLabel modelLBL = new JLabel(" Model Year");
        JLabel manufacturerLBL = new JLabel(" Manufacturer");
        JLabel estimatedLBL = new JLabel(" Estimated Value");
        JLabel spaceLBL = new JLabel(" ");
        JLabel damageLBL = new JLabel(" Major Damage");


        plateNum = new JTextField();
        model = new JTextField();
        manufacturer = new JTextField();
        estimated = new JTextField();


        damageRadioBtn1 = new JRadioButton();
        damageRadioBtn1.setText(" Motor");
        damageRadioBtn2 = new JRadioButton();
        damageRadioBtn2.setText(" Wheels");
        damageRadioBtn3 = new JRadioButton();
        damageRadioBtn3.setText(" Body");
        damageRadioBtn4 = new JRadioButton();
        damageRadioBtn4.setText(" None");

        groupOne = new ButtonGroup();
        groupOne.add(damageRadioBtn1);
        groupOne.add(damageRadioBtn2);
        groupOne.add(damageRadioBtn3);
        groupOne.add(damageRadioBtn4);


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
        p2.add(damageRadioBtn1);
        p2.add(damageRadioBtn2);
        p2.add(damageRadioBtn3);
        p2.add(damageRadioBtn4);


        p2.setBounds(15,250,300,500);
        p2.setLayout(new GridLayout(14,1));
        add(p2);
    }
    private void CustomizePanel3(){

        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Plan  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p3 = new JPanel();
        p3.setBorder(titledBorder);
        p3.setBounds(330,15,300,200);
        p3.setLayout(new GridLayout(6,1));

        JLabel packageLBL = new JLabel("Select a Plan");


        obligatoryCheckbox = new JCheckBox("Obligatory");
        allRiskCheckbox = new JCheckBox("All Risk");
        vehicleDamageCheckbox = new JCheckBox("Vehicle Damage");
        driverDamageCheckbox = new JCheckBox("Driver Damage");
        assistCheckbox = new JCheckBox("Assistance");


        GetRisksCoveredByPlan();


        p3.add(packageLBL);
        p3.add(obligatoryCheckbox);
        p3.add(allRiskCheckbox);
        p3.add(vehicleDamageCheckbox);
        p3.add(driverDamageCheckbox);
        p3.add(assistCheckbox);

        add(p3);

    }
    private void CustomizePanel4(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Validity Period  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p4 = new JPanel();
        p4.setBorder(titledBorder);
        p4.setBounds(330,250,300,250);
        p4.setLayout(new GridLayout(6,1));


        JLabel spacer2 = new JLabel(" ");
        yearRadioBtn1 = new JRadioButton();
        yearRadioBtn1.setText(" 1 Year");
        yearsRadioBtn2 = new JRadioButton();
        yearsRadioBtn2.setText(" 2 Years");
        yearRadioBtn3 = new JRadioButton();
        yearRadioBtn3.setText(" 3 Years");

        yearRadioBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear =1;
            }
        });
        yearsRadioBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 2;
            }
        });
        yearRadioBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 3;
            }
        });


        groupTwo = new ButtonGroup();
        groupTwo.add(yearRadioBtn1);
        groupTwo.add(yearsRadioBtn2);
        groupTwo.add(yearRadioBtn3);


        todayLBL = new JLabel();
        sDf = new SimpleDateFormat("MM/dd/yyyy");
        currentDate = new Date();
        todayLBL.setText("Today: " + sDf.format(currentDate));
        todayLBL.setOpaque(false);


        Font font = todayLBL.getFont();
        float size = font.getSize() + 3.0f;
        todayLBL.setFont( font.deriveFont(size) );


        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadioBtn1);
        p4.add(yearsRadioBtn2);
        p4.add(yearRadioBtn3);


        add(p4);

    }
    private void CustomizePanel5(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Actions  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p5 = new JPanel();
        p5.setBounds(330,520,300,230);
        p5.setBorder(titledBorder);
        p5.setLayout(new GridLayout(7,1));

        JButton saveBTN = new JButton("Save Customer");
        JButton showBTN = new JButton("Show Plan Details");
        JButton loadBTN = new JButton("Load Customer");
        JButton newBTN = new JButton("New Customer");

        searchTXT = new JTextField("Enter Car Plate Number");

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = "";
                for (int i =0; i< coveredRisksList.size();i++){
                    str += coveredRisksList.get(i) + "\n";
                }
                risksTXT.setText(str);


                try{
                    policyTXT.setText(GetPolicyData().toString());
                    DisplayPaymentsOfPolicy();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });


        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    SaveCustomerMapToDisk();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });

        JLabel spacer3 = new JLabel(" ");

        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchCustomerByMobileNB();

            }
        });


        JLabel spacer4 = new JLabel(" ");
        JLabel spacer5 = new JLabel(" ");
        JLabel spacer6 = new JLabel(" ");

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewCustomer();
            }
        });

        p5.add(spacer6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(spacer5);
        p5.add(searchTXT);
        p5.add(loadBTN);

        add(p5);

    }
    private void CustomizePanel6(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Covered Risks  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p6 = new JPanel();
        p6.setBorder(titledBorder);
        p6.setBounds(645,15,300,200);

        risksTXT = new JTextArea(7, 1);
        risksTXT.setEditable(false);
        risksTXT.setOpaque(false);
        risksTXT.setLineWrap(true);

        Font font = risksTXT.getFont();
        float size = font.getSize() + 3.0f;
        risksTXT.setFont( font.deriveFont(size) );

        p6.add(risksTXT);

        p6.setLayout(new GridLayout(1,1));
        add(p6);

    }
    public void CustomizePanel7(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Policy Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p7 = new JPanel();
        p7.setBounds(645,250,300,250);
        p7.setBorder(titledBorder);
        p7.setLayout(new GridLayout(6,1));

        policyTXT = new JTextArea(20,1);
        policyTXT.setEditable(false);
        policyTXT.setLineWrap(true);

        Font font = policyTXT.getFont();
        float size  = font.getSize() + 3.0f;
        policyTXT.setFont(font.deriveFont(size));


        p7.add(policyTXT);
        p7.setLayout(new GridLayout(1,1));
        add(p7);




    }
    public void CustomizePanel8(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Customer Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p8 = new JPanel();
        p8.setBorder(titledBorder);
        p8.setBounds(645, 520, 300, 230);
        p8.setLayout(new GridLayout(6, 1));

        customerTXT = new JTextArea(20, 1);
        customerTXT.setEditable(false);
        customerTXT.setLineWrap(true);


        Font font = customerTXT.getFont();
        float size = font.getSize() + 3.0f;
        customerTXT.setFont( font.deriveFont(size) );

        p8.add(customerTXT);

        p8.setLayout(new GridLayout(1,1));
        add(p8);



    }
    public void CustomizePanel9(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Claims  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);


        JPanel p9 = new JPanel();
        p9.setBorder(titledBorder);
        p9.setBounds(960, 15, 300, 485);

        claimingTXT = new JLabel("Enter plate number for the claiming customer");
        JLabel spacer99 = new JLabel("                                                         ");
        claimingTXT2 = new JLabel("Select the type of damage or assistance needed");

        claimingCustomerField = new JTextField();
        claimingCustomerField.setPreferredSize(new Dimension(250, 30));


        String[] items = { "Fire", "Robbery",
                "Third Party Damage",
                "Vehicle Damage"
                ,"Driver Damage",
                "Transport",
                "Car Replacement"};

        final JList claimList = new JList(items);

        claimList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);



        claimList.setPreferredSize(new Dimension(250, 150));

        JButton searchClaimer = new JButton("Search Customer");
        List<String> coveredRisksByUserLIST = new ArrayList<>();
        searchClaimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cond1 = false;
                cond2 = false;
                cond3 = false;

                try{
                    coveredRisksByUserLIST.clear();
                    Customer c = ClaimsSearchCustomerByMobileNb();
                    claimingCustomerNameLBL.setText("Claiming Customer: "+ c.getFirstName() + " " +c.getLastName());
                    cond1 = true;


                    String str7 = "";
                    for (int i = 0; i<c.getPolicy().getRisksCoveredList().size(); i++){
                        str7 += c.getPolicy().getRisksCoveredList().get(i) + " \n";
                        coveredRisksByUserLIST.add(c.getPolicy().getRisksCoveredList().get(i));
                    }

                    LocalDate v_validityofPolicy = c.getPolicy().getPolicyDate();
                    int v_policyVaslidityYears = c.getPolicy().getValidityYear();
                    v_validityofPolicy = v_validityofPolicy.plusYears(v_policyVaslidityYears);

                    CheckPolicyValidity(v_validityofPolicy);

                    claimingCustomerRisksCoveredAREA.setText("Covered Risks by Customer plan:\n" + str7);
                    claimingCustomerValidDateLBL.setText("Date Validity of Policy: " +v_validityofPolicy+"  || " +CheckPolicyValidity(v_validityofPolicy));

                    if (c.getPolicy().getRisksCoveredList().size() >=5){
                        cond2 = true;
                    }

                }catch (Exception re){
                    claimingCustomerNameLBL.setText("Claiming Customer: Not Found");
                }

            }
        });

        JButton confirmClaimBTN = new JButton("   Confirm Claim");
        confirmClaimBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedIx = claimList.getSelectedIndices();
                List<String> claimed_list = new ArrayList<>();


                if (claimList.getSelectedIndex() != -1) {
                    for (int i= 0; i< selectedIx.length; i++) {
                        String k = "" + claimList.getModel().getElementAt(selectedIx[i]) + " ";
                        claimed_list.add(""+claimList.getModel().getElementAt(selectedIx[i]));
                        System.out.print("" + k);
                    }
                }

                if (cond2 == false){
                    cond2 = claimed_list.containsAll(coveredRisksByUserLIST);
                }


                ClaimIsValid();

                Customer c = ClaimsSearchCustomerByMobileNb();
                if (ClaimIsValid()){
                    int claims_nb = claimed_list.size();
                    if (claimed_list.contains("Fire")){
                        settlementArea2.setText("Fire Department: " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 0.25 + " $");

                    }else if (claimed_list.contains("Robbery")){
                        settlementArea2.setText("ProSec Company: " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 0.5 + " $" +
                                "Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 1 + " $");

                    }else if  (claimed_list.contains("Third Party Damage")){
                        settlementArea2.setText("Driver in other Car: " + 2000 + "$");

                    }else if (claimed_list.contains("Vehicle Damage")){
                        settlementArea2.setText("Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 1+ " $");

                    }else if (claimed_list.contains("Driver Damage")) {
                        settlementArea2.setText("Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 10 + " $");

                    }else if (claimed_list.contains("Transport")){
                        settlementArea2.setText("Transport Company " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 0.5 + " $");

                    }else if (claimed_list.contains("Car Replacement")){
                        settlementArea2.setText("Car Rental Company " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 0.2 + " $");

                    }else if (claims_nb > 2){
                        settlementArea2.setText("Driver "
                                + c.getPolicy().getVehicle().getEstimatedValue() * 4 + " $"+
                                "Hospital " + c.getPolicy().getVehicle().getEstimatedValue() * 4
                                + " $ "+

                                "Car Rental Company "
                                + c.getPolicy().getVehicle().getEstimatedValue() * 0.2 + " $ "+
                                "Third Party Driver " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 2
                        );

                    }else{

                    }
                }
            }
        });


        p9.add(claimingTXT);
        p9.add(claimingCustomerField);
        p9.add(searchClaimer);
        p9.add(spacer99);
        p9.add(claimingTXT2);
        p9.add(claimList);
        p9.add(confirmClaimBTN);

        add(p9);








    }
    public void CustomizePanel10(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Claim Status", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p10 = new JPanel();
        p10.setBorder(titledBorder);
        p10.setBounds(960, 520, 300, 230);
        p10.setLayout(new GridLayout(4, 1));


        claimingCustomerNameLBL = new JLabel("Claiming Customer: ");
        claimingCustomerValidDateLBL = new JLabel("Date Validity of Policy: ");
        claimStatusLBL2 = new JLabel("Claiming Status: ");

        // JTextArea
        claimingCustomerRisksCoveredAREA = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(claimingCustomerRisksCoveredAREA);


        p10.add(claimingCustomerNameLBL);
        p10.add(claimingCustomerValidDateLBL);
        p10.add(pictureScrollPane);
        p10.add(claimStatusLBL2);

        add(p10);

    }
    public void CustomizePanel11(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Payments  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p11 = new JPanel();
        p11.setBorder(titledBorder);
        p11.setBounds(1275, 15, 250, 230);
        p11.setLayout(new GridLayout(2, 1));

        settlementArea = new JTextArea();
        settlementArea.setOpaque(false);


        Font font = settlementArea.getFont();
        float size = font.getSize() + 4.0f;
        settlementArea.setFont( font.deriveFont(size) );

        p11.add(settlementArea);
        add(p11);


    }
    public void CustomizePanel12(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Settlements  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel  p12 = new JPanel();
        p12.setBorder(titledBorder);
        p12.setBounds(1275,250,250,500);
        p12.setLayout(new GridLayout());

        settlementArea2 = new JTextArea();
        p12.add(settlementArea2);

        Font font = settlementArea2.getFont();
        float size = font.getSize() + 4.0f;
        settlementArea2.setFont(font.deriveFont(size));

        add(p12);

    }


    public Customer GetCustomerData() throws ParseException{
        Customer customer = new Customer(
                subFirstName.getText(),
                subLastName.getText(),
                subCity.getText(),
                Integer.parseInt(subPhone.getText()),
                GetPolicyData()
        );
        return  customer;
    }

    public Vehicle GetVehicleData() throws  ParseException{
        Vehicle vehicle = new Vehicle(
                Integer.parseInt(plateNum.getText()),
                Integer.parseInt(model.getText()),
                manufacturer.getText(),
                Integer.parseInt(estimated.getText()),
                GetDamageState());
        return vehicle;
    }


    public Policy GetPolicyData() throws ParseException{
        currentDate = new Date();

        LocalDate now = LocalDate.now();
        Policy policy = new Policy(
                GetVehicleData(),
                coveredRisksList,
                premiumRisksList,
                coverageRisksList,
                ceilingRiskList,
                validityYear,
                now );

        return policy;
    };


    public int GetDamageState(){

        if (damageRadioBtn1.isSelected()){
            return 1;
        }else if (damageRadioBtn2.isSelected()){
            return 2;
        }else if (damageRadioBtn3.isSelected()){
            return 3;
        }else
            return 0;

    };

    public void GetRisksCoveredByPlan(){
        AllRisk allRisk = new AllRisk();
        ObligatoryRisk obligatoryRisk = new ObligatoryRisk();
        allRiskCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverDamageCheckbox.setEnabled(false);
                vehicleDamageCheckbox.setEnabled(false);
                assistCheckbox.setEnabled(false);
                obligatoryCheckbox.setEnabled(false);


                for (int i = 0; i< allRisk.allRisksCovered.length;i++){
                    coveredRisksList.add(allRisk.allRisksCovered[i]);
                }
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRiskList.add(allRisk.getCeiling());
            }
        });

        obligatoryCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coveredRisksList.add(obligatoryRisk.obligatoryRisksCovered[0]);
                premiumRisksList.add(obligatoryRisk.getPremium());
                coverageRisksList.add(obligatoryRisk.getCoverage());
                ceilingRiskList.add(obligatoryRisk.getCeiling());

            }
        });

        vehicleDamageCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleRisk vehicleRisk = new VehicleRisk();

                coveredRisksList.add(vehicleRisk.vehicleRisksCovered[0]);
                premiumRisksList.add(vehicleRisk.getPremium());
                coverageRisksList.add(vehicleRisk.getCoverage());
                ceilingRiskList.add(vehicleRisk.getCeiling());

            }
        });

        driverDamageCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverRisk driverRisk = new DriverRisk();
                coveredRisksList.add(driverRisk.driverRisksCovered[0]);
                premiumRisksList.add(driverRisk.getPremium());
                coverageRisksList.add(driverRisk.getCoverage());
                ceilingRiskList.add(driverRisk.getCeiling());

            }
        });

        assistCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssistanceRisk assistanceRisk = new AssistanceRisk();

                for (int i = 0; i< assistanceRisk.assistanceRisksCovered.length; i++) {
                    coveredRisksList.add(assistanceRisk.assistanceRisksCovered[i]);
                }
                premiumRisksList.add(assistanceRisk.getPremium());
                coverageRisksList.add(assistanceRisk.getCoverage());
                ceilingRiskList.add(assistanceRisk.getCeiling());
            }
        });

    }

    public void SaveCustomerMapToDisk() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("D:/myfile.dat");
        int platenbmr = Integer.parseInt(plateNum.getText());

        if (!file.exists()) {
            System.out.println("Not Existed");
            file.createNewFile();

            SaveCustomerMaptoNewFile(platenbmr, file);
        } else {
            TreeMap<Integer, Customer> newMaptoSave = new TreeMap<>();
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();

            for (Map.Entry<Integer, Customer> m : mapInFile.entrySet()) {
                newMaptoSave.put(m.getKey(), m.getValue());
            }

            newMaptoSave.put(platenbmr, GetCustomerData());

            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(newMaptoSave);
            oos.flush();
            oos.close();

        }

    }

    private void SaveCustomerMaptoNewFile(int platenbmr, File file) throws ParseException, IOException {

        TreeMap<Integer, Customer> newMaptoSave = new TreeMap<>();

        newMaptoSave.put(platenbmr,GetCustomerData());

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMaptoSave);
        oos.flush();
        oos.close();
    }


    private void NewCustomer(){
        coverageRisksList.clear();
        coveredRisksList.clear();
        premiumRisksList.clear();
        ceilingRiskList.clear();

        cond1= false;
        cond2= false;
        cond3= false;

        subFirstName.setText("");
        subLastName.setText("");
        subCity.setText("");
        subPhone.setText("");
        plateNum.setText("");
        model.setText("");
        manufacturer.setText("");
        estimated.setText("");

        groupOne.clearSelection();
        groupTwo.clearSelection();

        obligatoryCheckbox.setSelected(false);
        allRiskCheckbox.setSelected(false);
        vehicleDamageCheckbox.setSelected(false);
        driverDamageCheckbox.setSelected(false);
        assistCheckbox.setSelected(false);

        driverDamageCheckbox.setEnabled(true);
        vehicleDamageCheckbox.setEnabled(true);
        assistCheckbox.setEnabled(true);
        obligatoryCheckbox.setEnabled(true);
    }


    private void SearchCustomerByMobileNB(){
        File file = new File("D:/myfile.dat");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer,Customer> mapInFile = (TreeMap<Integer,Customer>)ois.readObject();



            Customer c_finded = mapInFile.get(Integer.parseInt(searchTXT.getText()));
            customerTXT.setText(c_finded.toString());
            ois.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Customer ClaimsSearchCustomerByMobileNb(){
        Customer customer = new Customer();
        File file = new File("D:/myfile.dat");

        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile =  (TreeMap<Integer,Customer>)ois.readObject();

            ois.close();
            is.close();

            customer = mapInFile.get(Integer.parseInt(claimingCustomerField.getText()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return customer;
    }

    private boolean CheckPolicyValidity(LocalDate v_validityofPolicy){
        LocalDate now = LocalDate.now();

        if (now.isBefore(v_validityofPolicy)){
            cond3 = true;
            return true;
        }else{
            cond3 = false;
            return false;
        }
    }

    private boolean ClaimIsValid(){
        if (cond1 == true && cond2 == true && cond3 == true){
            claimStatusLBL2.setText("Claiming Status: You can register the claim");
            return true;
        }else{
            claimStatusLBL2.setText("Claiming Status: Cannot register");
            return false;
        }
    }

    private void DisplayPaymentsOfPolicy(){
        for (int i = 0; i< premiumRisksList.size(); i++){
            totalPremium += premiumRisksList.get(i);
            totalCoverage += coverageRisksList.get(i);
            totalCeiling += ceilingRiskList.get(i);
        }

        settlementArea.setText(
                "Total Premium: $"+totalPremium*Integer.parseInt(estimated.getText()) + "\n" +
                        "Risks Coverage: $" + totalCoverage*Integer.parseInt(estimated.getText()) * 10 + "\n" +
                        "Max Ceiling: $"+totalCeiling*Integer.parseInt(estimated.getText()) + 100000 + "\n"
        );
    }

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("InsuranceArc");
        mainScreen.setBounds(0, 0, 1920, 1080);
    }
}
