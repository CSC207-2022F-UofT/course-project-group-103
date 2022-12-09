//package Screens;
//
//import Exceptions.UndefinedPropertyType;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class FilterPropertiesScreen extends JPanel implements ActionListener {
//    FilterPropertiesController filterPropertiesController;
//
//    JTextField minPrice = new JTextField(15);
//    JTextField maxPrice = new JTextField(15);
//    JComboBox type = new JComboBox();
//
//    public FilterPropertiesScreen(FilterPropertiesController controller) throws UndefinedPropertyType, IOException {
//        this.filterPropertiesController = controller;
//        JFrame frame = new JFrame("properties");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(312, 435);
//
//        JPanel titlePanel = new JPanel();
//        titlePanel.setSize(312, 43);
//        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        titlePanel.setAlignmentY(Component.TOP_ALIGNMENT);
//        frame.getContentPane().add(titlePanel);
//
//        JLabel title = new JLabel();
//        title.setText("Property");
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//        title.setAlignmentY(Component.TOP_ALIGNMENT);
//        titlePanel.add(title);
//        // input panel
//        JPanel inputPanel = new JPanel();
//        inputPanel.setSize(156, 42);
//        inputPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
//        inputPanel.setAlignmentY(Component.TOP_ALIGNMENT);
//
//        JScrollPane PropertyPanel = new JScrollPane();
//        PropertyPanel.setSize(312, 360);
//        PropertyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        PropertyPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
////        this.filterPropertiesController = controller;
////        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
////
////        // title
////        JLabel title = new JLabel("Filter Screen");
////        title.setAlignmentX(Component.CENTER_ALIGNMENT);
////        this.add(title);
////        // property info
////        for (ArrayList s: FilterPropertiesController.getPropertiesView(Float.parseFloat(minPrice.getText()), Float.parseFloat(maxPrice.getText()), type.getActionCommand())) {
////            for (Object i: s) {
////                JLabel l = new JLabel(i.toString());
////                l.setAlignmentX(Component.CENTER_ALIGNMENT);
////                this.add(l);
////            }
////        }
////        JLabel MinInfo = new JLabel("Set Min Price Amount: ");
////        JLabel MaxInfo = new JLabel("Set Max Price Amount: ");
////        JButton Filter = new JButton("Filter Properties");
////        MinInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
////        MaxInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
////        Filter.setAlignmentX(Component.CENTER_ALIGNMENT);
////        this.add(MinInfo);
////        this.add(MaxInfo);
////        this.add(minPrice);
////        this.add(maxPrice);
////        this.add(Filter);
//
//
//    }
//    @Override
//    // button pressed
//    public void actionPerformed(ActionEvent e) {
//    }
//}
