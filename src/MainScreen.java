import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
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


    public MainScreen() {
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
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
