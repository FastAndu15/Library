import java.io.*;
import java.util.ArrayList;

public class carte {
    public String titlu;
    public String autor;
    public int nrPag;

    public carte(String titlu, String autor, int nrPagini) {
        this.titlu = titlu;
        this.autor = autor;
        this.nrPag = nrPagini;
    }

    public static int CautareLiniara(String cautat) {
        ArrayList<carte> al = new ArrayList<>();
        try {
            FileReader fr = new FileReader("biblio2.txt");
            BufferedReader bfr = new BufferedReader(fr);
            for (; ; ) {
                String titlu1 = bfr.readLine();
                if (titlu1 == null)
                    break;

                String autor1;
                autor1 = bfr.readLine();

                String qpagini = bfr.readLine();
                int nrPag = Integer.parseInt(qpagini);

                carte c = new carte(titlu1, autor1, nrPag);

                al.add(c);
            }
            bfr.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        int contor=0;
        for(int i=0;i<al.size();i++)
            if(cautat.equals(al.get(i).titlu))
                contor++;
        System.out.println(contor);
        return contor;
        }

    public static int CautareLiniaraAutor2(String cautat) {
        ArrayList<carte> al_autor = new ArrayList<>();
        try {
            FileReader fr = new FileReader("biblio2.txt");
            BufferedReader bfr = new BufferedReader(fr);
            for (; ; ) {
                String titlu1 = bfr.readLine();
                if (titlu1 == null)
                    break;

                String autor1;
                autor1 = bfr.readLine();

                String qpagini = bfr.readLine();
                int nrPag = Integer.parseInt(qpagini);

                carte c = new carte(titlu1, autor1, nrPag);

                al_autor.add(c);
            }
            bfr.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        int contor=0;
        for(int i=0;i<al_autor.size();i++)
            if(cautat.equals(al_autor.get(i).autor))
                contor++;
        System.out.println(contor);
        return contor;
    }

    public static int CautareLiniaraNrPagini3(String decautat) {
        ArrayList<carte> al_nrPag = new ArrayList<>();
        try {
            FileReader fr = new FileReader("biblio2.txt");
            BufferedReader bfr = new BufferedReader(fr);
            for (; ; ) {
                String titlu1 = bfr.readLine();
                if (titlu1 == null)
                    break;

                String autor1;
                autor1 = bfr.readLine();

                String qpagini = bfr.readLine();
                int nrPag = Integer.parseInt(qpagini);

                carte c = new carte(titlu1, autor1, nrPag);

                al_nrPag.add(c);
            }
            bfr.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        int contor=0;
        for(int i=0;i<al_nrPag.size();i++)
            if(decautat.equals(al_nrPag.get(i).nrPag))
                contor++;
        System.out.println(contor);
        return contor;
    }

    public static void Adaugare(String titlu, String autor, String nrPag){
        try{
            File file = new File("D:\\Proiect_Motoianu_Andrei_C312\\biblio2.txt");
            BufferedWriter carte = new BufferedWriter(new FileWriter(file.getName(),true));
            carte.write(titlu);
            carte.newLine();
            carte.write(autor);
            carte.newLine();
            carte.write(nrPag);
            carte.newLine();
            carte.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


