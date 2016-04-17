/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.*;

/**
 *
 * @author User
 */
public class FileIO implements Serializable{

    public void saveObject(Object o, String file) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(o);
        out.flush();
        out.close();
    }

    public Object getObject(String file)
            throws FileNotFoundException, IOException,
            ClassNotFoundException, EOFException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        return ois.readObject();
        
    }
}
