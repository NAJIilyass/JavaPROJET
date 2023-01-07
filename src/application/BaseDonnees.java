package application;

import java.io.*;

public class BaseDonnees {
    public static void Save(Agence a) throws IOException {
            FileOutputStream f = new FileOutputStream("AgenceMSN");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(a);
            o.close();
            f.close();
    }
    
    public static Agence Load() throws IOException, ClassNotFoundException {
            File tempFile = new File("AgenceMSN");
            boolean exists = tempFile.exists();
            if (exists){
                Agence a;
                FileInputStream f = new FileInputStream("AgenceMSN");
                ObjectInputStream o = new ObjectInputStream(f);
                a = (Agence) o.readObject();
                o.close();
                f.close();
                return a;
            } else{
            	BaseDonnees.Save(new Agence(1,0,0));
                return BaseDonnees.Load();
            }

    }
}