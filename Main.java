import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String args[]){
        Panou p = new Panou( );
        p.pack();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    }
}

class Panou extends JFrame{
   private JButton jbCauta, jbCauta2, jbSterge,  jbExit, jbAdauga;

    private JTextField jtf1, jtf2, jtf3, jtf4, jtf5;

    public Panou(){
        this.setTitle("Biblioteca_Motoianu_Andrei");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jl1 = new JLabel("Titlul este :");
        jtf1 = new JTextField(15);
        JLabel jl2 = new JLabel("Autorul este :");
        jtf2 = new JTextField(15);
        JLabel jl3 = new JLabel("Numarul de pagini :");
        jtf3 = new JTextField(15);
        JLabel jl4 = new JLabel("Status :");
        jtf4 = new JTextField(15);
        JLabel jl5 = new JLabel("Cauta dupa nrPag :");
        jtf5 = new JTextField(15);



        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        JPanel jp5 = new JPanel();

        jp1.add(jl1);
        jp1.add(jtf1);
        jp2.add(jl2);
        jp2.add(jtf2);
        jp3.add(jl3);
        jp3.add(jtf3);
        jp4.add(jl4);
        jp4.add(jtf4);
        jp5.add(jl5);
        jp5.add(jtf5);


        JPanel jpA = new JPanel();
        jpA.setLayout(new GridLayout(3,1));
        jpA.add(jp1);
        jpA.add(jp2);
        jpA.add(jp3);
        jpA.add(jp4);
        jpA.add(jp5);


        AscultaButonCauta abc = new AscultaButonCauta();
        AscultaButonAdauga abA = new AscultaButonAdauga();
        AscultaButonCAUTA2 abP = new AscultaButonCAUTA2();
        AscultaButonSterge abS= new AscultaButonSterge();
        AscultaButonExit ab0 = new AscultaButonExit();

        jbCauta = new JButton("Cautare");
        jbCauta.addActionListener(abc);
        jbCauta2 = new JButton("Cauta nrPag ");
        jbCauta2.addActionListener(abP);
        jbAdauga = new JButton("Adauga ");
        jbAdauga.addActionListener(abA);
        jbSterge = new JButton("Sterge");
        jbSterge.addActionListener(abS);
        jbExit = new JButton("Iesire!");
        jbExit.addActionListener(ab0);

        JPanel jpB = new JPanel();
        jpB.add(jbCauta);
        jpB.add(jbCauta2);
        jpB.add(jbSterge);
        jpB.add(jbAdauga);
        jpB.add(jbExit);


      JPanel jp = new JPanel( );
      jp.setLayout(new GridLayout(3,1));
      jp.add(jpA);
      jp.add(jpB);

      Container cFinal = this.getContentPane( );
      cFinal.add(jp,"South");
    }

    class AscultaButonCauta implements ActionListener {
        public void actionPerformed(ActionEvent ev) {


            int gasit = 0;
            if (jtf2.getText().equals("")) {

                String s = jtf1.getText();
                gasit = carte.CautareLiniara(s);
                if (gasit > 0) jtf4.setText("S-au gasit"+" "+gasit+" "+"carti!");

                else

                    jtf4.setText("Doesn't exist!");

            } else
                if (jtf1.getText().equals("")) {

                String s = jtf2.getText();
                gasit = carte.CautareLiniaraAutor2(s);
                if (gasit > 0) jtf4.setText("S-au gasit"+" "+gasit+" "+"carti!");

                else

                    jtf4.setText("Doesn't exist!");

            }
        }
    }

    class AscultaButonCAUTA2 implements ActionListener{
        public void actionPerformed(ActionEvent ev){

            String s1 = jtf5.getText( );
            int gasit2 = Integer.parseInt(s1);
            gasit2 = carte.CautareLiniaraNrPagini3(s1);

            if(gasit2 > 0 )

                jtf4.setText("Doesn't exist!");

            else

                jtf4.setText("S-au gasit"+" "+gasit2+" "+"carti!");

            }
        }

    class AscultaButonAdauga implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            String titlu = jtf1.getText();
            String autor = jtf2.getText();
            String nrPag = jtf3.getText();
            carte.Adaugare(titlu, autor, nrPag);
        }
    }

    class AscultaButonSterge implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
            jtf4.setText("");
            jtf5.setText("");

        }
    }

    class AscultaButonExit implements ActionListener{
        public void actionPerformed (ActionEvent ev){
        System.exit(0);
        }
    }

}
